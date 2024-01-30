package com.example.demo.controller;

import com.example.demo.ApiDocumentationTest;
import com.example.demo.dto.EventDto;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.JsonFieldType;

import java.time.LocalDateTime;

import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UnitControllerTests extends ApiDocumentationTest {

    @Test
    void hello() throws Exception {
        mockMvc.perform(get("/"))  // request uri
                .andExpect(status().isOk()) //상태값이 200인지
                .andDo(
                        document("test", getRequestPreprocessor(), getResponsePreprocessor(),
                                responseFields(
                                        fieldWithPath("key").type(JsonFieldType.STRING).description("키 값"))
                        )
                );
    }

    @Test
    void testEventItem() throws Exception {

        EventDto eventDto = eventDto();
        when(unitService.getEvent(1L))
                .thenReturn(eventDto);

        this.mockMvc.perform(
                        RestDocumentationRequestBuilders.get("/event/{id}", 1)
                                .accept(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk())
                .andDo(document("events-find",
                        getRequestPreprocessor(),
                        getResponsePreprocessor(),
                        pathParameters(
                                parameterWithName("id").description("아이디")
                        ),
                        responseFields(
                                fieldWithPath("id").type(JsonFieldType.NUMBER).description("이벤트 아이디"),
                                fieldWithPath("eventName").type(JsonFieldType.STRING).description("이벤트 이름"),
                                fieldWithPath("brandName").type(JsonFieldType.STRING).description("<<error, 브랜드 이름>>"),
                                fieldWithPath("startDt").type(JsonFieldType.STRING).description("이벤트 시작일"),
                                fieldWithPath("endDt").type(JsonFieldType.STRING).description("이벤트 종료일")
                        )
                ));

    }

    private EventDto eventDto() {
        EventDto eventDto = new EventDto();
        eventDto.setId(234234L);
        eventDto.setEventName("event name 입니다");
        eventDto.setBrandName("brand name 입니다");
        LocalDateTime now = LocalDateTime.now();
        eventDto.setStartDt(now);
        eventDto.setEndDt(now);
        return eventDto;
    }
}
