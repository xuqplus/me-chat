package cn.xuqplus.controller;

import cn.xuqplus.domain.User;
import cn.xuqplus.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017-06-20.
 */
@RestController
@RequestMapping("/api/public/demo")
public class DemoController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/findUser")
    public Map demo() {
        Map result = new HashMap();
        result.put("success", true);
        User user = userMapper.findOne();
        result.put("user", user);
        return result;
    }
}
