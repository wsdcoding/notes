package com.wsdcoding.springbootdemo.test;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description:
 * @Authror wsdcoding
 */
@Data
@NoArgsConstructor //无参构造
@AllArgsConstructor //全参构造
//@RequiredArgsConstructor //为final 属性的成员变量添加构造方法
@Builder
class UserDTO {
    private String name;
    private String address;
}

@Slf4j
public class LombokTest {

    // private static final Logger logger = getLogger(LombokTestController.class); 有了Slf4j 就不用这种方式了
    public static void main(String[] args) {
        //没用@Builder 注解之前创建实例的做法
        UserDTO dto = new UserDTO();
        dto.setName("没注解");
        dto.setAddress("meizhujie");

        // 用@Builder  其实就是一种建造者模式，
        UserDTO userDTO = UserDTO.builder()
                .name("zhangsan")
                .address("nanning")
                .build();

        log.info("构造出来的UserDTO = {} ", dto);
    }
}
