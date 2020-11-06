package ph.com.zenprint.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ph.com.zenprint.constant.ResponseCode;

import java.util.List;

/**
 * @author Choy
 * @date 11/2/2020.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonPropertyOrder({
        "code",
        "message",
        "data",
        "errors"
})
public class BaseResponse<T> {

    @JsonProperty("code")
    private ResponseCode code;

    @JsonProperty("message")
    private String message;

    @JsonProperty("data")
    private T data;

    @JsonProperty("errors")
    private List<ErrorDto> errors;
}