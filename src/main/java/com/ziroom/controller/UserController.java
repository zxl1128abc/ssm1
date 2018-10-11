package com.ziroom.controller;

import com.sun.tools.javac.comp.Check;
import com.ziroom.entity.UserEntity;
import com.ziroom.service.UserService;
import com.ziroom.util.VerifyCodeUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * <p></p>
 * <p>
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 *
 * @author zhangxiuli
 * @version 1.0
 * @date 2018/9/30 15:02
 * @since 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    //@ResponseBody 让其直接跳转到页面时不能使用该注解，使用该注解时直接跳转页面上只返回字符串的值
    public String queryByUsername(UserEntity user,String code, HttpSession session){
        String generateVerifyCode = (String)session.getAttribute("generateVerifyCode");
        UserEntity userEntity = userService.queryByUsername(user.getUsername());
       //创建一个令牌
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        //设置是否记住我
        usernamePasswordToken.setRememberMe(true);
        //获得subject主体
       // Subject subject = SecurityUtils.getSubject();
        //交给shiro进行认证
        if(code.equalsIgnoreCase(generateVerifyCode)){
            if(userEntity ==null){
                return "back/user/loginDialog";
            }else{
                try{
                  //  subject.login(usernamePasswordToken);
                }catch (Exception e){
                    LOGGER.error("shiro权限认证失败"+e.getMessage(),e);
                    //认证失败同样跳入登入页面
                    return "back/user/loginDialog";
                }
                //进入主页面
                return "back/main/mainTab";
            }
        }else{
            //回到当前登录页面
            return "back/user/loginDialog";
        }
    }

    @RequestMapping("/code")
    public void generateImageCode(HttpServletResponse response, HttpSession session){
        String generateVerifyCode = VerifyCodeUtil.generateVerifyCode(4);
        session.setAttribute("generateVerifyCode",generateVerifyCode);
        BufferedImage bufferedImage = VerifyCodeUtil.getImage(110, 50, generateVerifyCode);
        try {
            ImageIO.write(bufferedImage, "png", response.getOutputStream());
        } catch (IOException e) {
            LOGGER.error("验证码生成出错"+e.getMessage(),e);
        }
    }

}
