package hello.hellospring.SocialLogin.service;


import hello.hellospring.SocialLogin.domain.NaverLoginResponse;
import hello.hellospring.SocialLogin.domain.User;
import hello.hellospring.SocialLogin.dto.NaverLoginBodyClass;
import hello.hellospring.SocialLogin.mapper.UserMapper;
import hello.hellospring.SocialLogin.webclient.WebClientImpli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class LoginService {
    private final UserMapper userMapper;
    static WebClientImpli webClientImpli;
    private final String clientId;
    private final String clientSecret;
    private final String grantType;

    @Autowired
    public LoginService(
            UserMapper userMapper,
            @Value("${naver.ClientID}") String clientId,
            @Value("${naver.ClientSecret}") String clientSecret,
            @Value("${naver.grantType}") String grantType
    ) {
        this.userMapper = userMapper;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.grantType = grantType;
    }

    public User naverLoginAsync(String code, String state) {
        NaverLoginBodyClass naverLoginBodyClass = new NaverLoginBodyClass();
        naverLoginBodyClass.setCode(code);
        naverLoginBodyClass.setClientSecret(clientSecret);
        naverLoginBodyClass.setClientId(clientId);
        naverLoginBodyClass.setGrantType(grantType);
        naverLoginBodyClass.setState(state);
        Mono<NaverLoginResponse> naverLoginResponse = webClientImpli.getNaverUser(webClientImpli.getNaverToken(naverLoginBodyClass));
        NaverLoginResponse naveruser = naverLoginResponse.block();
        User user = userMapper.CheckUser(naveruser.getResponse().getId());

        if (user == null) {
            LocalDateTime currentDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = currentDateTime.format(formatter);
            User SignUpUser = new User();
            SignUpUser.setCreateDate(formattedDateTime);
            SignUpUser.setEmail(naveruser.getResponse().getEmail());
            SignUpUser.setUsername(naveruser.getResponse().getName());
            SignUpUser.setSnsType("NAVER");
            SignUpUser.setSnsId(naveruser.getResponse().getId());
            SignUpUser.setNickname(naveruser.getResponse().getName());
            userMapper.SignUp(SignUpUser);
            return SignUpUser;
        }
        return user;
    }
}

