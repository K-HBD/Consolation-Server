package K.HBD.domain.s3.controller;

import K.HBD.domain.s3.AwsS3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/api/s3")
public class AwsS3Controller {

    private final AwsS3Service awsS3Service;

    @PostMapping("/image")
    public ResponseEntity<String> uploadFile(@RequestParam("image") MultipartFile multipartFile) throws IOException {
        return ResponseEntity.ok(awsS3Service.uploadFileFromS3(multipartFile));
    }
}
