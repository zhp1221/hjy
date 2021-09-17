package com.zhanghp.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhanghp.bean.*;
import com.zhanghp.mapper.TblCompanyMapper;
import com.zhanghp.objectValues.CellMessage;
import com.zhanghp.objectValues.UnitMessage;
import com.zhanghp.returnJson.ReturnObject;
import com.zhanghp.service.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhanghp
 * @version: 1.0
 */
@RestController
public class EstateController {
    @Autowired
    private EstateService estateService;

    @RequestMapping("/estate/selectCompany")
    public JSONObject selectCompany(){
        System.out.println("selectCompany");
        List<TblCompany> companies = estateService.selectCompany();
        return JSONObject.parseObject(JSONObject.toJSONString(new ReturnObject(companies)));
    }

    @RequestMapping("/estate/insertEstate")
    public JSONObject insertEstate( FcEstate fcEstate){
        System.out.println("estate/insertEstate");
        Integer result = estateService.insertEstate(fcEstate);
        if (result==0) {
            return JSONObject.parseObject(JSONObject.toJSONString(new ReturnObject("0","房产编码已经存在")));
        } else {
            return JSONObject.parseObject(JSONObject.toJSONString(new ReturnObject("1","插入房产成功")));
        }
    }

    @RequestMapping("/estate/selectBuilding")
    public JSONObject selectBuilding(Integer buildingNumber, String estateCode){
        System.out.println("select_Building");
        List<FcBuilding> fcBuildings = estateService.selectBuilding(buildingNumber, estateCode);
        return JSONObject.parseObject(JSONObject.toJSONString(new ReturnObject(fcBuildings)));
    }

    @RequestMapping("/estate/updateBuilding")
    public JSONObject updateBuilding(FcBuilding fcBuilding){
        int result = estateService.updateBuilding(fcBuilding);
        if (result == 1) {
            return JSONObject.parseObject(JSONObject.toJSONString(new ReturnObject("更新楼宇成功")));
        }else {
            return JSONObject.parseObject(JSONObject.toJSONString(new ReturnObject("更新楼宇失败")));

        }
    }

    @RequestMapping("/estate/selectUnit")
    public JSONObject selectUnit(@RequestBody UnitMessage[] unitMessages){
        System.out.println("estate_selectUnit");
        List<FcUnit> fus = new ArrayList<>();
        for (UnitMessage unitMessage : unitMessages) {
            fus.addAll(estateService.selectUnit(unitMessage));
        }
        return JSONObject.parseObject(JSONObject.toJSONString(new ReturnObject(fus)));
    }

    @RequestMapping("/estate/updateUnit")
    public JSONObject updateUnit(FcUnit fcUnit){
        int result = estateService.updateUnit(fcUnit);
        if (result == 1) {
            return JSONObject.parseObject(JSONObject.toJSONString(new ReturnObject("更新单元成功")));
        }else {
            return JSONObject.parseObject(JSONObject.toJSONString(new ReturnObject("更新单元失败")));

        }
    }

    @RequestMapping("estate/insertCell")
    public JSONObject insertCell(@RequestBody CellMessage[] cellMessages){
        List<FcCell> fcCells = estateService.insertCell(cellMessages);
        return JSONObject.parseObject(JSONObject.toJSONString(new ReturnObject(fcCells)));
    }
}
