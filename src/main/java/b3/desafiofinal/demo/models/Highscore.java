package b3.desafiofinal.demo.models;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Highscore {

    @Id
    @GeneratedValue
    private Long id;
    private Long highscore;
    private LocalDateTime achievedDate;

    @ManyToOne
    private User user;


    public Highscore(){
        this.achievedDate=LocalDateTime.now();
    };

    public Highscore(Long highscore, User user){
        this.highscore=highscore;
        this.user=user;
        this.achievedDate=LocalDateTime.now();
    }




}
