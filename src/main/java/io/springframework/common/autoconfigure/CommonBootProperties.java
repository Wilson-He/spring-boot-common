package io.springframework.common.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Wilson
 */
@ConfigurationProperties(prefix = "spring.common")
@Component
@Data
public class CommonBootProperties {
    private List<Class<?>> injectClasses;
    private GlobalResponse globalResponse;
    private Serialization serialization;

    @Data
    public static class Serialization {
        /**
         * 将long类型转string避免部分前端(如Swagger)显示精度丢失
         */
        private boolean parseLongToString = true;
    }

    @Data
    public static class GlobalResponse {
        /**
         * 是否启用全局返回{@link io.springframework.common.response.ServerResponse}
         */
        private boolean enable = true;
        /**
         * 设置指定路径不会返回{@link io.springframework.common.response.ServerResponse}
         */
        private List<String> ignorePaths = new ArrayList<>();
        /**
         * 全局headers
         */
        private Map<String, String> headers = new HashMap<>();
    }
}
