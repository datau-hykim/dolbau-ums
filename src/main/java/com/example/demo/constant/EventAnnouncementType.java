package com.example.demo.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.ibatis.type.MappedTypes;

import java.util.Arrays;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum EventAnnouncementType implements CodeEnum {
    HOMEPAGE("H", "홈페이지 발표"),
    EACH("E", "개별 발표");

    private final String key;
    private final String value;

    public static Optional<EventAnnouncementType> findCodeByKey(String key) {
        return Arrays.stream(EventAnnouncementType.class.getEnumConstants())
                .filter(type -> type.getKey().equals(key))
                .findFirst();
    }

    @MappedTypes(EventAnnouncementType.class)
    public static class TypeHandler extends CodeEnumTypeHandler<EventAnnouncementType> {
        public TypeHandler() {
            super(EventAnnouncementType.class);
        }
    }
}
