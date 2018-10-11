package com.ziroom.service;

import com.ziroom.entity.UserEntity;

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
 * @date 2018/9/30 14:41
 * @since 1.0
 */
public interface UserService {
    /**
     * 根据姓名获取用户
     * @param username
     * @return
     */
    UserEntity queryByUsername(String username);


}
