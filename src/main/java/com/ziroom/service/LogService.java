package com.ziroom.service;

import com.ziroom.entity.LogEntity;

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
 * @date 2018/10/9 18:29
 * @since 1.0
 */
public interface LogService {

    List<LogEntity> queryAll();
}
