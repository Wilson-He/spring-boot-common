package io.springframework.common.response;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Wilson
 */
public class HeaderCache {
    private static final ConcurrentHashMap<String, String> REFRESH_HEADERS = new ConcurrentHashMap<>();

    public static String refreshHeader(String key, String value){
        if(value != null){
            REFRESH_HEADERS.put(key,value);
        }
        return value;
    }

    public static ConcurrentHashMap<String, String> refreshHeaders(){
        return REFRESH_HEADERS;
    }

    public static boolean hasRefreshTimeHeaders(){
        return REFRESH_HEADERS.isEmpty();
    }

}
