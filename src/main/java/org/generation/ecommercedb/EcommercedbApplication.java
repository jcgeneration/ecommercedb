package org.generation.ecommercedb;
import org.generation.ecommercedb.jwt.config.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class EcommercedbApplication {
	public static void main(String[] args) {
		SpringApplication.run(EcommercedbApplication.class, args);
	}//main
	@Bean
	public FilterRegistrationBean<JwtFilter> jwtFilter() {
		FilterRegistrationBean<JwtFilter> registrationBean =
				new FilterRegistrationBean<>();	
		registrationBean.setFilter( new JwtFilter());
		//registrationBean.addUrlPatterns("/api/user/*");
	    //registrationBean.addUrlPatterns("/api/productos/*");
		return registrationBean;
	} // jwtFilter
	
} //class
