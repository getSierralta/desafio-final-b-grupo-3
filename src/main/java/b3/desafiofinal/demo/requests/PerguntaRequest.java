package b3.desafiofinal.demo.requests;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PerguntaRequest {
    private String pergunta;
    private String r1;
    private String r2;
    private String r3;
    private String r4;
    private String certa;
    private String dificuldade;
}
