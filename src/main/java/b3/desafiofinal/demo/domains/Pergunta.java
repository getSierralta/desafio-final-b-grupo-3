package b3.desafiofinal.demo.domains;

import lombok.*;

import java.util.List;

@Getter
@Setter
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

    @Override
    public String toString() {
        return "Pergunta{" +
                "pergunta='" + pergunta + '\'' +
                ", resposta1='" + resposta1 + '\'' +
                ", resposta2='" + resposta2 + '\'' +
                ", resposta3='" + resposta3 + '\'' +
                ", resposta4='" + resposta4 + '\'' +
                ", certa='" + certa + '\'' +
                ", dificuldade='" + dificuldade + '\'' +
                ", \nshuffle=" + shuffle +
                '}';
    }
}
