package com.example.demo.controller;

import com.example.demo.constant.ErrorCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.stream.Collectors;

public class ErrorCodeMap extends ErrorCodeController.ErrorCodeResponse {
    public static String ErrorCodeMap() {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode rootNode = objectMapper.createObjectNode();

        for (ErrorCode errorCode : ErrorCode.values()) {
            ObjectNode errorCodeNode = objectMapper.createObjectNode();
            errorCodeNode.put("code", errorCode.getCode());
            errorCodeNode.put("message", String.join(",", errorCode.getMessages()));
            errorCodeNode.put("status", errorCode.getStatus().value());

            rootNode.set(errorCode.name(), errorCodeNode);
        }

        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
