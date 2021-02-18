package io.springframework.common.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author Wilson
 * @since 2019/12/18
 **/
@Slf4j
@Configuration
@ConditionalOnProperty(value = "spring.common.serialization.longToString", havingValue = "true")
@AllArgsConstructor
public class JacksonSerializationConfig {
    private final ObjectMapper objectMapper;

    @PostConstruct
    public void init() {
        /*
         * 序列换成json时,将long转string避免swagger显示精度丢失
         */
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
        simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
        objectMapper.registerModule(simpleModule);
        log.info("JacksonSerializationConfig init complete...");
    }
}
