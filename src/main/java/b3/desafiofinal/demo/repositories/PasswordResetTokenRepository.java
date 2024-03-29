package b3.desafiofinal.demo.repositories;

import b3.desafiofinal.demo.models.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken,Long> {


    PasswordResetToken findPasswordResetTokenByToken(String token);
}
