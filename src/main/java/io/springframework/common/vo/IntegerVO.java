package io.springframework.common.vo;

import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * IntegerVO
 *
 * @author Wilson
 */
@Setter
@ToString
public class IntegerVO {
    @NotNull
    private Integer value;

    public Integer value(){
        return this.value;
    }
}
