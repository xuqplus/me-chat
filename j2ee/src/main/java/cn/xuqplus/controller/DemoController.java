package cn.xuqplus.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017-06-20.
 */
@RestController
@RequestMapping("/api")
public class DemoController {
    @RequestMapping("/demo")
    public Map demo() {
        Map result = new HashMap();
        result.put("success", true);
        result.put("msg", "ddddd");
        return result;
    }
}
