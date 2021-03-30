package b3.desafiofinal.demo.repositories;

import b3.desafiofinal.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


    User findByUsername(String username);
}