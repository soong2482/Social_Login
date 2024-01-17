package hello.hellospring.SocialLogin.webclient;


import hello.hellospring.SocialLogin.domain.Naver.NaverLoginResponse;
import hello.hellospring.SocialLogin.dto.Naver.NaverLoginBodyClass;
import hello.hellospring.SocialLogin.dto.Naver.NaverTokenDto;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.function.Function;

public class WebClientImpli {
    private static WebClient clientForApi1 = WebClient.create("https://nid.naver.com");
    private static WebClient NaverProfileApi = WebClient.create("https://openapi.naver.com");


    public static Mono<NaverTokenDto> getNaverToken(NaverLoginBodyClass naverLoginBodyClass){
        return clientForApi1.post()
                .uri(uriBuilder -> uriBuilder.path("/oauth2.0/token")
                .queryParam("code", naverLoginBodyClass.getCode())
                .queryParam("client_id", naverLoginBodyClass.getClientId())
                .queryParam("client_secret", naverLoginBodyClass.getClientSecret())
                .queryParam("grant_type", naverLoginBodyClass.getGrantType())
                .queryParam("state", naverLoginBodyClass.getState())
                .build())
                .retrieve()
                .bodyToMono(NaverTokenDto.class);
    }
    public static Mono<NaverLoginResponse> getNaverUser(Mono<NaverTokenDto> naverTokenMono) {
        return naverTokenMono.flatMap(naverTokenDto ->
                Mono.just(naverTokenDto.getAccess_token())
                        .map(cookieValue ->
                                NaverProfileApi.get()
                                        .uri(uriBuilder -> uriBuilder.path("/v1/nid/me").build())
                                        .header("Authorization", "Bearer "+ cookieValue)
                                        .retrieve()//=네이버 디벨로퍼들어가서 LoginResponse수정해 오는정보에맞게끔
                                        .bodyToMono(NaverLoginResponse.class)
                        )
                        .flatMap(Function.identity())
        );
    }



}
