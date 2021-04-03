package b3.desafiofinal.demo.services;

import b3.desafiofinal.demo.domains.Pergunta;
import b3.desafiofinal.demo.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class EngineService {

    private final ApiService apiService;

    public Pergunta getNextQuestion(User user) throws Exception {
        Pergunta pergunta = getNextQuestion(getDifficulty(user));
        int i = 0;
        while (true){
            if (!user.getPerguntas().contains(pergunta.getPergunta())){
                user.getPerguntas().add(pergunta.getPergunta());
                return pergunta;
            }else{
                pergunta = getNextQuestion(getDifficulty(user));
                i++;
                if (i > 5){
                    throw new Exception("out of questions");
                }
            }
        }
    }

    private String getDifficulty(User user){
        switch (user.getNumberOfQuestionsAnswered()){
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
                return "fácil";
            case 5:
            case 6:
            case 7:
            case 8:
                return "medía";
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                return "difícil";
            case 15:
                return "impossível";


        }
        throw new IllegalArgumentException("Quantia de perguntas errado");
    }

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

    public String[] helpFighty(Pergunta pergunta){
        String[] respostas = new String[2];
        respostas[0] = getLetter(pergunta);
        List<String> letras = Arrays.asList(getLetras().clone());
        while (true){
            String letra = letras.get(new Random().nextInt(4));
            if (!letra.equals(getLetter(pergunta))){
                respostas[1] = letra;
                break;
            }
        }
        return respostas;
    }

    public Map<String, Integer> helpFromPublic(Pergunta pergunta){
        switch (pergunta.getDificuldade()){
            case "fácil":
                return getHelp(70, pergunta);
            case "média":
                return getHelp(50, pergunta);
            case "difícil":
                return getHelp(30, pergunta);
            case "impossível":
                return getHelp(20, pergunta);
        }
        throw new IllegalArgumentException("Dificuldade nao reconhecida: "+pergunta.getDificuldade());
    }

    private Map<String, Integer> getHelp(int i, Pergunta pergunta) {
        int resto = 100-i;
        Map<String, Integer> map = new HashMap<>();
        String certa = getLetter(pergunta);
        for (String l: getLetras()) {
            if (!certa.equals(l)){
                int num = resto > 0 ? new Random().nextInt(resto) : 0;
                resto -= num;
                map.put(l, num);
            }
        }
        map.put(certa, i);
        return map;
    }

    private String[] getLetras() {
        String[] letras = new String[4];
        letras[0] = "a";
        letras[1] = "b";
        letras[2] = "c";
        letras[3] = "d";
        return letras;
    }

    private String getLetter(Pergunta pergunta){
        switch (pergunta.getCerta()){
            case "1":
                return "a";
            case "2":
                return "b";
            case "3":
                return "c";
            case "4":
                return "d";
        }
        throw new IllegalArgumentException("Certa errada: "+pergunta.getCerta());
    }


}
