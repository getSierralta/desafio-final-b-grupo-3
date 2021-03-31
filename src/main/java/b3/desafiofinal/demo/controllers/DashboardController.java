package b3.desafiofinal.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping(value = "/dashboard")
    public String index(ModelMap map){
        map.addAttribute("name", "Max");
        return "dashboard";
    }
}
