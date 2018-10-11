package com.ziroom.controller;

import com.ziroom.entity.CityEntity;
import com.ziroom.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
 * @date 2018/10/11 14:18
 * @since 1.0
 */
@RequestMapping("/city")
@Controller
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping("/queryByProvinceCode")
    @ResponseBody
    public List<CityEntity> queryByProvinceCode(String provinceCode){
        return cityService.queryByProvinceCode(provinceCode);
    }


}
