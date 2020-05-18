package org.beesley.pitrain.broker;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {
  @Bean
  ServletRegistrationBean<WebServlet> h2servletRegistration() {
    ServletRegistrationBean<WebServlet> registrationBean =
        new ServletRegistrationBean<WebServlet>(new WebServlet());
    registrationBean.addUrlMappings("/console/*");
    return registrationBean;
  }

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**").allowCredentials(true);
  }
}
