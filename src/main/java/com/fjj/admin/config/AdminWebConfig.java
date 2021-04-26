package com.fjj.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //@Configuration表示该类是配置类
public class AdminWebConfig implements WebMvcConfigurer {

    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //为为拦截器中的拦截方法LoginInterceptor()添加要拦截的路径，以及要放行的路径
        //addPathPatterns("/**")拦截所有路径，包括静态资源css,js
        //excludePathPatterns("/","/login");放行"/","/login"
       /*registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/getTeacher","/user/findAll","/","/login","/css/**","/fonts/**","/images/**","/js/**");*/
    }

    //配置vue跨域请求
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("GET","HEAD","POST","PUT","DELETE","OPTIONS")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
    }
}
