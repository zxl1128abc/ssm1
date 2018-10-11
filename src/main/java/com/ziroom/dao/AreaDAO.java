package com.ziroom.dao;

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
 * @date 2018/10/11 10:19
 * @since 1.0
 */
public interface AreaDAO {
    /**
     * 根据城市编号获取该城市下的所有城区或县
     * @param cityCode
     * @return
     */
    List<AreaEntity> queryByCityCode(String cityCode);
}
