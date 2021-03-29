package b3.desafiofinal.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pergunta {
    private String pergunta;
    private String r1;
    private String r2;
    private String r3;
    private String r4;
    private String certa;
    private String dificuldade;
}
