package com.example.demo.controller;

import com.example.demo.ApiDocumentationTest;
import com.example.demo.constant.ErrorCode;
import com.example.demo.CustomResponseFieldsSnippet;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.restdocs.snippet.Snippet;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.snippet.Attributes.key;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class ErrorCodeControllerTests extends ApiDocumentationTest {

    private static final String ERROR_SNIPPET_FILE = "errorcode-response";

    @Test
    void errorCodes() throws Exception {
        mockMvc.perform(get("/error-code")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(document(ERROR_SNIPPET_FILE,
                customResponseFields(ERROR_SNIPPET_FILE,fieldDescriptors())
        ));
    }

    private List<FieldDescriptor> fieldDescriptors() {
        List<FieldDescriptor> fieldDescriptors = new ArrayList<>();
        for (ErrorCode errorCode : ErrorCode.values()) {
            FieldDescriptor attributes =
                    fieldWithPath(errorCode.name()).type(JsonFieldType.OBJECT)
                            .attributes(
                                    key("code").value(errorCode.getCode()),
                                    key("messages").value(errorCode.getMessages()),
                                    key("statusCode").value(String.valueOf(errorCode.getStatus().value())),
                                    key("status").value(errorCode.getStatus().getReasonPhrase()));
            fieldDescriptors.add(attributes);        }
        return fieldDescriptors;    }

    public static Snippet customResponseFields(String snippetFilePrefix, List<FieldDescriptor> fieldDescriptors) {
        return new CustomResponseFieldsSnippet(snippetFilePrefix, fieldDescriptors, true);
    }

}
