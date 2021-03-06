package io.springframework.common.i18n;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

/**
 * @author Wilson
 * @version 0.2.1
 * @since 2021/6/17
 */
@Data
@Component
@ConfigurationProperties("i18n")
public class I18NMessage {
    /**
     * message-key:<lang:message>
     */
    private Map<String, Map<String, String>> message;
    /**
     * Default language setting (Default "cn").
     */
    private String defaultLang = "cn";

    /**
     * get i18n message
     *
     * @param key
     * @param language
     * @param formats  message string format
     * @return
     */
    public String message(I18NKey key, String language, Object... formats) {
        return Optional.ofNullable(message.get(key.key()))
                .map(map -> map.get(language == null ? defaultLang : language))
                .map(msg -> formats == null ? msg : String.format(msg, formats))
                .orElse(key.key());
    }

    /**
     * get i18n message
     *
     * @param key
     * @param language
     * @param formats  message string format
     * @return
     */
    public String message(String key, String language, Object... formats) {
        return Optional.ofNullable(message.get(key))
                .map(map -> map.get(language == null ? defaultLang : language))
                .map(msg -> formats == null ? msg : String.format(msg, formats))
                .orElse(key);
    }
}
