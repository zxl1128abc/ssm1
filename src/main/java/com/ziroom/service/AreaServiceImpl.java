package com.ziroom.service;

import com.ziroom.dao.AreaDAO;
import com.ziroom.entity.AreaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
 * @date 2018/10/11 14:13
 * @since 1.0
 */
@Transactional
@Service("areaService")
public class AreaServiceImpl implements AreaService{

    @Autowired
    private AreaDAO areaDAO;
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public List<AreaEntity> queryByCityCode(String cityCode) {
        return areaDAO.queryByCityCode(cityCode);
    }
}
