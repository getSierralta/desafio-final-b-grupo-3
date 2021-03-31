package b3.desafiofinal.demo.services;

import b3.desafiofinal.demo.models.Highscore;
import b3.desafiofinal.demo.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface UserService {

    //grava o novo user e pode devolver no mav as seguintes mensagens - errorMail, errorPassword - viewname-Registo (erro)
    //viewname - login (se der certo)
    void registerUser(ModelAndView mav, User user);

    //verifica se o token de validação de email é válido, se for devolve no mav - verifiedEmail, se não for - error
    void verifyEmail(String token, ModelAndView mav);

    //usado para realizar o login, tb limpa os dados da ultima sessão de jogo
    User authenticate(String username, String password);

    User findUserByUsername(String username);

    //cria email de alteração de password, devolve no mav se der certo - success
    //se o email não for válido - setviewName - forgotPassword e mensagem - emailError
    void forgotPassword(ModelAndView mav, String username);

    //verifica se o token de recuperação de email existe, não expirou e ainda não foi usado
    boolean verifyToken(String token);

    User findUserByPasswordToken(String token);

    //alterar password
    void changePassword(ModelAndView mav, String username, String password, String confirmPassword);

    //verifica se o novo highscore é maior que o seu atual e grava-o
    boolean checkIfNewPersonalHighscoreAndSave(Highscore newHighscore, User user);

    //apaga info de pontuaçao atual e de ajudas utilizadas
    void clearCurrentGameInfo(User user);

}
