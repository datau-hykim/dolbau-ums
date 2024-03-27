package com.example.demo.constant.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;


@Getter
@RequiredArgsConstructor
public enum ErrorCodeImpl implements ErrorCode {
    SUCCESS("000000", HttpStatus.OK, List.of("성공")),
    INVALID_ACCESS_TOKEN("100001", HttpStatus.UNAUTHORIZED, List.of("잘못된 접근입니다. 유효한 토큰이 아닙니다.")),
    EXPIRED_ACCESS_TOKEN("100002", HttpStatus.UNAUTHORIZED, List.of("액세스 토큰이 만료되었습니다. 리프레시 하거나 다시 로그인 해야 합니다.")),
    BAD_PARAMETER("400001", HttpStatus.BAD_REQUEST, List.of("잘못된 요청입니다.")),
    NOT_FOUND("400002", HttpStatus.NOT_FOUND, List.of("자원을 찾지 못했습니다.")),
    INTERNAL_SERVER_ERROR("500001", HttpStatus.INTERNAL_SERVER_ERROR,  List.of("Internal Server Error")),
    FAILED_REGISTER("500002", HttpStatus.INTERNAL_SERVER_ERROR, List.of("등록에 실패했습니다.")),
    FAILED_MODIFY("500003", HttpStatus.INTERNAL_SERVER_ERROR, List.of("수정에 실패했습니다."));

    private final String code;
    private final HttpStatus status;
    private final List<String> messages;

    @Getter
    public enum COMMON implements ErrorCode {
        NETWORK_ERROR("101", HttpStatus.BAD_REQUEST, List.of("네트워크 연결이 불안정합니다. 잠시 후 다시 이용해 주세요"));

        private static final String UPPER_CODE = "900";
        private String code;
        private HttpStatus status;
        private List<String> messages;

        COMMON(String code, HttpStatus status, List<String> messages) {
            this.code = UPPER_CODE + code;
            this.status = status;
            this.messages = messages;
        }
    }

    @Getter
    public enum MONTHLY_EVENT implements ErrorCode {
        NOT_FOUND_EVENT("101", HttpStatus.BAD_REQUEST, List.of("유효하지 않은 이벤트입니다.")),
        EXIST_APPLY_EVENT("102", HttpStatus.BAD_REQUEST, List.of("이미 응모한 이벤트입니다."));

        private static final String UPPER_CODE = "300";
        private final String code;
        private final HttpStatus status;
        private final List<String> messages;

        MONTHLY_EVENT(String code, HttpStatus status, List<String> messages) {
            this.code = UPPER_CODE + code;
            this.status = status;
            this.messages = messages;
        }
    }
}
