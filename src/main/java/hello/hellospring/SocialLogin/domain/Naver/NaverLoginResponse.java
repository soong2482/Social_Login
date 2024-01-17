package hello.hellospring.SocialLogin.domain;

import lombok.Data;

@Data
public class NaverLoginResponse {
    private String resultcode;
    private String message;
    private ResponseData response;

    @Data
    public static class ResponseData {
        private String id;
        private String email;
        private String mobile;
        private String mobile_e164;
        private String name;
        private String birthday;
        private String gender;
        private String age;
        private String birthyear;
    }
}