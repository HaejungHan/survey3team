package org.zerock.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.zerock.board.entity.*;
import org.zerock.board.repository.survey.Survey1Repository;
import org.zerock.board.repository.user.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SurveyServiceImpl implements SurveyService {

    private final Survey1Repository survey1Repository;
    private final UserRepository userRepository;

    @Override
    public Survey1 createSurvey(String statusString, String majorString, String visitFrequencyString) {
        // Status와 Major를 Enum으로 변환
        Status status = Status.fromString(statusString);
        Major major = Major.fromString(majorString);

        // User 객체 생성 및 저장
        User user = new User(status, major);
        userRepository.save(user);

        // VisitFrequency를 Enum으로 변환
        VisitFrequency visitFrequency = VisitFrequency.fromString(visitFrequencyString);

        // Survey 객체 생성
        Survey1 survey = new Survey1(user, visitFrequency);

        // 설문 응답 저장
        return survey1Repository.save(survey);
    }

    // 특정 설문 응답을 찾는 메서드 (Optional)
    public Survey1 getSurveyById(Long surveyId) {
        return survey1Repository.findById(surveyId)
                .orElseThrow(() -> new IllegalArgumentException("설문조사 ID가 존재하지 않습니다."));
    }

    public List<Survey1> getAllSurveys() {
        return survey1Repository.findAll();
    }
}
