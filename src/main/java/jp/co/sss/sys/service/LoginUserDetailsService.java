package jp.co.sss.sys.service;

import jp.co.sss.sys.entity.Employee;
//import jp.co.sss.sys.form.LoginUserDetails;
import jp.co.sss.sys.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

//@Service
//@RequiredArgsConstructor
//public class LoginUserDetailsService implements UserDetailsService {
//    private final EmployeeRepository employeeRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<Employee> employee = employeeRepository.findByEmpId(username);
//        return employee.map(user -> new LoginUserDetails(user)).orElseThrow(() -> new UsernameNotFoundException("not found"));
//    }
//}
