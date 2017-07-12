package cn.xuqplus.controller;

import cn.xuqplus.domain.Captcha;
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
import java.util.Map;

/**
 * Created by qqx on 2017/7/8.
 */
@RestController
@RequestMapping("/api")
public class ImageCaptchaController {
    @RequestMapping("/captcha")
    public void imageCaptcha(
            @RequestParam Integer fontSize,
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        Map<String, Object> map = ImageCaptcha.getImageCaptcha(null == fontSize ? 25 : fontSize);
        Captcha captcha = new Captcha(map.get("captcha.str").toString(), new Date().getTime());
        request.getSession().setAttribute("captcha", captcha);
        ImageIO.write((BufferedImage) map.get("captcha.image"), "JPEG", response.getOutputStream());
    }
}
