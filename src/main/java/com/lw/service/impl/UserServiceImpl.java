package com.lw.service.impl;

import com.lw.mapper.UserMapper;
import com.lw.pojo.User;
import com.lw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 * date: 2021/6/24 21:56
 *
 * @author Jim Lin
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void insertUserInfo(User user) {
        userMapper.insert(user);
    }

    @Override
    public User queryUserInfoById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateUserInfo(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public void deleteUserInfoById(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }
}
