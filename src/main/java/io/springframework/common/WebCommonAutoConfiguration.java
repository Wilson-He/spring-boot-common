package io.springframework.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.springframework.common.autoconfigure.CommonBootProperties;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Optional;

/**
 * WebCommonAutoConfiguration-参数校验starter
 *
 * @author Wilson
 */
@Configuration
@ComponentScan
@AllArgsConstructor
@Slf4j
public class WebCommonAutoConfiguration {
    private final ObjectMapper objectMapper;
    private final CommonBootProperties properties;

    @PostConstruct
    public void init() {
        /*
         * 序列换成json时,将long转string避免swagger显示精度丢失
         */
        Optional.ofNullable(properties)
                .map(CommonBootProperties::getSerialization)
                .map(CommonBootProperties.Serialization::isParseLongToString)
                .ifPresent(isParsed -> {
                    if (isParsed) {
                        SimpleModule simpleModule = new SimpleModule();
                        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
                        simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
                        objectMapper.registerModule(simpleModule);
                    }
                });
        log.info("Web common validation initialized");
    }

}
