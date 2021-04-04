package b3.desafiofinal.demo.repositories;

import b3.desafiofinal.demo.domains.Pergunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerguntaRepository extends JpaRepository<Pergunta,Long> {

}
