package b3.desafiofinal.demo.services;

import b3.desafiofinal.demo.domains.Pergunta;
import b3.desafiofinal.demo.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class EngineService {

    private final ApiService apiService;

    public Pergunta getNextQuestion(String dificuldade, User user) throws Exception {
        Pergunta pergunta = getNextQuestion(dificuldade);
        int i = 0;
        while (true){
            if (!user.getPerguntas().contains(pergunta.getPergunta())){
                user.getPerguntas().add(pergunta.getPergunta());
                return pergunta;
            }else{
                pergunta = getNextQuestion(dificuldade);
                i++;
                if (i > 5){
                    throw new Exception("out of questions");
                }
            }
        }
    }
    public Pergunta getNextQuestion(String dificuldade){
        Pergunta[] perguntas = apiService.getPerguntas(dificuldade);
        Pergunta pergunta = perguntas[new Random().nextInt(perguntas.length)];
        List<String> shuffle = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int j = new Random().nextInt(4);
            if (!numbers.contains(j)){
                numbers.add(j);
                shuffle.add(getResposta(j, pergunta));
            }else {
                i--;
            }
        }
        pergunta.setShuffle(shuffle);
        return pergunta;
    }

    private String getResposta(int j, Pergunta pergunta){
        switch (j){
            case 0:
                return pergunta.getResposta1();
            case 1:
                return pergunta.getResposta2();
            case 2:
                return pergunta.getResposta3();
            case 3:
                return pergunta.getResposta4();
        }
        throw new IllegalArgumentException("Number out of bound: "+j);
    }
}
