package K.HBD.domain.s3.controller;

import K.HBD.domain.card.dto.request.ImageDto;
import K.HBD.domain.s3.AwsS3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/api/s3")
public class AwsS3Controller {

    private final AwsS3Service awsS3Service;

    @PostMapping("/image")
    public ResponseEntity<String> updateImage(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        return ResponseEntity.ok(awsS3Service.updateImageFromS3(multipartFile));
    }

    @DeleteMapping("/image")
    public ResponseEntity<String> deleteImage(@RequestBody ImageDto imageDto) {
        awsS3Service.deleteIMageFromS3(imageDto);
        return ResponseEntity.ok("Success");
    }

}
