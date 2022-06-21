package K.HBD.domain.card.service;

import K.HBD.domain.card.dto.CardResponse;
import org.springframework.web.multipart.MultipartFile;

public interface CardService {
    CardResponse createCard(MultipartFile multipartFile, String name);
}
