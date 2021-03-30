package b3.desafiofinal.demo;

import b3.desafiofinal.demo.models.User;
import b3.desafiofinal.demo.services.EngineService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@AllArgsConstructor
public class DesafioFinalUpskillApplication {

	private final EngineService engineService;

	public static void main(String[] args) {
		SpringApplication.run(DesafioFinalUpskillApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			/*User user = new User();
			for (int i = 0; i < 1000; i++) {
				System.out.println(engineService.getNextQuestion("fácil", user));
			}*/
		};
	}
}
