package cn.xuqplus.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by qqx on 2017/7/8.
 */
public class ImageCaptcha {
    private static char array[] = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    public static Map<String, Object> getImageCaptcha(Integer fontSize) {
        Map<String, Object> result = new HashMap();
        if (fontSize <= 0 || fontSize > 100) {
            fontSize = 25;
        }
        int width = fontSize * 3 - fontSize / 6;
        int height = fontSize;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        Random random = new Random();
        graphics.setColor(getRandColor(200, 250));
        graphics.fillRect(0, 0, width, height);
        //设定字体
        graphics.setFont(new Font("Times New Roman", Font.PLAIN, height));
        //随机产生200条干扰线，使图象中的验证码不易被其它程序探测到
        graphics.setColor(getRandColor(100, 200));
        for (int i = 0; i < 200; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            graphics.drawLine(x, y, x + xl, y + yl);
        }
        //取随机产生的码
        String str = "";
        //验证码的位数为5
        for (int i = 0; i < 5; i++) {
            char tmp = array[(int) (array.length * Math.random())];
            str += tmp;
            // 将认证码显示到图象中
            graphics.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            graphics.drawString(String.valueOf(tmp), height * i / 2 + 5, height * 4 / 5);
        }
        //释放图形上下文
        graphics.dispose();
        result.put("captcha.image", image);
        result.put("captcha.str", str);
        return result;
    }

    //给定范围获得随机颜色
    static Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255) fc = 255;
        if (bc > 255) bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }
}
