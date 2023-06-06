package com.study.board.controller;
import com.study.board.dto.MemberDTO;
import com.study.board.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MemberController {
    // 생성자 주입
    private final MemberService memberService;

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
        MemberDTO loginResult = memberService.login(memberDTO);
        if(loginResult != null) {
            // 로그인 성공
            session.setAttribute("Name", loginResult.getName());
            return "redirect:";
        }
        else {
            // 로그인 실패
            return "login";
        }
    }

    @GetMapping("/signup")
    public String signupForm() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute MemberDTO memberDTO) {
        memberService.save(memberDTO);
        System.out.println("memberDTO = " + memberDTO);
        return "redirect:";
    }

}
