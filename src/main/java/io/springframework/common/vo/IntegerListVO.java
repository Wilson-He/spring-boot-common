package io.springframework.common.vo;

import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * IntegerListVO
 */
@Setter
@ToString
public class IntegerListVO {
    @NotNull
    @Size(min = 1)
    private List<Integer> values;

    public List<Integer> values(){
        return this.values;
    }
}
