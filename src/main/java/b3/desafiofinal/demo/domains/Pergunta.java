package b3.desafiofinal.demo.domains;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Pergunta {
    private String pergunta;
    private String resposta1;
    private String resposta2;
    private String resposta3;
    private String resposta4;
    private String certa;
    private String dificuldade;
    private List<String> shuffle;
}
