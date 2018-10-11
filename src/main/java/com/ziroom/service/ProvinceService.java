package com.ziroom.service;

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
 * @date 2018/10/11 11:26
 * @since 1.0
 */
public interface ProvinceService {

    /**
     * 查询所有省份
     * @return
     */
    List<ProvinceEntity> queryAll();

    /**
     * 根据编号查看省份
     * @param code
     * @return
     */
    ProvinceEntity queryByCode(String code);
}
