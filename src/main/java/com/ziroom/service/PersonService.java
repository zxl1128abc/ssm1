package com.ziroom.service;

import com.ziroom.entity.PersonEntity;

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
 * @date 2018/9/30 14:55
 * @since 1.0
 */
public interface PersonService {
    /**
     * 查询所有人
     * @return
     */
    List<PersonEntity> queryAll();

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    PersonEntity queryById(String id);

    /**
     * 添加人
     * @param personEntity
     */
    void save(PersonEntity personEntity);

    /**
     * 修改人
     * @param personEntity
     */
    void update(PersonEntity personEntity);

    /**
     * 删除
     * @param id
     */
    void delete(String id);

    /**
     * 分页查询
     * @param page
     * @return
     */
    List<PersonEntity> queryByPage(Integer page);

    /**
     * 查询总数量
     * @return
     */
    Integer queryCount();

}
