package b3.desafiofinal.demo.models;

import b3.desafiofinal.demo.domains.Pergunta;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.awt.image.AreaAveragingScaleFilter;
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
    private int numberOfQuestionsAnswered;

    @OneToOne
    private Pergunta pergunta;




    @OneToOne
    private Highscore highscore;
    @Transient
    private List<String> perguntas = new ArrayList<>();
    private String profilePicture;


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


    public String getProfilePicture(){
        if(profilePicture==null){
            return"/img/palm.png";
        }else{
            return profilePicture;
        }
    }
}
