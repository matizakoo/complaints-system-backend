package pl.tanielazienki.tanielazienki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;
@SpringBootApplication
@EnableJpaRepositories("pl.tanielazienki.tanielazienki.repository")
@EntityScan("pl.tanielazienki.tanielazienki.entity")
public class TanielazienkiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TanielazienkiApplication.class, args);
	}
}
