package ph.com.zenprint.property;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Choy
 * @date 11/2/2020.
 */

@NoArgsConstructor
@Data
@Component
@ConfigurationProperties("log")
public class LogProperty {

    private String beforeRequestPrefix;

    private String afterRequestPrefix;

    private String afterResponsePrefix;
}