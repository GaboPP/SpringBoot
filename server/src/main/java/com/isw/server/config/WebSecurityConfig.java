package com.isw.server.config;
 
import com.isw.server.CustomLoginSuccessHandler;
import com.isw.server.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
    @Autowired
    UserDetailsServiceImpl userDetailsService;
 
    @Autowired
    private CustomLoginSuccessHandler successhandler;
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
     
     
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { 
 
        // Setting Service to find User in the database.
        // And Setting PassswordEncoder
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());     
 
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        http.csrf().disable();
 
        // The pages does not require login
        http.authorizeRequests().antMatchers("/css/**","/static/**","/images/**","/login", "/logout").permitAll();
 
        // /pagina en comun page requires login as participante or mentor.
        // If no login, it will redirect to /login page.
        // http.authorizeRequests().antMatchers("/").access("hasAnyRole('participante', 'mentor', 'supervisor')");
 
        // When the user has logged in as XX.
        // But access a page that requires role YY,
        // AccessDeniedException will be thrown.
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
 
        // Config for Login Form
        http.authorizeRequests()
                .antMatchers("/proyectos/**").hasAnyAuthority("supervisor", "mentor")
                .antMatchers("/mentor").hasAnyAuthority("mentor")
                .antMatchers("/tasks/**").hasAnyAuthority("participante")
                .anyRequest().authenticated()
                .and().formLogin()//
                // Submit URL of login page.
                .loginProcessingUrl("/j_spring_security_check") // Submit URL
                .loginPage("/login")//
                .permitAll()
                .successHandler(successhandler)
                .failureUrl("/login?error=true")//
                .usernameParameter("username")//
                .passwordParameter("password")
                // Config for Logout Page
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful"); 
    }
}