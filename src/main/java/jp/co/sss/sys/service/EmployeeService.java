package jp.co.sss.sys.service;

import jp.co.sss.sys.entity.Employee;
import jp.co.sss.sys.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findByEmpIdAndPassword(String empId, String password) {
        return employeeRepository.findByEmpIdAndPassword(empId, password);
    }

    public Employee findByEmpId(String empId) {
        return employeeRepository.findByEmpId(empId);
    }
}
