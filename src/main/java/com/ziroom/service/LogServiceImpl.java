package com.ziroom.service;

import com.ziroom.dao.LogDAO;
import com.ziroom.entity.LogEntity;
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
 * @date 2018/10/9 18:30
 * @since 1.0
 */
@Service("logService")
@Transactional
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDAO logDAO;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public List<LogEntity> queryAll() {
        return logDAO.queryAll();
    }
}
