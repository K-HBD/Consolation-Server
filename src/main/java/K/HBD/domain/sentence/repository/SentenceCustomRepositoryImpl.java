package K.HBD.domain.sentence.repository;

import K.HBD.domain.enumType.Emotion;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static K.HBD.domain.sentence.QSentence.sentence;


@RequiredArgsConstructor
@Repository
public class SentenceCustomRepositoryImpl implements SentenceCustomRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public String findLetterByEmotion(Emotion emotion) {

        return jpaQueryFactory.from(sentence)
                .select(sentence.letter)
                .where(sentence.emotion.eq(emotion))
                .orderBy(NumberExpression.random().asc())
                .limit(1L)
                .fetchOne();
    }
}
