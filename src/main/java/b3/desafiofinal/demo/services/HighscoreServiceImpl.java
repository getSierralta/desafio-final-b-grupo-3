package b3.desafiofinal.demo.services;

import b3.desafiofinal.demo.models.Highscore;
import b3.desafiofinal.demo.models.User;
import b3.desafiofinal.demo.repositories.HighscoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HighscoreServiceImpl implements HighscoreService{

    @Autowired
    HighscoreRepository highscoreRepository;
    @Autowired
    UserService userService;


    @Override
    public List<Highscore> getTopTenHighScores(){
       List<Highscore> highscores = highscoreRepository.findByOrderByHighscoreDesc();
       List<Highscore> topTenHighscores = new ArrayList<Highscore>();
       int sizeHighscore=10;
       if(highscores.size()<10){
           sizeHighscore=highscores.size();
       }
       for(int i=0; i<sizeHighscore;i++){
           topTenHighscores.add(highscores.get(i));
       }
       return topTenHighscores;
    }


    @Override
    public String saveHighscore(long highScore, User user){
        Highscore newHighscore=new Highscore(highScore,user);
        highscoreRepository.save(newHighscore);
        if(userService.checkIfNewPersonalHighscoreAndSave(newHighscore,user)){
            return "newHighscore";
        }
        return "goodJob";
    }



}
