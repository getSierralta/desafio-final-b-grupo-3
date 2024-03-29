package b3.desafiofinal.demo.securityConfig;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {

        List<String> roles = new ArrayList<String>();
        for (GrantedAuthority a : authentication.getAuthorities()) {
            System.out.println("Authority: "+a);
            roles.add(a.getAuthority());
        }

        String targetUrl = "/";
        if (roles.contains("ROLE_USER")) {
            targetUrl = "/dashboard";
        }
        if (roles.contains("ROLE_ADMIN")) {
            targetUrl = "/dashboardAdmin";
        }

        for(String role:roles){
            System.out.println(role);
        }
        System.out.println("O targetUrl é: "+targetUrl);

        if (response.isCommitted()) {
            System.out.println("Can't redirect");
            return;
        }

        redirectStrategy.sendRedirect(request, response, targetUrl);
    }
}