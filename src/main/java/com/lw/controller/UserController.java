package com.lw.controller;

import com.lw.pojo.User;
import com.lw.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * date: 2021/6/24 21:54
 *
 * @author Jim Lin
 */
@RestController
@Slf4j
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/insert")
    public Map insert(@RequestBody User user){
        HashMap<Object,Object> map = new HashMap<Object,Object>();

        try {
            user.setCreateDate(new Date());
            user.setBirthday(new Date());
            user.setUpdateDate(new Date());
            userService.insertUserInfo(user);
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
    public Map update(@RequestBody User user){
        HashMap<Object,Object> map = new HashMap<Object,Object>();

        try {
            user.setCreateDate(new Date());
            user.setBirthday(new Date());
            user.setUpdateDate(new Date());
            userService.updateUserInfo(user);
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
    public Map queryById(@RequestBody User user){
        HashMap<Object,Object> map = new HashMap<Object,Object>();

        try {
            User userInfo = userService.queryUserInfoById(user.getId());
            log.debug("数据查询成功！");
            map.put("success",true);
            map.put("message","数据查询成功！");
            map.put("result",userInfo);
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
    public Map deleteById(@RequestBody User user){
        HashMap<Object,Object> map = new HashMap<Object,Object>();

        try {
            userService.deleteUserInfoById(user.getId());
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
