package K.HBD.domain.sentence.service;

import K.HBD.domain.enumType.Emotion;
import K.HBD.domain.sentence.Sentence;
import K.HBD.domain.sentence.dto.SentenceDto;

public interface SentenceService {
    void addSentence(SentenceDto sentenceDto);
    Sentence findSentenceByUseLetterIsNotUseLetter(Emotion emotion);
}
