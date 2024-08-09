package org.amn.repository;

import org.amn.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository  extends JpaRepository<Question,Integer> {


    List<Question> findByCategory(String category);

    @Query(value = "select * from Question q where q.category=:category order by random() limit :numQ",nativeQuery = true)
    List<Question> getLimitedQuestionsByCategory(String category, int numQ);
}
