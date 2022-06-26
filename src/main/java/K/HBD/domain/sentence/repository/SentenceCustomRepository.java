package K.HBD.domain.sentence.repository;

import K.HBD.domain.enumType.Emotion;
import K.HBD.domain.enumType.Use;
import K.HBD.domain.sentence.Sentence;

public interface SentenceCustomRepository {
    Sentence findSentenceByUseLetter(Use use, Emotion emotion);
    void updateSentenceByAllUseLetter(Use use, Emotion emotion);
}
