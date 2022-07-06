package K.HBD.domain.sentence.controller;

import K.HBD.domain.sentence.dto.request.SentenceDto;
import K.HBD.domain.sentence.service.SentenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/api/sentence")
public class SentenceController {
    private final SentenceService sentenceService;

    /**
     * 각 감정 별 문구를 추가하기 위한 controller
     * @param sentenceDto letter, emotion
     * @return ResponseEntity - Success
     */
    @PostMapping()
    public ResponseEntity addSentence(@RequestBody SentenceDto sentenceDto) {
        sentenceService.addSentence(sentenceDto);
        return ResponseEntity.ok("Success");
    }
}
