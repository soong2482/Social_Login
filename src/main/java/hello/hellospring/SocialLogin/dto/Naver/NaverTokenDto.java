package hello.hellospring.SocialLogin.dto;

import lombok.Data;

@Data
public class NaverTokenDto {
    private String access_token;
    private String refresh_token;
    private String token_type;
    private String expires_in;
}
