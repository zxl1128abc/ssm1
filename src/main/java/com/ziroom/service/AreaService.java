package com.ziroom.service;

import com.ziroom.entity.AreaEntity;

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
 * @date 2018/10/11 11:33
 * @since 1.0
 */
public interface AreaService {
    /**
     * 根据城市编号获取所有的
     * @param cityCode
     * @return
     */
    List<AreaEntity> queryByCityCode(String cityCode);
    /**
     * 根据编号查询县区
     * @param code
     * @return
     */
    AreaEntity queryByCode(String code);
}
