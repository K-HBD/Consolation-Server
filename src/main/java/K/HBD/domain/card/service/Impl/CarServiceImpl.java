package K.HBD.domain.card.service.Impl;

import K.HBD.domain.card.dto.CardResponse;
import K.HBD.domain.card.service.CardService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CarServiceImpl implements CardService {
    @Override
    public CardResponse createCard(MultipartFile multipartFile, String name) {
        return null;
    }
}
