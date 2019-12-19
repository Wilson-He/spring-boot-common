package io.springframework.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * WebCommonAutoConfiguration-参数校验starter
 *
 * @author Wilson
 */
@Configuration
@ComponentScan
@Slf4j
public class WebCommonAutoConfiguration {

    @PostConstruct
    public void init() {
        log.info("Web common validation initialized");
    }

}
