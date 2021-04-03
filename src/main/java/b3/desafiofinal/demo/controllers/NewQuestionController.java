package b3.desafiofinal.demo.controllers;


import b3.desafiofinal.demo.requests.PerguntaRequest;
import b3.desafiofinal.demo.services.ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/new-question")
@RequiredArgsConstructor
public class NewQuestionController {

    private final ApiService apiService;

    @PostMapping(path = "/register", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public RedirectView register(PerguntaRequest perguntaRequest) throws Exception {
        apiService.criarPergunta(perguntaRequest);
        //ModelAndView modelAndView = new ModelAndView();
        //modelAndView.setViewName("/new-question");
        return new RedirectView("/new-question");
    }
}
