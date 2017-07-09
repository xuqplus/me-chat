package cn.xuqplus.controller;

import cn.xuqplus.util.ImageCaptcha;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by qqx on 2017/7/8.
 */
@RestController
@RequestMapping("/api")
public class ImageCaptchaController {
    @RequestMapping("/captcha.check")
    public Map imageCaptchaCheck(
            HttpServletRequest request,
            @RequestParam String captchaName,
            @RequestParam String captchaInput) {
        Map result = new HashMap();
        String captcha = (String) request.getSession().getAttribute(captchaName);
        if (!captchaInput.toLowerCase().equals(captcha)) {
            result.put("success", false);
            result.put("message", "验证失败");
            return result;
        }
        long now = new Date().getTime();
        long captchaTime = (long) request.getSession().getAttribute(captchaName.replace("str", "time"));
        if (now - captchaTime > 5 * 6 * 1000) {
            result.put("success", false);
            result.put("message", "验证码失效");
            return result;
        }
        result.put("success", true);
        return result;
    }


    @RequestMapping("/captcha")
    public void imageCaptcha(
            @RequestParam Integer fontSize,
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        Map<String, Object> map = ImageCaptcha.getImageCaptcha(null == fontSize ? 25 : fontSize);
        request.getSession().setAttribute("captcha.str", map.get("captcha.str").toString().toLowerCase());
        request.getSession().setAttribute("captcha.time", new Date().getTime());
        ImageIO.write((BufferedImage) map.get("captcha.image"), "JPEG", response.getOutputStream());
    }
}
