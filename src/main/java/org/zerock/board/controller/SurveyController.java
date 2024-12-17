package org.zerock.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.board.entity.Survey1;
import org.zerock.board.service.SurveyService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class SurveyController {

    private final SurveyService surveyService;

    @GetMapping("/survey")
    public String showSurveyForm() {
        return "survey";  // survey.html 폼을 반환
    }

    // 설문 응답을 처리하는 POST 요청
    @PostMapping("/submit-survey")
    public String submitSurvey(
            @RequestParam String status,
            @RequestParam String major,
            @RequestParam String visitFrequency,
            Model model) {

        // 설문 응답 생성
        Survey1 survey1 = surveyService.createSurvey(status, major, visitFrequency);

        // 설문 응답 생성 후, 생성된 설문 정보와 함께 뷰를 반환
        model.addAttribute("survey", survey1);
        return "results";
    }

    @GetMapping("/survey/results")
    public String getSurveyResults(Model model) {
        // 설문 결과를 서비스에서 가져오기
        List<Survey1> surveys = surveyService.getAllSurveys();

        // 방문 빈도별로 응답 수를 그룹화
        Map<String, Long> result = surveys.stream()
                .collect(Collectors.groupingBy(survey -> survey.getVisitFrequency().toString(), Collectors.counting()));

        // 모델에 결과를 추가
        model.addAttribute("surveyResults", result);

        System.out.println("Survey Results: " + result);

        // 결과를 보여주는 HTML 페이지를 반환
        return "results";
    }

}
