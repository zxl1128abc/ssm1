package com.ziroom.dao;

import com.ziroom.entity.ProvinceEntity;

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
 * @date 2018/10/11 10:16
 * @since 1.0
 */
public interface ProvinceDAO {
    /**
     * 查询所有省份
     * @return
     */
    List<ProvinceEntity> queryAll();
}
