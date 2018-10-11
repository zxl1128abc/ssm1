package com.ziroom.aop;

import com.ziroom.annotation.LogAnnotation;
import com.ziroom.entity.LogEntity;
import org.apache.shiro.aop.MethodInterceptor;
import org.apache.shiro.aop.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.UUID;

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
 * @date 2018/10/9 15:18
 * @since 1.0
 */
@Component
public class MyAop implements MethodInterceptor{

    private static final Logger LOGGER = LoggerFactory.getLogger(MyAop.class);
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        //什么人  什么时间 做了什么事 成功与否？  （从session中获取用户）
        //http请求，一定得有请求过来时才能够拿到 （有页面请求时，才要写这两行）
        HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        //通过session来获取用户（管理员）
        LogEntity logEntity = new LogEntity();
        logEntity.setId(UUID.randomUUID().toString().replaceAll("-",""));
        logEntity.setUsername(username);
        logEntity.setDate(new Date());
        LogAnnotation annotation = methodInvocation.getMethod().getAnnotation(LogAnnotation.class);
        logEntity.setDoSomething(annotation.description());
        Object proceed = null;
        try{
            //记录操作成功
            proceed = methodInvocation.proceed();
            logEntity.setStatus("true");
        }catch (Exception e){
            LOGGER.error(e.getMessage(),e);
            //记录操作失败
            logEntity.setStatus("false");
        }

        return proceed;
    }
}
