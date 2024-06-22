package pl.tanielazienki.tanielazienki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
public class TanielazienkiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TanielazienkiApplication.class, args);
	}
}
