package cn.xuqplus.domain;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by qqx on 2017/7/12.
 */
public class Captcha {
    private String captcha_value;
    private Long captcha_time;

    public Captcha() {
    }

    public Captcha(String captcha_value, Long captcha_time) {
        this.captcha_value = captcha_value;
        this.captcha_time = captcha_time;
    }

    public void setCaptcha_value(String captcha_value) {
        this.captcha_value = captcha_value;
    }

    public void setCaptcha_time(Long captcha_time) {
        this.captcha_time = captcha_time;
    }

    public String getCaptcha_value() {
        return captcha_value;
    }

    public Long getCaptcha_time() {
        return captcha_time;
    }

    public static Map check(HttpServletRequest request, Captcha captcha) {
        Map result = new HashMap();
        Captcha captchaInSession = (Captcha) request.getSession().getAttribute("captcha");
        if (null == captchaInSession) {
            result.put("success", false);
            result.put("message", "验证码未生成");
            return result;
        }
        if (!captcha.getCaptcha_value().toLowerCase().equals(captchaInSession.getCaptcha_value().toLowerCase())) {
            result.put("success", false);
            result.put("message", "验证码不匹配");
            return result;
        }
        if (captcha.getCaptcha_time() - captchaInSession.getCaptcha_time() > 5 * 60 * 1000) {
            result.put("success", false);
            result.put("message", "验证码超过5分钟");
            return result;
        }
        result.put("success", true);
        return result;
    }
}
