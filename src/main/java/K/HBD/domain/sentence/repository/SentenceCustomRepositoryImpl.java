package K.HBD.domain.sentence.repository;

import K.HBD.domain.enumType.Emotion;
import K.HBD.domain.enumType.Use;
import K.HBD.domain.sentence.Sentence;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static K.HBD.domain.sentence.QSentence.sentence;


@RequiredArgsConstructor
@Repository
public class SentenceCustomRepositoryImpl implements SentenceCustomRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Sentence findSentenceByUseLetter(Use use, Emotion emotion) {
        List<Long> count = jpaQueryFactory.from(sentence)
                .select(sentence.count())
                .where(sentence.used_letter.eq(use))
                .where(sentence.emotion.eq(emotion))
                .fetch();

        Long id = count.stream().findFirst().orElse(1L);

        Sentence letter = jpaQueryFactory.select(sentence)
                .from(sentence)
                .where(sentence.id.eq(id))
                .fetchOne();

        return letter;
    }
}
