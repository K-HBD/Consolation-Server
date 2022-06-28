package K.HBD.domain.card.service;

import K.HBD.domain.card.dto.request.CardDto;
import K.HBD.domain.card.dto.response.CardResponseDto;

public interface CardService {
    CardResponseDto responseCard(CardDto card);
}
