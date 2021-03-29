package b3.desafiofinal.demo.services;

import b3.desafiofinal.demo.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface UserService {

    void registerUser(ModelAndView mav, User user);


    void verifyEmail(String token, ModelAndView mav);

    User authenticate(String username, String password);

    User findUserByUsername(String username);

    void forgotPassword(ModelAndView mav, String username);

    boolean verifyToken(String token);

    User findUserByPasswordToken(String token);

    void changePassword(ModelAndView mav, String username, String password, String confirmPassword);
}
