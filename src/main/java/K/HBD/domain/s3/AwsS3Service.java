package K.HBD.domain.s3;

import K.HBD.domain.card.dto.request.ImageDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface AwsS3Service {
    String uploadImageFromS3(MultipartFile multipartFile) throws IOException;

    void deleteIMageFromS3(ImageDto imageDto);
}
