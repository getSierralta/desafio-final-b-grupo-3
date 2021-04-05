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
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class QuestionController {

    @Autowired
    UserService userService;
    @Autowired
    HighscoreService highscoreService;
    private final EngineService engineService;

    @GetMapping(value = "/question")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String question(ModelMap map) throws Exception {
        User user = userService.getLoggedUser();
        map.addAttribute("pergunta", engineService.getNextQuestion(user));
        map.addAttribute("perguntaN", user.getNumberOfQuestionsAnswered());
        return "question";
    }

    @GetMapping(value = "/trocarPergunta")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String anotherQuestion(ModelMap map) throws Exception {
        User user = userService.getLoggedUser();
        map.addAttribute("pergunta", engineService.getAnotherQuestion(user));
        map.addAttribute("perguntaN", user.getNumberOfQuestionsAnswered());
        return "question";
    }



    @GetMapping(value= "/new-question")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String showNewQuestionForm() {
        User user = userService.getLoggedUser();
        if (engineService.isWinner(user)) {
            return winner();
        }
        return "new-question";
    }

    //post mapping para adicionar pontuação da pergunta, considerando o tempo restante e a dificuldade da pergunta
    @PostMapping("/answerQuestion/{dif}/{time}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public RedirectView calculateScore(@PathVariable int dif, @PathVariable int time){
        //metodo que devolve o score atual do jogador ja considerando esta resposta
        long currentScore = userService.addScore(userService.getLoggedUser(), dif,time);
        return new RedirectView("/question");
    }

    //getMapping quando o utilizador perde
    @PostMapping(value="/loser")
    @PreAuthorize("hasRole('ROLE_USER')")
    public RedirectView loserPage(ModelMap map){
        User user=userService.getLoggedUser();
        map.put("score", user.getCurrentScore());
        map.put("name", user.getName().toUpperCase());
        highscoreService.saveHighscore(user.getCurrentScore(),user);
        userService.clearCurrentGameInfo(user);
        return new RedirectView("loserPage");
    }

    @GetMapping(value="/loserPage")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String loser(ModelMap map){
        User user=userService.getLoggedUser();
        map.put("score", user.getCurrentScore());
        map.put("name", user.getName().toUpperCase());
        return "loserPage";
    }

    @PostMapping(value="/winner")
    @PreAuthorize("hasRole('ROLE_USER')")
    public RedirectView winnerPage(){
        User user=userService.getLoggedUser();
        highscoreService.saveHighscore(user.getCurrentScore(),user);
        userService.clearCurrentGameInfo(user);
        return new RedirectView("winnerPage");
    }

    @GetMapping(value="/winnerPage")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String winner(){
        return "winnerPage";
    }
}
