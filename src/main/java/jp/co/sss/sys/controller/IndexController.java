package jp.co.sss.sys.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.sys.model.LoginUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.sys.entity.Employee;
import jp.co.sss.sys.form.LoginForm;
import jp.co.sss.sys.repository.EmployeeRepository;

/**
 * コントローラークラス
 * @author Inoue Nami
 *
 */
@Controller
@RequiredArgsConstructor
public class IndexController {

	private final EmployeeRepository empRepository;

	private final LoginUser loginUser;
	

	/**
	 * ログイン画面を表示する
	 * @param loginForm
	 * @return login.html
	 */
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String login(LoginForm loginForm) {

		return "login";
	}

	/**
	 * 入力された値を元にログイン認証し、トップ画面に遷移する
	 * @param loginForm
	 * @param req
	 * @param res
	 * @return top.html
	 */
	@RequestMapping(path = "/top", method = RequestMethod.POST)
	public String login(LoginForm loginForm, HttpServletRequest req, HttpServletResponse res ) {
		
		//社員番号
	    String empId = loginForm.getEmpId();
	    //パスワード
	    String password = loginForm.getPassword();

	    
	    //ログインユーザー取得
	    Employee employee = empRepository.findByEmpIdAndPassword(empId, password);

	    //ログインチェック
	    if(employee == null) {
		      //存在しない場合
		      return "login";
    

	    }else {
	      //存在した場合
//	      List<Employee> employeeList = empRepository.findAll();
//	      req.setAttribute("loginUser", employee);
//	      req.setAttribute("loginList", employeeList);
	      loginUser.setUsername(employee.getEmpId());
		  return "redirect:/top";
	    }
    }
}
