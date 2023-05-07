package jp.co.sss.sys.controller;

import jp.co.sss.sys.model.LoginUser;
import jp.co.sss.sys.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final HttpSession session;

    @GetMapping("/top")
    public String top(Model model) {
        model.addAttribute("employeeList", employeeService.findAll());
        model.addAttribute("loginUser", session.getAttribute("loginUser"));
        return "top";
    }

    @GetMapping("/mypage")
    public String mypage(Model model) {
        // TODO: 自分の情報をフロントに返却する
        model.addAttribute("loginUser", session.getAttribute("loginUser"));
        return "mypage";
    }
}

