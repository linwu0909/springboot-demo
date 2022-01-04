package com.lw.service;

import com.lw.pojo.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * date: 2021/6/24 21:56
 *
 * @author Jim Lin
 */
public interface QuestionService {
    public void insertQuestionInfo(Question question);
    public Question queryQuestionInfoById(Integer id);
    public void updateQuestionInfo(Question question);
    public void deleteQuestionInfoById(Integer id);
    public List<Question> queryQuestionByKeyword(String keyword);
}
