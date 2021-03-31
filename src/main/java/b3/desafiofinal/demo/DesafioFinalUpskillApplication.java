package b3.desafiofinal.demo;

import b3.desafiofinal.demo.models.User;
import b3.desafiofinal.demo.services.EngineService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import b3.desafiofinal.demo.models.Highscore;
import b3.desafiofinal.demo.models.User;
import b3.desafiofinal.demo.services.HighscoreService;
import b3.desafiofinal.demo.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@AllArgsConstructor
public class DesafioFinalUpskillApplication {

	private final EngineService engineService;

	private final UserService userService;
	private final HighscoreService highscoreService;

	public static void main(String[] args) {
		SpringApplication.run(DesafioFinalUpskillApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			/*User user = userService.findUserByUsername("nunovicentecruz@gmail.com");
			long score=1000;
			highscoreService.saveHighscore(score,user);
			System.out.println("Devia ser 1000: "+user.getHighscore().getHighscore());
			score=500;
			highscoreService.saveHighscore(score,user);
			System.out.println("Devia ser 1000: "+user.getHighscore().getHighscore());
			score=2000;
			highscoreService.saveHighscore(score,user);
			System.out.println("Devia ser 2000: "+user.getHighscore().getHighscore());
			System.out.println(highscoreService.getTopTenHighScores());*/
			int i=1;
			for(Highscore highscore: highscoreService.getTopTenHighScores()){
				System.out.println("Highscore "+i+": "+highscore.getUser().getName()+" - "+highscore.getHighscore());
				i++;
			}
		};
	}

}
