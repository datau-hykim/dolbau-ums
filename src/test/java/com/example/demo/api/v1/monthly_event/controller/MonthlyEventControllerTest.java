package com.example.demo.api.v1.monthly_event.controller;

import com.example.demo.api.v1.monthly_event.dto.MonthlyEventDto;
import com.example.demo.api.v1.monthly_event.entity.MonthlyEvent;
import com.example.demo.api.v1.monthly_event.service.MonthlyEventService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.operation.preprocess.Preprocessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@AutoConfigureRestDocs
@WebMvcTest(MonthlyEventController.class)
public class MonthlyEventControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MonthlyEventService monthlyEventService;

    @DisplayName("월간이벤트 상세 조회")
    @Test
    void getMonthlyEventById() throws Exception {
        // given
        given(this.monthlyEventService.getMonthlyEventById(1))
                .willReturn(new MonthlyEventDto.ResponseList(
                        MonthlyEvent.builder()
                                .eventId(1)
                                .eventNm("보조배터리 겸용 랜턴1")
                                .brandNm("쿠비녹스")
                                .winningQuantity(500)
                                .thumbImgUrl("/app/event/20231212165235_eventItem_3.jpg")
                                .mainImgUrl("/app/event/20231212165235_eventItem_1.jpg")
                                .detailImgUrl("/app/event/20231212165235_eventItem_2.jpg")
                                .eventApplyStartDtm(LocalDateTime.now().minusDays(30))
                                .eventApplyEndDtm(LocalDateTime.now().plusDays(10))
                                .build()
                ))
        ;

        // when & then
        this.mockMvc.perform(MockMvcRequestBuilders.get("/v1/monthly-events/1"))
                .andDo(MockMvcResultHandlers.print())
                .andDo(MockMvcRestDocumentation.document("monthly-events/getMonthlyEventById",
                        Preprocessors.preprocessRequest(Preprocessors.prettyPrint()),
                        Preprocessors.preprocessResponse(Preprocessors.prettyPrint())))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
