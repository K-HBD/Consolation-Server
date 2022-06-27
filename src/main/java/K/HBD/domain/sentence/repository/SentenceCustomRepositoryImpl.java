package K.HBD.domain.sentence.repository;

import K.HBD.domain.enumType.Emotion;
import K.HBD.domain.sentence.QSentence;
import K.HBD.domain.sentence.Sentence;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@RequiredArgsConstructor
@Repository
public class SentenceCustomRepositoryImpl implements SentenceCustomRepository {
    private final JPAQueryFactory jpaQueryFactory;
    private final JPAUpdateClause jpaUpdateClause;

    @Override
    public String findLetterByEmotion(Emotion emotion) {
        List<Sentence> list = jpaQueryFactory.from(QSentence.sentence)
                .select(QSentence.sentence)
                .where(QSentence.sentence.emotion.eq(emotion))
                .orderBy(NumberExpression.random().asc())
                .fetch();

        String letter = list.stream().map(Sentence::getLetter).findFirst().orElse(null);
        return letter;
    }
}
