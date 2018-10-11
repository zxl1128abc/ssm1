package com.ziroom.service;

import com.ziroom.dao.PersonDAO;
import com.ziroom.entity.PersonEntity;
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
 * @date 2018/9/30 14:56
 * @since 1.0
 */
@Transactional
@Service("personService")
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonDAO personDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<PersonEntity> queryAll() {
        return personDAO.queryAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public PersonEntity queryById(String id) {
        return personDAO.queryById(id);
    }

    @Override
    public void save(PersonEntity personEntity) {
        personDAO.save(personEntity);
    }

    @Override
    public void update(PersonEntity personEntity) {
        personDAO.update(personEntity);
    }

    @Override
    public void delete(String id) {
        personDAO.delete(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<PersonEntity> queryByPage(Integer page) {
        return personDAO.queryByPage(page);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Integer queryCount() {
        return personDAO.queryCount();
    }
}
