package Bai9.SpringDataJpa.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class UserConfiguration {

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        //user dc cấu hình trong InMemory sẽ dc ưu tiên hơn trong application.properties
        UserDetails u1 = User.withUsername("thu").password("{noop}thu123").roles("teacher").build();
        UserDetails u2 = User.withUsername("uyen").password("{noop}uyen123").roles("manager").build();
        UserDetails u3 = User.withUsername("kim").password("{noop}kim123").roles("admin").build();
        return new InMemoryUserDetailsManager(u1, u2, u3);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(
                configurer->configurer
                        .requestMatchers(HttpMethod.GET,"/api/students").hasAnyRole("teacher", "manager", "admin")
                        .requestMatchers(HttpMethod.GET,"/api/students/**").hasAnyRole("teacher", "manager", "admin")
                        .requestMatchers(HttpMethod.POST,"/api/students").hasAnyRole("manager", "admin")
                        .requestMatchers(HttpMethod.PUT,"/api/students/**").hasAnyRole("manager", "admin")
                        .requestMatchers(HttpMethod.DELETE,"/api/students/**").hasRole("admin")
        );
        http.httpBasic(Customizer.withDefaults());
        //csrf là để chống giả mạo khi gọi method nhưng vì đang làm vc vs
        // RESTapi nên ko qtam trạng thái (tìm hiểu thêm)
        http.csrf(csrf->csrf.disable());
        return http.build();

    }
}
