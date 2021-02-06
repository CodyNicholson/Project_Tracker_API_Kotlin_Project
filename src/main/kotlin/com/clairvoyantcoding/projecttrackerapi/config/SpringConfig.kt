package com.clairvoyantcoding.projecttrackerapi.config

import com.clairvoyantcoding.projecttrackerapi.ProjecttrackerapiApplication
import org.modelmapper.ModelMapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.view.InternalResourceViewResolver

@Configuration
class SpringConfig {
    @Bean
    fun logger(): Logger? {
        return LoggerFactory.getLogger(ProjecttrackerapiApplication::class.java)
    }

    @Bean
    fun modelMapper(): ModelMapper? {
        return ModelMapper()
    }

    @Bean //NOTE: Used to render swagger-ui
    fun defaultViewResolver(): InternalResourceViewResolver? {
        return InternalResourceViewResolver()
    }
}