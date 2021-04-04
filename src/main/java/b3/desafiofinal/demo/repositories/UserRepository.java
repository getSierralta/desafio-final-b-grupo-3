package b3.desafiofinal.demo.repositories;

import b3.desafiofinal.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


    User findByUsername(String username);

    @Transactional
    @Modifying
    @Query("Update User set pergunta_id = null")
    void dropPerguntas();
}
