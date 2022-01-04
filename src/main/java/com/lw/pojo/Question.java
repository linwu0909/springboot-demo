package com.lw.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Description:
 * date: 2021/6/24 21:55
 *
 * @author Jim Lin
 */
@Data
@Table(name = "t_question")
public class Question {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String title; // 标题
    private String content; // 内容
    private Date createDate;
    private Date updateDate;
    private String note; // 笔记
}
