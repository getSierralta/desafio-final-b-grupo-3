package b3.desafiofinal.demo.controllers;

import b3.desafiofinal.demo.domains.Pergunta;
import b3.desafiofinal.demo.domains.Perguntas;
import b3.desafiofinal.demo.requests.StatusResponse;
import b3.desafiofinal.demo.requests.PerguntaRequest;
import b3.desafiofinal.demo.services.ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ApiController {
    private final ApiService apiService;

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

    @GetMapping("/estadistica")
    public ResponseEntity<Perguntas> getEstadisticas(){
        return ResponseEntity.ok(apiService.getEstadistica());
    }

}
