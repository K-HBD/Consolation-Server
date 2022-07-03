package K.HBD.domain.card.service.Impl;

import K.HBD.domain.card.dto.request.CardDto;
import K.HBD.domain.card.dto.request.EmotionDto;
import K.HBD.domain.card.dto.request.ImageDto;
import K.HBD.domain.card.dto.response.CardResponseDto;
import K.HBD.domain.card.service.CardService;
import K.HBD.domain.sentence.repository.SentenceRepository;
import K.HBD.domain.sentence.service.SentenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CardServiceImpl implements CardService {

    private final SentenceService sentenceService;
    private final SentenceRepository sentenceRepository;

    @Value("${cloud.aws.s3.url}")
    private String BASE_URI; // s3에 저장되는 모든 파일의 기본 base url


    @Override
    @Transactional
    public CardResponseDto responseCard(CardDto card) {
        EmotionDto emotion = getEmotionFromModel(card.getImage()); // AI 모델 서버에서 가져올 임시 감정

        return CardResponseDto.builder()
                .sentence(sentenceRepository.findLetterByEmotion(emotion.getEmotion()))
                .imageUrl(BASE_URI + card.getImage())
                .name(card.getName())
                .emotion(emotion.getEmotion())
                .build();
    }

    private EmotionDto getEmotionFromModel(String imageUrl) {
        return WebClient.create()
                .post()
                .uri("http://10.120.72.237:8082/api/model")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(imageUrl), ImageDto.class)
                .retrieve()
                .bodyToMono(EmotionDto.class)
                .block();
    }
}
