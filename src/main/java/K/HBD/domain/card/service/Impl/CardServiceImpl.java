package K.HBD.domain.card.service.Impl;

import K.HBD.domain.card.dto.CardDto;
import K.HBD.domain.card.dto.CardResponseDto;
import K.HBD.domain.card.service.CardService;
import K.HBD.domain.enumType.Emotion;
import K.HBD.domain.sentence.Sentence;
import K.HBD.domain.sentence.service.SentenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CardServiceImpl implements CardService {

    private final SentenceService sentenceService;
    private final static String BASE_URI = "https://consolationbucket.s3.ap-northeast-2.amazonaws.com/"; // s3에 저장되는 모든 파일의 기본 base url

    @Override
    @Transactional
    public CardResponseDto responseCard(CardDto card) {
        Emotion emotion = Emotion.SAD; // AI 모델 서버에서 가져올 임시 감정

        Sentence sentence = sentenceService.findSentenceByUseLetterIsNotUseLetter(emotion);

        return CardResponseDto.builder()
                .sentence(sentence.getLetter())
                .image(BASE_URI + card.getFile())
                .name(card.getName())
                .emotion(emotion)
                .build();
    }
}
