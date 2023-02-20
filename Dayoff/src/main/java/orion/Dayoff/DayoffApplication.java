package orion.Dayoff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@SpringBootApplication
@EnableSwagger2
public class DayoffApplication {
	public static void main(String[] args) {
		SpringApplication.run(DayoffApplication.class, args);
	}
	
	//TODO konfigürasyonlar için ayrı bir config pakedi oluşturup. SwaggerConfig ismiyle bir sınıf oluşturup bu işleri orda yapalım.
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.basePackage("orion.Dayoff"))
			.build();
	}


	
	
	

}
