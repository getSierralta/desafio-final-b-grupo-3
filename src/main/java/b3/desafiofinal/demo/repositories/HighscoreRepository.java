package b3.desafiofinal.demo.repositories;

import b3.desafiofinal.demo.models.ConfirmationToken;
import b3.desafiofinal.demo.models.Highscore;
import b3.desafiofinal.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HighscoreRepository extends JpaRepository<Highscore,Long> {


    Highscore findHighscoreByUser(User user);


    List<Highscore> findByOrderByHighscoreDesc();
}
