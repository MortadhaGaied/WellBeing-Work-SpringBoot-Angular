package com.wellbeignatwork.backend.repository.Evaluation;


import com.wellbeignatwork.backend.entity.Evaluation.Answer;
import com.wellbeignatwork.backend.entity.Evaluation.Sentiment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface AnswerRepo extends CrudRepository<Answer,Integer> {

    @Query("select count (*) FROM Answer a where a.Sentiment = :status")
    int nbreByStatus(@Param("status") Sentiment status);





}