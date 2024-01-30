package com.example.demo.api.v1.applicant.service;

import com.example.demo.api.v1.applicant.dto.ApplicantDto;
import com.example.demo.api.v1.applicant.entity.Applicant;
import com.example.demo.api.v1.applicant.mapper.ApplicantMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApplicantService {
    private final ApplicantMapper applicantMapper;

    public ApplicantDto.Response getApplicant(ApplicantDto.Request params){
        return new ApplicantDto.Response(this.applicantMapper.selectApplicantById(params.toEntity()));
    }

    public List<ApplicantDto.Response> getApplicantList() {
        List<Applicant> eventList = this.applicantMapper.selectApplicantList();
        return eventList.stream().map(ApplicantDto.Response::new)
                .collect(Collectors.toList());
    }

    public void confirmApplicant(ApplicantDto.Request params) {
        this.applicantMapper.insertApplicantConfirm(params.toEntity());
    }

    public void registerWinningAddress(ApplicantDto.AddressRequest params){
        this.applicantMapper.insertApplicantWinningAddress(params.toEntity());
    }
}
