package b3.desafiofinal.demo.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Component
@Getter
@Setter
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String country;
    private String name;
    private boolean enabled;
    @Transient
    private String confirmPassword;

    ///currentGameInfo - deleted on every login and when a new game starts
    private long currentScore;
    private boolean usedFiftyFifty;
    private boolean usedPublicHelp;
    private boolean usedChangeQuestion;


    @OneToOne
    private Highscore highscore;


    public List<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> roles=new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(Roles.ROLE_USER.name()));
        return roles;
    }


    public User(){}


    public boolean isAccountNonExpired() {
        return true;
    }


    public boolean isAccountNonLocked() {
        return true;
    }


    public boolean isCredentialsNonExpired() {
        return true;
    }


    public boolean isEnabled() {
        return enabled;
    }


}
