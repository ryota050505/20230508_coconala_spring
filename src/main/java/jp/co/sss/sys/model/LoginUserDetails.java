package jp.co.sss.sys.model;

//import jp.co.sss.sys.entity.Employee;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Arrays;
//import java.util.Collection;

//public class LoginUserDetails implements UserDetails {
//    private final Employee loginUser;
//    private final Collection<? extends GrantedAuthority> authorities;
//
//    public LoginUserDetails(Employee loginUser) {
//        this.loginUser = loginUser;
//        this.authorities = Arrays.asList(new SimpleGrantedAuthority("ADMIN"));
//    }
//
//    public Employee getLoginUser() { return loginUser; }
//
//    @Override
//    public String getPassword() { return loginUser.getPassword(); }
//
//    @Override
//    public String getUsername() { return loginUser.getEmpId(); }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    @Override
//    public boolean isAccountNonExpired(){
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
