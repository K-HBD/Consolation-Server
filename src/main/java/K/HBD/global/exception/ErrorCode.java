package K.HBD.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    FAILED_CONVERT_FILE("File Convert Failed", 411),
    FILE_IS_EMPTY("File Is Empty", 400),
    FAILED_SAVE_IMAGE("Image Save Failed", 500),
    OUT_OF_STRING_INDEX("Out of String Index", 400)
;
    private final String message;
    private final int status;
}
