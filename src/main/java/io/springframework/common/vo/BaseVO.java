package io.springframework.common.vo;

import io.springframework.common.utils.ObjectUtils;

import java.util.function.Supplier;

/**
 * BaseVO
 *
 * @author Wilson
 * @date 2020/2/11
 */
public abstract class BaseVO {
    public <T> T copyProperties(Supplier<T> supplier) {
        return ObjectUtils.copyProperties(this, supplier);
    }

    public <T> T copyProperties(T t) {
        return ObjectUtils.copyProperties(this, t);
    }
}
