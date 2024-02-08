package com.example.demo.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    SUCCESS("00000", HttpStatus.OK, List.of("성공")),
    INVALID_ACCESS_TOKEN("10001", HttpStatus.UNAUTHORIZED, List.of("잘못된 접근입니다. 유효한 토큰이 아닙니다.")),
    EXPIRED_ACCESS_TOKEN("10002", HttpStatus.UNAUTHORIZED, List.of("액세스 토큰이 만료되었습니다. 리프레시 하거나 다시 로그인 해야 합니다.")),
    BAD_PARAMETER("40001", HttpStatus.BAD_REQUEST, List.of("잘못된 요청입니다.")),
    NOT_FOUND("40002", HttpStatus.NOT_FOUND, List.of("자원을 찾지 못했습니다.")),
    INTERNAL_SERVER_ERROR("50001", HttpStatus.INTERNAL_SERVER_ERROR,  List.of("Internal Server Error")),
    FAILED_REGISTER("50002", HttpStatus.INTERNAL_SERVER_ERROR, List.of("등록에 실패했습니다.")),
    FAILED_MODIFY("50003", HttpStatus.INTERNAL_SERVER_ERROR, List.of("수정에 실패했습니다."));

    private final String code;
    private final HttpStatus status;
    private final List<String> messages;
}
