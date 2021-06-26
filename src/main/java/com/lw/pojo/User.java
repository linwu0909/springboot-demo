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
@Table(name = "t_user")
public class User {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private String sex;
    private Date birthday;
    private Date createDate;
    private Date updateDate;
    private String note;
}
