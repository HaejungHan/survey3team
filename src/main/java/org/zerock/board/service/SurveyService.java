package org.zerock.board.service;

import org.zerock.board.entity.Survey1;

import java.util.List;


public interface SurveyService {

    Survey1 createSurvey(String statusString, String majorString, String visitFrequencyString);

    Survey1 getSurveyById(Long surveyId);

    List<Survey1> getAllSurveys();
}
