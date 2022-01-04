package com.lw.controller;

import com.lw.pojo.Question;
import com.lw.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * date: 2021/6/24 21:54
 *
 * @author Jim Lin
 */
@RestController
@Slf4j
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @RequestMapping(value = "/insert")
    public Map insert(@RequestBody Question question){
        HashMap<Object,Object> map = new HashMap<Object,Object>();

        try {
            question.setCreateDate(new Date());
            question.setUpdateDate(new Date());
            questionService.insertQuestionInfo(question);

            map.put("success",true);
            map.put("message","数据插入成功！");
            log.debug("数据插入成功");
            return map;
        }catch (Exception e){
            e.printStackTrace();
            log.debug("数据插入失败！");
            map.put("success",false);
            map.put("message","数据插入失败");
            return map;
        }
    }

    @RequestMapping(value = "/update")
    public Map update(@RequestBody Question question){
        HashMap<Object,Object> map = new HashMap<Object,Object>();

        try {
            question.setCreateDate(new Date());
            question.setUpdateDate(new Date());
            questionService.updateQuestionInfo(question);
            map.put("success",true);
            map.put("message","数据更新成功！");
            log.debug("数据更新成功");
            return map;
        }catch (Exception e){
            e.printStackTrace();
            log.debug("数据更新失败！");
            map.put("success",false);
            map.put("message","数据更新失败");
            return map;
        }
    }

    @RequestMapping(value = "/query")
    public Map queryById(@RequestBody Question question){
        HashMap<Object,Object> map = new HashMap<Object,Object>();

        try {
            List<Question> questionList = questionService.queryQuestionByKeyword(question.getTitle());
            log.debug("数据查询成功！");
            map.put("success",true);
            map.put("message","数据查询成功！");
            map.put("result",questionList);
            return map;
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
            map.put("message","数据查询失败！");
            log.debug("数据查询失败！");
            return map;
        }
    }

    @RequestMapping(value = "/delete")
    public Map deleteById(@RequestBody Question question){
        HashMap<Object,Object> map = new HashMap<Object,Object>();

        try {
            questionService.deleteQuestionInfoById(question.getId());
            log.debug("数据删除成功！");
            map.put("success",true);
            map.put("message","数据删除成功！");
            return map;
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
            map.put("message","数据删除失败！");
            log.debug("数据删除失败！");
            return map;
        }
    }
}
