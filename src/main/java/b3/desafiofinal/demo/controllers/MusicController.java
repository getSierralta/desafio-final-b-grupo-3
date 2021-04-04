package b3.desafiofinal.demo.controllers;

import b3.desafiofinal.demo.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MusicController {

    @GetMapping(value = "/music")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String index(ModelMap map) {
        return "music";
    }
}
