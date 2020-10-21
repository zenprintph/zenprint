package ph.com.zenprint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan(basePackages = "ph.com.zenprint.configuration")
public class ZenprintApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZenprintApplication.class, args);
	}

}
