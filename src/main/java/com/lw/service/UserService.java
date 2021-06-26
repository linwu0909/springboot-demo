package com.lw.service;

import com.lw.pojo.User;

/**
 * Description:
 * date: 2021/6/24 21:56
 *
 * @author Jim Lin
 */
public interface UserService {
    public void insertUserInfo(User user);
    public User queryUserInfoById(Integer id);
    public void updateUserInfo(User user);
    public void deleteUserInfoById(Integer id);
}
