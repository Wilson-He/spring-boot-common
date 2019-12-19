package io.springframework.common.vo;

import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * LongVO
 *
 * @author Wilson
 */
@Setter
@ToString
public class LongVO {
    @NotNull
    private Long value;

    public Long value(){
        return this.value;
    }
}
