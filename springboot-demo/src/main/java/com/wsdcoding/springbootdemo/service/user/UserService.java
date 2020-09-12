package com.wsdcoding.springbootdemo.service.user;

import com.wsdcoding.springbootdemo.dao.user.UserMapper;
import com.wsdcoding.springbootdemo.domian.entity.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 用户接口
 * @Authror wsdcoding
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {
    private final UserMapper userMapper;

    //select * from user where id = #{id} 这里注意一下SQL中 #{} 和 ${} 的区别
    public User findById(Integer id) {
        return this.userMapper.selectByPrimaryKey(id);
    }
}
