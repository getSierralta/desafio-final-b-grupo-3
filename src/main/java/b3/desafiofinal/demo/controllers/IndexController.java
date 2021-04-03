package b3.desafiofinal.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping(value = "/")
    public String index(ModelMap map){
        map.addAttribute("name", "Desafio Upskill");
        return "index";
    }
}
