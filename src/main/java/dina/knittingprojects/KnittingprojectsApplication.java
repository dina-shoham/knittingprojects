package dina.knittingprojects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@RestController
public class KnittingprojectsApplication {

	public static void main(String[] args) {
		SpringApplication.run(KnittingprojectsApplication.class, args);
	}

	// mapping to root of api
	@GetMapping("/")
	public String apiRoot() {
		return "Hello, world!";
	}
}
