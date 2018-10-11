package com.ziroom.service;

import com.ziroom.dao.CityDAO;
import com.ziroom.entity.CityEntity;
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
 * @date 2018/10/11 11:31
 * @since 1.0
 */
@Service("cityService")
@Transactional
public class CityServiceImpl implements CityService{

    @Autowired
    private CityDAO cityDAO;
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public List<CityEntity> queryByProvinceCode(String provinceCode) {
        return cityDAO.queryByProvinceCode(provinceCode);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public CityEntity queryByCode(String code) {
        return cityDAO.queryByCode(code);
    }
}
