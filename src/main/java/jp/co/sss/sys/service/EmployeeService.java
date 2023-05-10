package jp.co.sss.sys.service;

import jp.co.sss.sys.entity.Employee;
import jp.co.sss.sys.form.MyPageUpdateForm;
import jp.co.sss.sys.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

    public void update(String empId, MyPageUpdateForm myPageUpdateForm) throws NotFoundException {
        Employee employee = employeeRepository.findByEmpId(empId);
        if (Objects.isNull(employee)) {
            throw new NotFoundException();
        }

        employee.setEmpName(myPageUpdateForm.getEmpName());
        employee.setPassword(myPageUpdateForm.getPassword());
        employee.setBirthday(myPageUpdateForm.getBirthday());
        employeeRepository.save(employee);
    }
}
