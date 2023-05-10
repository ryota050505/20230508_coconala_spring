package jp.co.sss.sys.controller;

import jp.co.sss.sys.entity.Employee;
import jp.co.sss.sys.form.MyPageUpdateForm;
import jp.co.sss.sys.model.LoginUser;
import jp.co.sss.sys.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;

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
    public String mypage(@ModelAttribute MyPageUpdateForm myPageUpdateForm, Model model) {
        LoginUser loginUser = (LoginUser)session.getAttribute("loginUser");
        Employee employee = employeeService.findByEmpId(loginUser.getEmpId());
        myPageUpdateForm.setEmpName(employee.getEmpName());
        myPageUpdateForm.setPassword(employee.getPassword());
        myPageUpdateForm.setBirthday(employee.getBirthday());
        model.addAttribute("loginUser", loginUser);
        model.addAttribute("employee", employee);
        return "mypage";
    }

    @PutMapping("/mypage")
    public String mypage(@Validated MyPageUpdateForm myPageUpdateForm, BindingResult bindingResult, Model model) throws NotFoundException {
        if (bindingResult.hasErrors()) {
            return mypage(myPageUpdateForm, model);
        }
        LoginUser loginUser = (LoginUser)session.getAttribute("loginUser");
        employeeService.update(loginUser.getEmpId(), myPageUpdateForm);
        return "update";
    }
}

