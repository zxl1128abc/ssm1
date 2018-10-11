package com.ziroom.entity;

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
 * @date 2018/10/11 9:55
 * @since 1.0
 */
public class ProvinceEntity {

    /**
     * 省id
     */
    private Integer id;
    /**
     * 省编号
     */
    private String code;
    /**
     * 省名称
     */
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProvinceEntity{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public ProvinceEntity() {
    }

    public ProvinceEntity(Integer id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

}
