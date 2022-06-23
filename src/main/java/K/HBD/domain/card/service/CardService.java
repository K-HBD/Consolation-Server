package K.HBD.domain.card.service;

import K.HBD.domain.card.dto.CardResponseDto;
import org.springframework.web.multipart.MultipartFile;

public interface CardService {
    CardResponseDto responseCard(MultipartFile multipartFile, String name);
}
