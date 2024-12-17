package org.zerock.board.repository.survey;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zerock.board.entity.Survey1;

@Repository
public interface Survey1Repository extends JpaRepository<Survey1, Long> {

    Survey1 getSurveyById(Long surveyId);
}
