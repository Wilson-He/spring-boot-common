package io.springframework.common.utils;

import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.function.Supplier;

/**
 * @author Wilson
 * @date 2019/10/31
 **/
@NoArgsConstructor
public class ObjectUtils {

    public static <S, T> T copyProperties(S source, T target) {
        BeanUtils.copyProperties(source, target);
        return target;
    }

    public static <S, T> T copyProperties(S source, Supplier<T> targetSupplier) {
        T target = targetSupplier.get();
        BeanUtils.copyProperties(source, target);
        return target;
    }
}
