package b3.desafiofinal.demo.services;

import b3.desafiofinal.demo.models.Highscore;
import b3.desafiofinal.demo.models.User;
import b3.desafiofinal.demo.repositories.HighscoreRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface HighscoreService {


    //devolve a lista dos maiores highscores, até um máximo de 10 highscores
    List<Highscore> getTopTenHighScores();

    //adiciona o score à base de dados de scores e verifica e grava se for maior que a pessoal atual
    String saveHighscore(long highScore, User user);
}
