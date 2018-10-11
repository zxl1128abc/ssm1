package com.ziroom.dao;

import com.ziroom.entity.RoleEntity;

import java.util.List;

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
 * @date 2018/10/9 17:50
 * @since 1.0
 */
public interface RoleDAO {

    /**
     * 根据用户名查询用户所对应的角色
     * @param username
     * @return
     */
    List<RoleEntity> queryByUsername(String username);
}
