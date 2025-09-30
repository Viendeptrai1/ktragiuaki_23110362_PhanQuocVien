package org.example.ktragiuaki_23110362_phanquocvien.config;

import org.example.ktragiuaki_23110362_phanquocvien.controller.AdminGuard_23110362;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig_23110362 implements WebMvcConfigurer {

    private final AdminGuard_23110362 adminGuard;

    public WebMvcConfig_23110362(AdminGuard_23110362 adminGuard) {
        this.adminGuard = adminGuard;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(adminGuard).addPathPatterns("/admin/**");
    }
}
