package io.springframework.common.vo;

import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * StringListVO
 *
 * @author Wilson
 */
@Setter
@ToString
public class StringListVO {
    @NotNull
    @Size(min = 1)
    private List<String> values;

    public List<String> values(){
        return this.values;
    }
}
