package ph.com.zenprint.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ph.com.zenprint.constant.ResponseCode;
import ph.com.zenprint.constant.Severity;

import java.time.LocalDateTime;

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
        "attribute",
        "message",
        "severity",
        "ticketId",
        "timestamp"
})
public class ErrorDto {

    @JsonProperty("code")
    private ResponseCode responseCode;

    @JsonProperty("attribute")
    private String attribute;

    @JsonProperty("message")
    private String message;

    @JsonProperty("severity")
    private Severity severity;

    @JsonProperty("ticketId")
    private String ticketId;

    @JsonProperty("timestamp")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime timestamp;
}