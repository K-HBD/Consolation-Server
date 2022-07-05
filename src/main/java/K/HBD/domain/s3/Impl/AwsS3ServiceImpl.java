package K.HBD.domain.s3.Impl;

import K.HBD.domain.card.dto.request.ImageDto;
import K.HBD.domain.s3.AwsS3Service;
import K.HBD.global.exception.CustomException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import static K.HBD.global.exception.ErrorCode.*;

@RequiredArgsConstructor
@Service
public class AwsS3ServiceImpl implements AwsS3Service {

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    private final AmazonS3 amazonS3;

    @Override
    public String updateImageFromS3(MultipartFile file) {
        String fileName = "";
        multipartFileIsNullCheck(file);

        String imageName = file.getOriginalFilename();

        fileName = createFileName(imageName);

        ObjectMetadata om = setObjectMetadata(file);

        putS3(file, fileName, om);

        return fileName;
    }

    @Override
    public void deleteIMageFromS3(ImageDto imageDto) {
        imageUrlNullCheck(imageDto);
        deleteS3(imageDto.getImageUrl());
    }

    private void imageUrlNullCheck(ImageDto imageDto) {
        if (imageDto.getImageUrl().length() == 0) {
            throw new CustomException(IMAGE_IS_NULL);
        }
    }

    private void deleteS3(String imageName) {
        try {
            amazonS3.deleteObject(new DeleteObjectRequest(bucket, imageName));
        } catch(AmazonServiceException e) {
            throw new CustomException(AMAZONS_SERVICE_EXCEPTION);
        }
    }

    private void putS3(MultipartFile file, String fileName, ObjectMetadata om) {
        try (InputStream inputStream = file.getInputStream()) {
            amazonS3.putObject(new PutObjectRequest(bucket, fileName, inputStream, om)
                    .withCannedAcl(CannedAccessControlList.PublicRead));
        } catch (IOException e) {
            throw new CustomException(FAILED_SAVE_IMAGE);
        } catch (AmazonServiceException e) {
            throw new CustomException(AMAZONS_SERVICE_EXCEPTION);
        }
    }

    private void multipartFileIsNullCheck(MultipartFile file) {
        if (file.getSize() == 0) {
            throw new CustomException(FILE_IS_EMPTY);
        }
    }

    private String createFileName(String fileName) {
        return UUID.randomUUID().toString().concat(getFileExtension(fileName));
    }

    private String getFileExtension(String fileName) {
        try {
            return fileName.substring(fileName.lastIndexOf("."));
        } catch (StringIndexOutOfBoundsException e) {
            throw new CustomException(OUT_OF_STRING_INDEX);
        }
    }

    private ObjectMetadata setObjectMetadata(MultipartFile file) {
        ObjectMetadata om = new ObjectMetadata();
        om.setContentLength(file.getSize());
        om.setContentType(file.getContentType());

        return om;
    }
}
