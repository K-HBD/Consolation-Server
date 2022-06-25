package K.HBD.domain.sentence.dto;

import K.HBD.domain.enumType.Emotion;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SentenceDto {
    private String letter;
    private Emotion emotion;
}
