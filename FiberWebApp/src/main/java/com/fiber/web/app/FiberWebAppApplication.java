package com.fiber.web.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fiber.web.app.common.FrontCtl;

@SpringBootApplication
@EnableWebMvc
public class FiberWebAppApplication {

	@Autowired
	FrontCtl frontCtl;


	public static void main(String[] args) {
		SpringApplication.run(FiberWebAppApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigure() {

		WebMvcConfigurer wc = new WebMvcConfigurer() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				CorsRegistration registraion = registry.addMapping("/**");
				registraion.allowedOrigins("http://localhost:4200");
				registraion.allowedHeaders("*");
				registraion.allowCredentials(true);
			}

			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				registry.addInterceptor(frontCtl).addPathPatterns("/**").excludePathPatterns("/Auth/**");
			}

			@Override
			public void addResourceHandlers(ResourceHandlerRegistry registry) {
				registry.addResourceHandler("/**").addResourceLocations("classpath:/public/");
			}
		};
		return wc;

	}
}
