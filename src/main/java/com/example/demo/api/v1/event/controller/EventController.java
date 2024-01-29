package com.example.demo.api.v1.event.controller;

import com.example.demo.api.v1.event.dto.EventDTO;
import com.example.demo.api.v1.event.entity.Event;
import com.example.demo.api.v1.event.entity.EventApply;
import com.example.demo.api.v1.event.service.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * URI 컨벤션
 * URI는 스네이크 케이스와 소문자 사용
 *
 */

/**
 * Controller 메서드 명을 작성 할 때는 아래와 같은 접미사를 붙인다.
 * eventList() – 목록 조회 유형의 서비스
 * eventDetail() – 단 건 상세 조회 유형의 controller 메서드
 * eventSave() – 등록/수정/삭제 가 동시에 일어나는 유형의 controller 메서드
 * eventAdd() – 등록만 하는 유형의 controller 메서드
 * eventModify() – 수정만 하는 유형의 controller 메서드
 * eventRemove() – 삭제만 하는 유형의 controller 메서드
 */

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/v1/events")
public class EventController {

    private final EventService eventService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Event> eventList(){
        return this.eventService.getEventList();
    }

    @GetMapping("/{eventId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Event eventDetail(@PathVariable String eventId){
        return this.eventService.getEvent(eventId);
    }


    @GetMapping("/{eventId}/apply/{applyId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public EventApply eventApplyDetail(@PathVariable String eventId, @PathVariable String applyId){
        return this.eventService.getEventApply(
                EventDTO.EventApplyRequest.builder()
                .eventId(eventId)
                .applyId(applyId)
                .memberId("")
                .build()
        );
    }

    @PostMapping("/{eventId}/apply")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public EventApply applyEvent(@PathVariable String eventId){
        return this.eventService.applyEvent(
                EventDTO.EventApplyRequest.builder()
                        .eventId(eventId)
                        .memberId("")
                        .build()
        );
    }

    @PostMapping("/{eventId}/apply/{applyId}/confirm")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public EventApply confirmApplyEvent(@PathVariable String eventId, @PathVariable String applyId){
        return this.eventService.confirmEventApply(
                EventDTO.EventApplyRequest.builder()
                        .eventId(eventId)
                        .applyId(applyId)
                        .memberId("")
                        .build()
        );
    }

    @PostMapping("/{eventId}/winning/{winningId}/address")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> saveEventApplyAddress(@PathVariable String eventId,
                                                   @PathVariable String applyId,
                                                   @RequestBody EventDTO.ApplyAddressRequest applyAddress
                                                   ){
        return ResponseEntity.status(HttpStatus.OK).body("");
    }
}
