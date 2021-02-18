package io.springframework.common;

import io.springframework.common.autoconfigure.CommonBootProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
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
@EnableConfigurationProperties(CommonBootProperties.class)
@Slf4j
public class WebCommonAutoConfiguration {

    @PostConstruct
    public void init() {
        log.info("Web common validation initialized");
    }

}
