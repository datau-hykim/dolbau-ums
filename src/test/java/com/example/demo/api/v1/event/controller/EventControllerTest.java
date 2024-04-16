package com.example.demo.api.v1.event.controller;

import com.example.demo.ApiDocumentUtils;
import com.example.demo.api.v1.event.dto.EventDto;
import com.example.demo.api.v1.event.entity.Event;
import com.example.demo.api.v1.event.entity.EventKeyword;
import com.example.demo.api.v1.event.service.EventService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureRestDocs
@WebMvcTest(EventController.class)
class EventControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EventService eventService;

    @Value("${internal-service.image.url}")
    String imageHost;

    @DisplayName("이벤트 상세 조회")
    @Test
    void getEventDetailByEventId() throws Exception {
        EventDto.DetailResponse mockDto = new EventDto.DetailResponse(
                Event.builder()
                        .eventId(1L)
                        .eventNm("스타벅스 데이터유니버스 임직원 이벤트")
                        .eventApplyUrl("https://www.starbucks.com")
                        .eventContent("데이터유니버스 임직원에게만 100만원 상당의 e-card를 지급합니다.")
                        .eventHint("그냥 신청만 하면 됩니다")
                        .eventHost("스타벅스")
                        .eventApplyTypeId(1L)
                        .eventApplyPlatformId(2L)
                        .eventStartDt(LocalDateTime.now().minusDays(10))
                        .eventEndDt(LocalDateTime.now().plusDays(30))
                        .deleteYn("N")
                        .blockYn("N")
                        .eventImageUrl("https://eventu.co.kr/file/012349a-saf-231-qw-asdasd")
                        .eventViews(1024L)
                        .eventApplicants(123L)
                        .eventInterests(17L)
                        .registerMemberId(1L)
                        .registerDtm(LocalDateTime.now())
                        .updateMemberId(1L)
                        .updateDtm(LocalDateTime.now())
                        .build(),
                List.of(
                        new EventKeyword(1L, "스타벅스", 2L, "커피")
                ),
                imageHost
        );

        // given
        given(eventService.getEventDetailByEventId(mockDto.getEventId()))
                .willReturn(mockDto);

        this.mockMvc.perform(
                // when
                get("/v1/events/{eventId}", mockDto.getEventId()))
                .andExpect(status().isOk())
                // then, do something
                .andDo(document("events/getEventDetailByEventId",
                        // auto-generate http-request.adoc
                        ApiDocumentUtils.getDocumentRequest(),
                        // auto-generate http-response.adoc
                        ApiDocumentUtils.getDocumentResponse(),
                        // auto-generate path-parameters.adoc
                        pathParameters(
                                parameterWithName("eventId").description("이벤트 ID")
                        ),
                        // auto-generate response-fields.adoc
                        relaxedResponseFields(new ApiDocumentUtils.DuResponseFieldsInitializer()
                                .setField("eventId",JsonFieldType.NUMBER,"이벤트 ID",true)
                                .setField("eventNm",JsonFieldType.STRING,"이벤트 명",true)
                                .setField("eventApplyUrl",JsonFieldType.STRING,"이벤트 참여 URL",true)
                                .setField("eventContent",JsonFieldType.STRING,"이벤트 내용",true)
                                .setField("eventHint",JsonFieldType.STRING,"이벤트 힌트",true)
                                .setField("eventHost",JsonFieldType.STRING,"이벤트 주최사",true)
                                .setField("eventApplyTypeId",JsonFieldType.NUMBER,"이벤트 응모유형 ID",true)
                                .setField("eventApplyPlatformId",JsonFieldType.NUMBER,"이벤트 응모플랫폼 iD",true)
                                .setField("eventAnnouncementType",JsonFieldType.NUMBER,"이벤트 발표유형", false)
                                .setField("eventAnnouncementDt",JsonFieldType.NUMBER,"이벤트 발표일", false)
                                .setField("eventStartDt",JsonFieldType.NUMBER,"이벤트 시작일",true)
                                .setField("eventEndDt",JsonFieldType.NUMBER,"이벤트 종료일",true)
                                .setField("deleteYn",JsonFieldType.STRING,"삭제여부",true)
                                .setField("blockYn",JsonFieldType.STRING,"차단여부",true)
                                .setField("eventImageUrl",JsonFieldType.STRING,"이벤트 이미지 URL",true)
                                .setField("keywordList[].keywordId",JsonFieldType.NUMBER,"키워드 ID",true)
                                .setField("keywordList[].keywordNm",JsonFieldType.STRING,"키워드명",true)
                                .setField("keywordList[].keywordCategoryId",JsonFieldType.NUMBER,"키워드 카테고리 ID",true)
                                .setField("keywordList[].keywordCategoryNm",JsonFieldType.STRING,"키워드 카테고리 이름",true)
                                .setField("eventViews",JsonFieldType.NUMBER,"이벤트 조회수",true)
                                .setField("eventApplicants",JsonFieldType.NUMBER,"이벤트 참여자수",true)
                                .setField("eventInterests",JsonFieldType.NUMBER,"이벤트 관심수",true)
                                .setField("registerMemberId",JsonFieldType.NUMBER,"등록 회원 ID",true)
                                .setField("registerDtm",JsonFieldType.NUMBER,"등록일시",true)
                                .setField("updateMemberId",JsonFieldType.NUMBER,"갱신 회원 ID",true)
                                .setField("updateDtm",JsonFieldType.NUMBER,"갱신일시",true)
                                .initialize())
                        )
                );
    }
}
