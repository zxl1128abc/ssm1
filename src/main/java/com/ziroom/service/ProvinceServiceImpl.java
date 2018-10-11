package com.ziroom.service;

import com.ziroom.dao.ProvinceDAO;
import com.ziroom.entity.ProvinceEntity;
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
 * @date 2018/10/11 11:27
 * @since 1.0
 */
@Service("provinceService")
@Transactional
public class ProvinceServiceImpl implements ProvinceService{
    @Autowired
    private ProvinceDAO provinceDAO;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public List<ProvinceEntity> queryAll() {
        return provinceDAO.queryAll();
    }
}
