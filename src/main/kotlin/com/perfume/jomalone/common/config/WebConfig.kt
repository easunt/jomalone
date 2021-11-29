package com.perfume.jomalone.common.config

import com.perfume.jomalone.common.filter.AccessLoggingFilter
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.filter.CharacterEncodingFilter
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig():WebMvcConfigurer{

    @Bean
    fun getFilterRegistrationBean(): FilterRegistrationBean<AccessLoggingFilter> {
        val filterRegistrationBean = FilterRegistrationBean(AccessLoggingFilter())
        filterRegistrationBean.setName("LoggingFilter")
        filterRegistrationBean.addUrlPatterns("/api/v1/*")
        return filterRegistrationBean
    }

    @Bean
    fun characterEncodingFilter(): CharacterEncodingFilter {
        val characterEncodingFilter = CharacterEncodingFilter()
        characterEncodingFilter.encoding = "UTF-8"
        characterEncodingFilter.setForceEncoding(true)
        return characterEncodingFilter
    }
}