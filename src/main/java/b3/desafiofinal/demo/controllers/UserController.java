package b3.desafiofinal.demo.controllers;

import b3.desafiofinal.demo.models.User;
import b3.desafiofinal.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

@Controller
public class UserController {


    @Autowired
    UserService userService;

    //PostMapping para a página de registo (nomes dos campos - username, name, country, password, confirmPassword)
    @PostMapping(value="/register")
    public ModelAndView register(@ModelAttribute User user){
        ModelAndView mav= new ModelAndView();
        userService.registerUser(mav,user);
        return mav;
    }

    //getMapping para página de login quando se verifica o email
    @GetMapping(value="/verificarEmail/{token}")
    public ModelAndView verifyEmail(@PathVariable (name="token") String token){
        ModelAndView mav= new ModelAndView("index");
        userService.verifyEmail(token, mav);
        return mav;
    }

    //PostMapping após solicitar nova senha - campo do formulário - username
    @PostMapping(value="/esqueciPassword")
    public ModelAndView forgotPasswordRequest(@RequestParam String username){
        ModelAndView mav=new ModelAndView("index");
        userService.forgotPassword(mav,username);
        return mav;
    }

    //getMapping para página de alterar password através do link de recuperação - gravar username como hidden field do formulário
    @GetMapping(value="/esqueciPassword/{token}")
    public ModelAndView forgotPassword(@PathVariable(name="token") String token){
        ModelAndView mav= new ModelAndView();
        if(userService.verifyToken(token)){
            mav.setViewName("alterarPassword");
            mav.addObject("username",userService.findUserByPasswordToken(token).getUsername());
            return mav;
        }else{
            mav.setViewName("index");
            mav.addObject("tokenError","O link de recuperação de password não é válido");
            return mav;
        }
    }

    //postMapping para quando o utilizador muda a password
    @PostMapping(value="/alterarPassword")
    public ModelAndView changePassword(@RequestParam String username, String password, String confirmPassword){
        ModelAndView mav=new ModelAndView("index");
        userService.changePassword(mav,username,password,confirmPassword);
        return mav;
    }


    @GetMapping(value = "/login")
    public String login(ModelMap map, @RequestParam(value = "error", defaultValue = "false") boolean loginError){
        if (loginError) {
            map.put("errorMessage","O username ou password estão incorrectos");
        }
        return "index";
    }


}

