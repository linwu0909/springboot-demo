package com.lw.service.impl;

import com.lw.mapper.QuestionMapper;
import com.lw.pojo.Question;
import com.lw.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * date: 2021/6/24 21:56
 *
 * @author Jim Lin
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public void insertQuestionInfo(Question question) {
        questionMapper.insert(question);
    }

    @Override
    public Question queryQuestionInfoById(Integer id) {
        return questionMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateQuestionInfo(Question question) {
        questionMapper.updateByPrimaryKey(question);
    }

    @Override
    public void deleteQuestionInfoById(Integer id) {
        questionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Question> queryQuestionByKeyword(String keyword) {
        Example example = new Example(Question.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("title", keyword);
        List<Question> questions = questionMapper.selectByExample(example);
        return questions;
    }
}
