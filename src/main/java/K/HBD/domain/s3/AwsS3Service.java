package K.HBD.domain.s3;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface AwsS3Service {
    String uploadFileFromS3(MultipartFile multipartFile) throws IOException;
}
