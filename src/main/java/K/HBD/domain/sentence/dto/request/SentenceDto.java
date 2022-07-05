package K.HBD.domain.sentence.dto.request;

import K.HBD.domain.enumType.Emotion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SentenceDto {
    private String letter;
    private Emotion emotion;
}
