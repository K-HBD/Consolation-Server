package K.HBD.domain.card.dto.request;

import K.HBD.domain.enumType.Emotion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class EmotionDto {
    private Emotion emotion;
}
