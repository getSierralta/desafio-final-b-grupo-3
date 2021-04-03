package b3.desafiofinal.demo.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping(value = "/dashboard")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String index(ModelMap map){
        map.addAttribute("name", "Max");
        return "dashboard";
    }
}
