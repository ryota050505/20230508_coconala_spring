package jp.co.sss.sys.config;

//import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;

//@EnableWebSecurity
//@EnableGlobalMethodSecurity
//@Configuration
public class SecurityConfig {
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.formLogin(login->login
//                .loginProcessingUrl("/login")
//                .loginPage("/login")
//                .defaultSuccessUrl("/top")
//                .failureUrl("/login?error")
//                .permitAll()
//        ).logout(logout -> logout
//                .logoutSuccessUrl("/login")
//        ).authorizeHttpRequests(authz -> authz
//                .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
//                    .permitAll()
//                .anyRequest().authenticated()
//        );
//        return http.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}
