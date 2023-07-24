package com.example.spring.config;

import com.example.spring.interceptor.AuthenticationInterceptor;
import com.example.spring.interceptor.AuthorizationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    private final List<String> ignorePaths = Arrays.asList("/login", "/register", "/logout", "/bootstrap/**", "/fontawesome/**", "/i18n/**", "/css/**", "/js/**");

    @Autowired
    private AuthenticationInterceptor authenticationInterceptor;

    @Autowired
    private AuthorizationInterceptor authorizationInterceptor;

    @Bean
    public MessageSource messageSource() { // message resource
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:/i18n/messages");
        return messageSource;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }

    @Bean(name="localeResolver")
    public SessionLocaleResolver sessionLocaleResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(new Locale("en"));
        return localeResolver;
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.localeChangeInterceptor());
        registry.addInterceptor(authenticationInterceptor).order(1).excludePathPatterns(ignorePaths);
        registry.addInterceptor(authorizationInterceptor).order(2).excludePathPatterns(ignorePaths);
    }
}