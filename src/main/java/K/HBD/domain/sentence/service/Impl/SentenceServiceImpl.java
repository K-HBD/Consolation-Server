package K.HBD.domain.sentence.service.Impl;

import K.HBD.domain.enumType.Emotion;
import K.HBD.domain.enumType.Use;
import K.HBD.domain.sentence.Sentence;
import K.HBD.domain.sentence.dto.SentenceDto;
import K.HBD.domain.sentence.repository.SentenceRepository;
import K.HBD.domain.sentence.service.SentenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class SentenceServiceImpl implements SentenceService {
    private final SentenceRepository sentenceRepository;
    private final static Use NOT_USED_LETTER = Use.NOT_USED_LETTER; //문구가 사용됐는 지 안됐는 지를 검사하기 위한 static Enum


    /**
     * 요청으로 받아온 감정과 문장을 DB에 저장하는 서비스 로직
     * @param sentenceDto letter emotion
     */
    @Override
    public void addSentence(SentenceDto sentenceDto) {
        Sentence sentence = Sentence.builder()
                .letter(sentenceDto.getLetter())
                .emotion(sentenceDto.getEmotion())
                .build();

        sentenceRepository.save(sentence);
    }

    @Transactional
    public Sentence findSentenceByUseLetterIsNotUseLetter(Emotion emotion) {
        return findSentence(emotion);
    }

    private Sentence findSentence(Emotion emotion) {
        Sentence sentence = sentenceRepository.findSentenceByUseLetter(NOT_USED_LETTER, emotion);

        if (sentence == null) {
            updateSentence(emotion);

            sentence = sentenceRepository.findSentenceByUseLetter(NOT_USED_LETTER, emotion);
        }

        sentence.update(Use.USED_LETTER);
        return sentence;
    }

    private void updateSentence(Emotion emotion) {
        sentenceRepository.updateSentenceByAllUseLetter(Use.USED_LETTER, emotion);
    }
}
