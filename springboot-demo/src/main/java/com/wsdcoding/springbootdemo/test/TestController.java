package com.wsdcoding.springbootdemo.test;

import com.wsdcoding.springbootdemo.dao.user.UserMapper;
import com.wsdcoding.springbootdemo.domian.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Authror wsdcoding
 */
@RestController
public class TestController {
    //TODO
    /**
     * 关于xxxxMapper红线的问题解决方法：
     * 1.可以改成@Autowired(required = true) 或者 @Service; 研究他们两个的区别
     * 2.在Mapper接口添加@Repository或者@Component; 研究@Service、@Controller和前两个的区别
     * 3.类上加@RequiredArgsConstructor(onConstructor = @__(@Autowired)),
     *   再定义final ：    private final UserMapper userMapper;
     */
    @Autowired
    private UserMapper userMapper;


    @GetMapping("/test")
    public List<User> test() {
        User user = new User();
//        user.setId(3);
        user.setName("zhaoliu");
        this.userMapper.insertSelective(user);
        List<User> userList = this.userMapper.selectAll();
        return userList;
    }
}
