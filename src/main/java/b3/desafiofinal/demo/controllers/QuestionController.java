package b3.desafiofinal.demo.controllers;

import b3.desafiofinal.demo.models.User;
import b3.desafiofinal.demo.services.EngineService;
import b3.desafiofinal.demo.services.HighscoreService;
import b3.desafiofinal.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class QuestionController {

    UserService userService;
    HighscoreService highscoreService;
    private final EngineService engineService;

    @GetMapping(value = "/question")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String index(ModelMap map) throws Exception {
        //User user = userService.getLoggedUser();
        //map.addAttribute("pergunta", engineService.getNextQuestion(user));
        //map.addAttribute("perguntaN", user.getNumberOfQuestionsAnswered());
        return "question";
    }


    @GetMapping(value= "/new-question")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String showNewQuestionForm() {
        return "new-question";
    }

    //post mapping para adicionar pontuação da pergunta, considerando o tempo restante e a dificuldade da pergunta
    @PostMapping(value="/answerQuestion/{info}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String calculateScore(@PathVariable(name="info") String info){
        String[] infoSplit=info.split(":");
        int difficulty= Integer.parseInt(infoSplit[0]);
        long timeLeft= Long.parseLong(infoSplit[1]);
        //metodo que devolve o score atual do jogador ja considerando esta resposta
        long currentScore=userService.addScore(userService.getLoggedUser(), difficulty,timeLeft);
        return "gamePage";
    }

    //getMapping quando o utilizador perde
    @GetMapping(value="/loser")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String loserPage(){
        /*User user=userService.getLoggedUser();
        highscoreService.saveHighscore(user.getCurrentScore(),user);
        userService.clearCurrentGameInfo(user);*/
        return"loserPage";
    }

}
