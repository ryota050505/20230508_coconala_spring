package jp.co.sss.sys.controller;

import jp.co.sss.sys.model.LoginUser;
import jp.co.sss.sys.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    private final LoginUser loginUser;
    @GetMapping("/top")
    public String top(Model model)
    {
        model.addAttribute("loginList", employeeService.findAll());
        model.addAttribute("loginUser", employeeService.findByEmpId(loginUser.getUsername()));
        return "top";
    }

    @GetMapping("/mypage")
    public String mypage(Model model)
    {
//        model.addAttribute();
        return "mypage";
    }
}
