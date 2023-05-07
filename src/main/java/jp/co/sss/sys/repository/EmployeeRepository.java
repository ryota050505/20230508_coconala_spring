package jp.co.sss.sys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.sss.sys.entity.Employee;

import java.util.Optional;

/**
 * リポジトリークラス
 * @author Inoue Nami
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
	public Optional<Employee> findByEmpId(String empId);
	public Employee findByEmpIdAndPassword(String empId,String password);
}