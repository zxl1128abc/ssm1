package com.ziroom.common;

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
 * @date 2018/10/11 16:03
 * @since 1.0
 */
public enum ProvinceEnum {

    BEIJING("110000", "北京市"),
    TIANJIN("120000", "天津市"),
    HEBEI("130000", "河北省"),
    SHANXI("140000", "山西省"),
    NEIMENGGU("150000", "内蒙古自治区"),
    LIAONING("210000", "辽宁省"),
    JILIN("220000", "吉林省"),
    HEILONGJIANG("230000", "黑龙江省"),
    SHANGHAI("310000", "上海市"),
    JIANGSU("320000", "江苏省"),
    ZHEJIANG("330000", "浙江省"),
    ANHUI("340000", "安徽省"),
    FUJIAN("350000", "福建省"),
    JIANGXI("360000", "江西省"),
    SHANDONG("370000", "山东省"),
    HENAN("410000", "河南省"),
    HUBEI("420000", "湖北省"),
    HUNAN("430000", "湖南省"),
    GUANGDONG("440000", "广东省"),
    GUANGXI("450000", "广西壮族自治区"),
    HAINAN("460000", "海南省"),
    CHONGQING("500000", "重庆市"),
    SICHUAN("510000", "四川省"),
    GUIZHOU("520000", "贵州省"),
    YUNNAN("530000", "云南省"),
    XIZANG("540000", "西藏自治区"),
    SHANXIS("610000", "陕西省"),
    GANSU("620000", "甘肃省"),
    QINGHAI("630000", "青海省"),
    NINGXIA("640000", "宁夏回族自治区"),
    XINJIANG("650000", "新疆维吾尔自治区"),
    TAIWAN("710000", "台湾省"),
    XIANGGANG("810000", "香港特别行政区"),
    AOMEN("820000", "澳门特别行政区");

    private String code;
    private String name;

    ProvinceEnum(String code, String name) {
        this.code = code;
        this.name = name;
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
}
