package com.usian.service;

import com.usian.dao.UserMapper;
import com.usian.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service("userService")
public class UserService {
    @Autowired(required = false)
    private UserMapper userMapper;

    public User login(User user) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.orEqualTo("username", user.getUsername());
        List<User> userList = userMapper.selectByExample(example);
        return userList.isEmpty()?null:userList.get(0);
    }
}
