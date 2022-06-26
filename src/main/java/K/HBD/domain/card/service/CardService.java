package K.HBD.domain.card.service;

import K.HBD.domain.card.dto.CardDto;
import K.HBD.domain.card.dto.CardResponseDto;

public interface CardService {
    CardResponseDto responseCard(CardDto card);
}
