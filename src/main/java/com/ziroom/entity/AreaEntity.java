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
 * @date 2018/10/11 10:12
 * @since 1.0
 */
public class AreaEntity {

    private Integer id;

    private String code;

    private String name;

    private String cityId;

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

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "AreaEntity{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", cityId='" + cityId + '\'' +
                '}';
    }

    public AreaEntity() {
    }

    public AreaEntity(Integer id, String code, String name, String cityId) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.cityId = cityId;
    }
}
