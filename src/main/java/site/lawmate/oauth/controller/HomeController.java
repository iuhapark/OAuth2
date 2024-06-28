package site.lawmate.oauth.controller;

import jakarta.servlet.http.HttpSession;
import lombok.*;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import site.lawmate.oauth.dto.SessionUser;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final HttpSession httpSession;

    // 메인 화면 - 게시판 목록
    @GetMapping("/")
    public String list(Pageable pageable, Model model) {
        // 세션에서 사용자 정보 꺼내기
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "list";
    }
}