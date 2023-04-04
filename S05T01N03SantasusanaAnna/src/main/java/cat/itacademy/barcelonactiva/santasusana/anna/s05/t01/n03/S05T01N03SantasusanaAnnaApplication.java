package cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n03;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Flower's Reactive API", version = "1.0.0"))
public class S05T01N03SantasusanaAnnaApplication {

	public static void main(String[] args) {
		SpringApplication.run(S05T01N03SantasusanaAnnaApplication.class, args);
	}

}
