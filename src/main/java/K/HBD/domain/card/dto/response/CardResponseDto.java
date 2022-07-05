package K.HBD.domain.card.dto.response;

import K.HBD.domain.enumType.Emotion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CardResponseDto {
    private String sentence;
    private Emotion emotion;
    private String imageUrl;
    private String name;

}
