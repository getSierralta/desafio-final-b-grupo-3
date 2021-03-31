package b3.desafiofinal.demo.repositories;

import b3.desafiofinal.demo.models.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken,Long> {


    ConfirmationToken findConfirmationTokenByToken(String token);
}
