package com.ziroom.controller;

import com.ziroom.common.ProvinceEnum;
import com.ziroom.entity.AreaEntity;
import com.ziroom.entity.CityEntity;
import com.ziroom.entity.PersonEntity;
import com.ziroom.entity.ProvinceEntity;
import com.ziroom.response.AllPersonResponse;
import com.ziroom.service.AreaService;
import com.ziroom.service.CityService;
import com.ziroom.service.PersonService;
import com.ziroom.service.ProvinceService;
import jdk.nashorn.internal.parser.DateParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
 * @date 2018/9/30 15:02
 * @since 1.0
 */
@Controller
@RequestMapping("/person")
public class PersonController {

    private static final Logger LOGGER =LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonService personService;

    @Autowired
    private ProvinceService provinceService;
    @Autowired
    private CityService cityService;
    @Autowired
    private AreaService areaService;

    /**
     * 查询所有人
     * @return
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public List<AllPersonResponse> queryAll(){
        List<AllPersonResponse> responseList = new ArrayList<>();
        List<PersonEntity> personEntities = personService.queryAll();
        for (PersonEntity personEntity : personEntities) {
            AllPersonResponse personResponse = new AllPersonResponse();
            personResponse.setAge(personEntity.getAge());
            personResponse.setId(personEntity.getId());
            personResponse.setName(personEntity.getName());
            String format = new SimpleDateFormat("yyyy-MM-dd").format(personEntity.getBir());
            personResponse.setBir(format);
            ProvinceEntity provinceEntity = provinceService.queryByCode(personEntity.getProvinceCode());
            if(provinceEntity != null){
                personResponse.setProvinceName(provinceEntity.getName());
            }
            CityEntity cityEntity = cityService.queryByCode(personEntity.getCityCode());
            if(cityEntity != null){
                personResponse.setCityName(cityEntity.getName());
            }
            AreaEntity areaEntity = areaService.queryByCode(personEntity.getAreaCode());
            if(areaEntity != null){
                personResponse.setAreaName(areaEntity.getName());
            }
            responseList.add(personResponse);
        }
        return responseList;
    }


    /**
     * 查询所有人管理列表页
     * @param modelMap
     * @return
     */
    @RequestMapping("/allPersonList")
    public String allPersonList(ModelMap modelMap){
        ProvinceEnum[] provinceEnums = ProvinceEnum.values();
        //获取所有省份
        modelMap.addAttribute("provinceEnums",provinceEnums);

        return "back/person/queryAllPerson";
    }

    /**
     * 通过id查询某个人
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryById")
    public PersonEntity queryById(String id){
        return personService.queryById(id);
    }

    /**
     * 添加人
     * @param name
     * @param age
     * @param bir
     */
    @ResponseBody
    @RequestMapping("/savePerson")
    public Map<String,Object> savePerson(String name, Integer age, @DateTimeFormat(pattern = "yyyy-MM-dd") Date bir){
        Map<String,Object> resultMap = new HashMap<>(2);
        try{
            PersonEntity personEntity = new PersonEntity();
            personEntity.setAge(age);
            String decodeName = URLDecoder.decode(name, "UTF-8");
            personEntity.setName(decodeName);
            personEntity.setBir(bir);
            personEntity.setId(UUID.randomUUID().toString().replaceAll("-",""));
            personService.save(personEntity);
            resultMap.put("success",true);
            resultMap.put("message","保存成功！");
        }catch (Exception e){
            LOGGER.error("保存失败"+e.getMessage(),e);
            resultMap.put("success",false);
            resultMap.put("message","保存失败！");
        }
     return resultMap;
    }


    /**
     * 修改人
     * @param personEntity
     */
    @ResponseBody
    @RequestMapping("/updatePerson")
    public Map<String,Object> updatePerson(@RequestBody PersonEntity personEntity){ //@RequestBody 将前台json格式字符串自动封装对应的java对象  前台提交方式必须post
        Map<String,Object> resultMap = new HashMap<>(2);
        try{
           personService.update(personEntity);
            resultMap.put("success",true);
            resultMap.put("message","修改成功！");
        }catch (Exception e){
            LOGGER.error("修改失败"+e.getMessage(),e);
            resultMap.put("success",false);
            resultMap.put("message","修改失败！");
        }
        return resultMap;
    }


    /**
     * 删除人
     * @param id
     */
    @ResponseBody
    @RequestMapping("/delete")
    public Map<String,Object> delete(String id){
        Map<String,Object> resultMap = new HashMap<>(2);
        try{
            personService.delete(id);
            resultMap.put("success",true);
            resultMap.put("message"," 删除成功！");
        }catch (Exception e){
            LOGGER.error(" 删除失败"+e.getMessage(),e);
            resultMap.put("success",false);
            resultMap.put("message"," 删除失败！");
        }
        return resultMap;
    }

    /**
     * 分页查询
     * @param page
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryByPage")
    public Map<String,Object> queryByPage(Integer page){
        Map<String,Object> resultMap = new HashMap<>(2);
        Integer count = personService.queryCount();
        resultMap.put("total",count);
        List<PersonEntity> personEntities = personService.queryByPage(page);
        resultMap.put("rows",personEntities);
        return resultMap;
    }

}
