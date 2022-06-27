package K.HBD.domain.sentence.repository;

import K.HBD.domain.enumType.Emotion;

public interface SentenceCustomRepository {
    String findLetterByEmotion(Emotion emotion);
}
