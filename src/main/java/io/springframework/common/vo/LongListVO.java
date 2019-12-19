package io.springframework.common.vo;

import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * LongListVO
 *
 * @author Wilson
 */
@Setter
@ToString
public class LongListVO {

    @NotNull
    @Size(min = 1)
    private List<Long> values;

    public List<Long> values(){
        return this.values;
    }
}
