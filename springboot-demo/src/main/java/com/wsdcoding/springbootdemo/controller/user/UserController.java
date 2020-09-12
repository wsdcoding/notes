package com.wsdcoding.springbootdemo.controller.user;

import com.wsdcoding.springbootdemo.domian.entity.user.User;
import com.wsdcoding.springbootdemo.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Authror wsdcoding
 */

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private final UserService userService;
    @GetMapping("/{id}")
    public User findById(@PathVariable Integer id){ //PathVariable比如("/{id}")传1的时候就给到Integer后的 id属性
        return this.userService.findById(id);
    }
}
