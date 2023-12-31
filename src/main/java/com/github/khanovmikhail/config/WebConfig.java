package com.github.khanovmikhail.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "com.github.khanovmikhail")
@EnableWebMvc
public class WebConfig {
}