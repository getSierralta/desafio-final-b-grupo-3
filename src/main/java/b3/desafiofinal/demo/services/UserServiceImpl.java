package b3.desafiofinal.demo.services;

import b3.desafiofinal.demo.Repositories.ConfirmationTokenRepository;
import b3.desafiofinal.demo.Repositories.PasswordResetTokenRepository;
import b3.desafiofinal.demo.Repositories.UserRepository;
import b3.desafiofinal.demo.models.ConfirmationToken;
import b3.desafiofinal.demo.models.PasswordResetToken;
import b3.desafiofinal.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    ConfirmationTokenRepository confirmationTokenRepository;
    @Autowired
    PasswordResetTokenRepository passwordResetTokenRepository;
    @Autowired
    JavaMailSender mailSender;


    @Override
    public void registerUser(ModelAndView mav, User user) {
        if(userRepository.findByUsername(user.getUsername())!=null){
            mav.addObject("errorMail","O email indicado já está registado");
            mav.setViewName("/registo");
            return;
        }
        if(!user.getPassword().equals(user.getConfirmPassword())){
            mav.addObject("errorPassword","Por favor verifique a password indicada");
            mav.setViewName("/registo");
            return;
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        ConfirmationToken confirmationToken= createToken(user);
        sendConfirmationMail(user, confirmationToken);
        mav.setViewName("/login");
        mav.addObject("verifyMessage","Valide o email, clicando no link enviado");
    }

    @Override
    public void verifyEmail(String token, ModelAndView mav) {
        ConfirmationToken confirmationToken= confirmationTokenRepository.findConfirmationTokenByToken(token);
        if(confirmationToken!=null && confirmationToken.getExpiresAt().isAfter(LocalDateTime.now()) && !confirmationToken.isUsed()){
            User user =confirmationToken.getUser();
            user.setEnabled(true);
            userRepository.save(user);
            confirmationToken.setUsed(true);
            confirmationTokenRepository.save(confirmationToken);
            mav.addObject("verifiedEmail","Email verificado com sucesso");
        }else{
            mav.addObject("error", "falha na verificação, por favor verifique o link no seu email");
        }
    }

    private void sendConfirmationMail(User user, ConfirmationToken confirmationToken) {
        String url = "localhost:8080/verificarEmail/" + confirmationToken.getToken();
        String subject="Verificação de email : Quem quer ser Upskill";
        String body= "Olá "+user.getName()+",\n Para verificar o seu email e ter acesso à sua conta, por favor siga o link abaixo:\n"+url;
        mailSender.send(constructEmail(subject,body,user));
    }

    private void sendForgotPasswordMail(User user, PasswordResetToken passwordResetToken) {
        String url = "localhost:8080/esqueciPassword/" + passwordResetToken.getToken();
        String subject="Recuperação de password : Quem quer ser Upskill";
        String body= "Olá "+user.getName()+",\n Para alterar a sua password e ter acesso à sua conta, por favor siga o link abaixo:\n"+url;
        mailSender.send(constructEmail(subject,body,user));
    }

    private ConfirmationToken createToken(User user) {
        String token = java.util.UUID.randomUUID().toString();
        ConfirmationToken confirmationToken= new ConfirmationToken(token, LocalDateTime.now(),user);
        confirmationTokenRepository.save(confirmationToken);
        return confirmationToken;
    }

    private PasswordResetToken createPasswordToken(User user) {
        String token = java.util.UUID.randomUUID().toString();
        PasswordResetToken passwordResetToken= new PasswordResetToken(token, LocalDateTime.now(),user);
        passwordResetTokenRepository.save(passwordResetToken);
        return passwordResetToken;
    }

    private SimpleMailMessage constructEmail(String subject, String body,
                                             User user) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setSubject(subject);
        email.setText(body);
        email.setTo(user.getUsername());
        return email;
    }

    @Override
    public User authenticate(String username, String password) {
        User user= userRepository.findByUsername(username);
        if(user==null) {
            return null;
        }
        if(passwordEncoder.matches(password,user.getPassword()) && user.isEnabled())
            return user;
        return null;
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void forgotPassword(ModelAndView mav, String username) {
        User user = userRepository.findByUsername(username);
        if(user==null){
            mav.addObject("emailError","O email indicado não está registado");
            mav.setViewName("forgotPassword");
        }else {
            PasswordResetToken passwordResetToken=createPasswordToken(user);
            sendForgotPasswordMail(user,passwordResetToken);
            mav.addObject("success","O email de recuperação de password foi enviado");
        }
    }

    @Override
    public boolean verifyToken(String token) {
        PasswordResetToken passwordResetToken=passwordResetTokenRepository.findPasswordResetTokenByToken(token);
        if(passwordResetToken!=null && !passwordResetToken.isUsed() && passwordResetToken.getExpiresAt().isAfter(LocalDateTime.now())){
            passwordResetToken.setUsed(true);
            passwordResetTokenRepository.save(passwordResetToken);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public User findUserByPasswordToken(String token) {
        PasswordResetToken passwordResetToken=passwordResetTokenRepository.findPasswordResetTokenByToken(token);
        return passwordResetToken.getUser();
    }

    @Override
    public void changePassword(ModelAndView mav, String username, String password, String confirmPassword) {
        User user = userRepository.findByUsername(username);
        if(!password.equals(confirmPassword)){
            mav.addObject("passwordError", "Por favor verifique a sua password");
            mav.addObject("username",username);
            mav.setViewName("alterarPassword");
        }else{
            String encodedPassword= passwordEncoder.encode(password);
            user.setPassword(encodedPassword);
            userRepository.save(user);
            mav.addObject("successPasswordChange","A sua password foi alterada");
        }
    }


}
