package b3.desafiofinal.demo.services;

import b3.desafiofinal.demo.domains.Pergunta;
import b3.desafiofinal.demo.domains.Perguntas;
import b3.desafiofinal.demo.requests.StatusResponse;
import b3.desafiofinal.demo.requests.PerguntaRequest;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String external = "https://serro.pt/perguntas";

    public StatusResponse criarPergunta(PerguntaRequest request) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        JSONObject perguntaRequest = new JSONObject();
        perguntaRequest.put("pergunta", request.getPergunta());
        perguntaRequest.put("resposta1", request.getR1());
        perguntaRequest.put("resposta2", request.getR2());
        perguntaRequest.put("resposta3", request.getR3());
        perguntaRequest.put("resposta4", request.getR4());
        perguntaRequest.put("certa", request.getCerta());
        perguntaRequest.put("dificuldade", request.getDificuldade());

        String requestUrl = external+"/nova";
        StatusResponse response = restTemplate.postForObject(requestUrl, new HttpEntity<>(perguntaRequest.toString(), headers), StatusResponse.class);
        if(response == null || response.status.equals("error")) {
            throw new Exception();
        }
        return  response;
    }

    public Pergunta[] getPerguntas(String dificuldade){
        String requestUrl = external + "/"+dificuldade;
        ResponseEntity<Pergunta[]> responseEntity = restTemplate.getForEntity(requestUrl, Pergunta[].class);
        Pergunta[] perguntas = responseEntity.getBody();
        return perguntas;
    }

    public Perguntas getEstatistica() {
        ResponseEntity<Perguntas> responseEntity = restTemplate.getForEntity(external, Perguntas.class);
        return responseEntity.getBody();
    }
}
