package b3.desafiofinal.demo.domains;

import b3.desafiofinal.demo.models.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pergunta {

    @Id
    @GeneratedValue
    private Long id;
    private String pergunta;
    private String resposta1;
    private String resposta2;
    private String resposta3;
    private String resposta4;
    private String certa;
    private String dificuldade;
    @Transient
    private List<String> shuffle;



    public Pergunta(String pergunta, String resposta1, String resposta2, String resposta3,
                    String resposta4, String certa, String dificuldade) {
        this.pergunta = pergunta;
        this.resposta1 = resposta1;
        this.resposta2 = resposta2;
        this.resposta3 = resposta3;
        this.resposta4 = resposta4;
        this.certa = certa;
        this.dificuldade = dificuldade;
    }
}
