package b3.desafiofinal.demo.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class PasswordResetToken {

    private static final int EXPIRATION = 48;

    @Id
    @GeneratedValue
    private Long id;
    private String token;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;
    private boolean used;

    @ManyToOne
    private User user;


    public PasswordResetToken(String token, LocalDateTime createdAt, User user) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = createdAt.plusHours(EXPIRATION);
        this.user = user;
    }


}
