package K.HBD.global.config.sentence;


import K.HBD.domain.enumType.Emotion;
import K.HBD.domain.sentence.Sentence;
import K.HBD.domain.sentence.dto.SentenceDto;
import K.HBD.domain.sentence.repository.SentenceRepository;
import K.HBD.domain.sentence.service.SentenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class SetSentence {
    private final SentenceRepository sentenceRepository;

    @PostConstruct
    public void setSentence() {
        List<SentenceDto> listSentenceDto = getListSentenceDto(Emotion.SAD,
                "행복의 한쪽 문이 닫히면 다른 쪽 문이 열린다. 그러나 우리는 이미 닫힌 문을 오랫동안 보기 때문에 우리를 위해 열려있는 문을 보지 못한다.",
                "슬플 때 울지 않는 것만큼 더 슬픈 일은 없다. 그러니 슬플 때 당신이 원 없이 슬퍼하고 울어라.",
                "당장 시련을 겪어 힘들더라도 좌절하지 마라, 그 힘듦이 꼭 너를 성장하게 만들 계기가 되어줄 것이다",
                "모든 나무의 열매들은 온전히 무르익기까지 오랜 시간이 걸린다. 당신 또한 그렇다. 지금 당신의 나무의 열매가 온전히 무르익지 않은 것은 아직 때가 되지 않았단 뜻이다. 언제가 될 진 모르지만, 당신의 나무에도 필히 열매가 맺고 무르익을 것이다.",
                "당신을 아프게 하는 것들이 당신에게 상처를 내더라도 당신의 상처는 결국 아문다. 견디지 않아도 된다. 어차피 아물 상처니까."
        );

        getListSentenceDto(Emotion.DISGUST,
                "모든 사람과의 관계가 좋을 필요는 없다. 하지만 굳이 사람과의 관계가 나쁠 필요도 없다.",
                "당신이 특정 대상을 혐오하는 만큼, 그 모습을 바라보는 대상은 당신을 혐오할 것이다."
                );

        saveSentence(listSentenceDto);

    }

    private void saveSentence(List<SentenceDto> sentenceDto) {
        for (SentenceDto sentence :sentenceDto) {
            Sentence createSentence = Sentence.builder()
                    .emotion(sentence.getEmotion())
                    .letter(sentence.getLetter())
                    .build();

            sentenceRepository.save(createSentence);
        }
    }

    private List<SentenceDto> getListSentenceDto(Emotion emotion, String...sentence) {
        List<SentenceDto> sentenceDtoList = new ArrayList<>();
        SentenceDto sentenceDto = null;
        for (String letter: sentence) {
            sentenceDto = SentenceDto.builder()
                    .letter(letter)
                    .emotion(emotion)
                    .build();

            sentenceDtoList.add(sentenceDto);
        }

        return sentenceDtoList;
    }
}
