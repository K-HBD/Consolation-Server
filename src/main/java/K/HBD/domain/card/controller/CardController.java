package K.HBD.domain.card.controller;

import K.HBD.domain.card.dto.CardDto;
import K.HBD.domain.card.dto.CardResponseDto;
import K.HBD.domain.card.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/api/card")
public class CardController {

    private final CardService cardService;

    @PostMapping()
    public ResponseEntity<CardResponseDto> takeCard(@RequestBody CardDto card) {
        return ResponseEntity.ok(cardService.responseCard(card));
    }
}
