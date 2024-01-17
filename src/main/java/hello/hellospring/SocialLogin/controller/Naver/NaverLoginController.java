package hello.hellospring.SocialLogin.controller;

import hello.hellospring.SocialLogin.domain.User;
import hello.hellospring.SocialLogin.service.NaverLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/auth/member/login")
@RequiredArgsConstructor
public class LoginController {
    private final NaverLoginService loginService;

    @PostMapping("/naver")
    @ResponseBody
    public User doSocialLogin(@RequestParam String code, @RequestParam String state) {
        return loginService.naverLoginAsync(code, state);
    }
}
