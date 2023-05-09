package jp.co.sss.sys.controller;

import jp.co.sss.sys.model.LoginUser;
import jp.co.sss.sys.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.sss.sys.entity.Employee;
import jp.co.sss.sys.form.LoginForm;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * コントローラークラス
 * @author Inoue Nami
 *
 */
@Controller
@RequiredArgsConstructor
public class IndexController {

	private final EmployeeService employeeService;
	private final HttpSession session;

	/**
	 * ログイン画面を表示する
	 * @param loginForm
	 * @return login.html
	 */
	@GetMapping("/login")
	public String login(@ModelAttribute LoginForm loginForm, Model model) {
		model.addAttribute("loginUser", session.getAttribute("loginUser"));
		return "login";
	}

	/**
	 * 入力された値を元にログイン認証し、トップ画面に遷移する
	 * @param loginForm
	 * @return top.html
	 */
	@PostMapping("/login")
	public String post(@Validated LoginForm loginForm, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
		// 入力フォームにエラーがあれば再度ログインページへ
		if (bindingResult.hasErrors()) {
			return login(loginForm, model);
		}
		//社員番号
	    String empId = loginForm.getEmpId();
	    //パスワード
	    String password = loginForm.getPassword();

	    //ログインユーザー取得
	    Employee employee = employeeService.findByEmpIdAndPassword(empId, password);

	    //ログインチェック
	    if(employee == null) {
			//存在しない場合
			model.addAttribute("errorMessage", "社員番号またはパスワードが違います。");
			return login(loginForm, model);
	    }else {
			// セッションにユーザーの情報を格納
			session.setAttribute("loginUser", new LoginUser(employee.getEmpName()));
			return "redirect:/top";
	    }
    }

	@GetMapping("/logout")
	public String logout() {
		session.invalidate(); // セッション破棄
		return "redirect:/login";
	}
}
