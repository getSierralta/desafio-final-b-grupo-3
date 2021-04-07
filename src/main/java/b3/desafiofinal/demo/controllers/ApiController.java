package b3.desafiofinal.demo.controllers;

import b3.desafiofinal.demo.domains.Pergunta;
import b3.desafiofinal.demo.domains.Perguntas;
import b3.desafiofinal.demo.requests.StatusResponse;
import b3.desafiofinal.demo.requests.PerguntaRequest;
import b3.desafiofinal.demo.services.ApiService;
import b3.desafiofinal.demo.services.EngineService;
import b3.desafiofinal.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ApiController {
    private final ApiService apiService;
    private final UserService userService;
    private final EngineService engineService;

    /*
    Criar nova pergunta
     */
    @PostMapping("/criar-pergunta")
    public ResponseEntity<StatusResponse> criarPergunta(@RequestBody PerguntaRequest request) throws Exception {
        return ResponseEntity.ok(apiService.criarPergunta(request));
    }
    @GetMapping("/perguntas/{dificuldade}")
    public ResponseEntity<Pergunta[]> getPerguntas(@PathVariable String dificuldade){
        return ResponseEntity.ok(apiService.getPerguntas(dificuldade));
    }

    @GetMapping("/estatistica")
    public ResponseEntity<Perguntas> getEstatisticas(){
        return ResponseEntity.ok(apiService.getEstatistica());
    }


    // Isto esta aqui bue tipo nao a toa mas tipo precisava um rest controller :(
    @GetMapping(value =  "/cincuenta/{a}/{b}/{c}/{d}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String[] getCincuenta(@PathVariable String a, @PathVariable String b,  @PathVariable String c, @PathVariable String d){
        return engineService.helpFighty(userService.getLoggedUser(), userService.getLoggedUser().getPergunta(), a, b, c, d);
    }

}
