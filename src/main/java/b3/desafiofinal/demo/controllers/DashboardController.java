package b3.desafiofinal.demo.controllers;

import b3.desafiofinal.demo.models.User;
import b3.desafiofinal.demo.services.ApiService;
import b3.desafiofinal.demo.services.HighscoreService;
import b3.desafiofinal.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    UserService userService;
    @Autowired
    ApiService apiService;
    @Autowired
    HighscoreService highscoreService;

    @GetMapping(value = "/dashboard")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String index(ModelMap map){
        userService.clearCurrentGameInfo(userService.getLoggedUser());
        map.addAttribute("user", userService.getLoggedUser());
        map.addAttribute("players", userService.getPlayers().size());
        map.addAttribute("questions", apiService.getTotalPerguntas());
        map.addAttribute("highscores", highscoreService.getTopTenHighScores());

        return "dashboard";
    }
}
