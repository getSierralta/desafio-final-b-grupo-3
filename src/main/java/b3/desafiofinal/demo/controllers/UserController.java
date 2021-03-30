package b3.desafiofinal.demo.controllers;

import b3.desafiofinal.demo.models.User;
import b3.desafiofinal.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

@Controller
public class UserController {


    @Autowired
    UserService userService;

    @PostMapping(value="/register")
    public ModelAndView register(@ModelAttribute User user){
        ModelAndView mav= new ModelAndView();
        userService.registerUser(mav,user);
        return mav;
    }

    @GetMapping(value="/verificarEmail/{token}")
    public ModelAndView verifyEmail(@PathVariable (name="token") String token){
        ModelAndView mav= new ModelAndView("login");
        userService.verifyEmail(token, mav);
        return mav;
    }

    @PostMapping(value="/esqueciPassword")
    public ModelAndView forgotPasswordRequest(@RequestParam String username){
        ModelAndView mav=new ModelAndView("login");
        userService.forgotPassword(mav,username);
        return mav;
    }

    @GetMapping(value="/esqueciPassword/{token}")
    public ModelAndView forgotPassword(@PathVariable(name="token") String token){
        ModelAndView mav= new ModelAndView();
        if(userService.verifyToken(token)){
            mav.setViewName("alterarPassword");
            mav.addObject("username",userService.findUserByPasswordToken(token).getUsername());
            return mav;
        }else{
            mav.setViewName("esqueciPassword");
            mav.addObject("tokenError","O link de recuperação de password não é válido");
            return mav;
        }
    }

    @PostMapping(value="/alterarPassword")
    public ModelAndView changePassword(@RequestParam String username, String password, String confirmPassword){
        ModelAndView mav=new ModelAndView("login");
        userService.changePassword(mav,username,password,confirmPassword);
        return mav;
    }


}

