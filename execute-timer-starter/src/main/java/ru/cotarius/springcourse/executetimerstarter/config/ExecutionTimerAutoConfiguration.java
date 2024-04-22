package ru.cotarius.springcourse.executetimerstarter.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.cotarius.springcourse.executetimerstarter.aop.ExecuteTimerAspect;

@Configuration
@EnableConfigurationProperties
public class ExecutionTimerAutoConfiguration {

    @Bean
    ExecuteTimerAspect executeTimerAspect() {
        return new ExecuteTimerAspect();
    }
}
