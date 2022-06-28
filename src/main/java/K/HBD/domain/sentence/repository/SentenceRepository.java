package K.HBD.domain.sentence.repository;

import K.HBD.domain.sentence.Sentence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SentenceRepository extends JpaRepository<Sentence, Long>, SentenceCustomRepository {
}
