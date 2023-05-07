package jp.co.sss.sys.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * エンティティクラス
 * @author Inoue Nami
 *
 */
@Entity
@Data
@Table(name = "employee")
public class Employee {

	/**
	 * 社員番号
	 */
	@Id
	@Column(name = "emp_id")
	private String empId;
	
	/**
	 * パスワード
	 */
	@Column(name = "password")
	private String password;
	
	/**
	 * 社員名
	 */
	@Column(name = "emp_name")
	private String empName;
	
	/**
	 * 生年月日
	 */
	@Column(name = "birthday")
	private String birthday;
	
	/**
	 * 性別
	 */
	@Column(name = "gender")
	private String gender;

}
