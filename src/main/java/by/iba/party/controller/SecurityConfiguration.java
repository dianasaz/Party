//package by.iba.party.controller;
//
//import org.springframework.beans.fa   ctory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import javax.sql.DataSource;
//
//@Configuration
//@Component
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//    @Autowired
//    @Qualifier("datasource")
//    private DataSource dataSource;
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().dataSource(dataSource)
//                .authoritiesByUsernameQuery("select login, role, id FROM user where login=?")
//                .usersByUsernameQuery("select login, password as password, id FROM user where login=?")
//                .passwordEncoder(new BCryptPasswordEncoder());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .httpBasic()
//                .and()
//                .authorizeRequests()
//                .anyRequest().authenticated();
//
//        http.csrf().disable();
//
//    }
//}