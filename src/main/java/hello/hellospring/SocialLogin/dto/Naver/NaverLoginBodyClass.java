package hello.hellospring.SocialLogin.dto;

import lombok.Data;

@Data
public class LoginBodyClass {
    private String grantType;
    private String clientId;
    private String clientSecret;
    private String code;
    private String state;
}
