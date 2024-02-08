package com.example.demo.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.ibatis.type.MappedTypes;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum BoardPlatformCode implements CodeEnum {
    YOUTUBE("00001", "youtube"),
    FACEBOOK("00002", "facebook"),
    INSTAGRAM("00003", "instagram"),
    ETC("99999", "etc");

    private final String key;
    private final String value;

    public static BoardPlatformCode findCodeByKey(String key) {
        return Arrays.stream(BoardPlatformCode.class.getEnumConstants())
                .filter(type -> type.getKey().equals(key))
                .findFirst()
                .orElseThrow();
    }

    @MappedTypes(BoardPlatformCode.class)
    public static class TypeHandler extends CodeEnumTypeHandler<BoardPlatformCode> {
        public TypeHandler() {
            super(BoardPlatformCode.class);
        }
    }
}
