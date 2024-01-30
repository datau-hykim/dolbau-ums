package com.example.demo.api.v1.applicant.controller;

import com.example.demo.annotation.AuthParam;
import com.example.demo.api.v1.applicant.dto.ApplicantDto;
import com.example.demo.api.v1.applicant.service.ApplicantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/v1/applicants")
public class ApplicantController {
    private final ApplicantService applicantService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<ApplicantDto.Response> applicantList(){
        return this.applicantService.getApplicantList();
    }

    @GetMapping("/{applicantId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ApplicantDto.Response applicantDetail(@PathVariable int applicantId, @AuthParam int memberId){
        return this.applicantService.getApplicant(ApplicantDto.Request.builder()
                        .applicantId(applicantId)
                        .memberId(memberId)
                .build());
    }

    @PutMapping("/{applicantId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void confirmApplicant(@PathVariable int applicantId, @AuthParam int memberId){
        this.applicantService.confirmApplicant(ApplicantDto.Request.builder()
                        .applicantId(applicantId)
                        .memberId(memberId)
                .build());
    }

    @PostMapping("/{applicantId}/address")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void registerWinningAddress(@PathVariable int applicantId, @AuthParam int memberId, @RequestBody ApplicantDto.AddressRequest params){
        this.applicantService.registerWinningAddress(params);
    }
}
