package com.example.demo.api.v1.applicant.mapper;

import com.example.demo.api.v1.applicant.entity.Applicant;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApplicantMapper {
    Applicant selectApplicantById(Applicant applicant);

    List<Applicant> selectApplicantList();

    void insertApplicantConfirm(Applicant applicant);

    void insertApplicantWinningAddress(Applicant applicant);
}
