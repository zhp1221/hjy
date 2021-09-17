package com.zhanghp.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhanghp.bean.*;
import com.zhanghp.mapper.*;
import com.zhanghp.objectValues.CellMessage;
import com.zhanghp.objectValues.UnitMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhanghp
 * @version: 1.0
 */
@Service
public class EstateService {
    @Autowired
    private TblCompanyMapper tblCompanyMapper;
    @Autowired
    private FcEstateMapper fcEstateMapper;
    @Autowired
    private FcBuildingMapper fcBuildingMapper;
    @Autowired
    private FcUnitMapper fcUnitMapper;
    @Autowired
    private FcCellMapper fcCellMapper;
    /**
     *从数据库获得公司集合
     * @return 公司集合
     */
    public List<TblCompany> selectCompany(){
        return tblCompanyMapper.selectCompany();
    }

    /**
     * 插入住宅基本信息
     * 插入前，判断插入的值在数据库是否唯一
     * @param fcEstate 前端传来的fcEstate对象
     * @return
     */
    public Integer insertEstate(FcEstate fcEstate){
        //查询数据库是否有重复的estate_code字段
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("estate_code",fcEstate.getEstateCode());
        FcEstate fe = fcEstateMapper.selectOne(queryWrapper);
        int result = 0;
        //判断，是否插入
        if (fe == null ) {
            result = fcEstateMapper.insert(fcEstate);

        }
        return result;
    }

    /**
     * 因为数据库没有楼宇的数据(fc_building表)，所以通过此服务层创建数据，在返回查询
     * @param buildingNumber 楼宇数量
     * @param estateCode 楼宇编码(唯一)
     * @return
     */
    public List<FcBuilding> selectBuilding(Integer buildingNumber, String estateCode){
        List<FcBuilding> fcBuildings = new ArrayList<>();
        for (int i = 0; i < buildingNumber; i++) {
            FcBuilding fcBuilding = new FcBuilding();
            fcBuilding.setBuildingCode(estateCode + "B" + (i+1));
            fcBuilding.setBuildingName(estateCode + "第" + (i+1) + "楼");
            //insertEstate做了estateCode唯一的校验方法，所以不会重复插入
            fcBuilding.setEstateCode(estateCode);
            fcBuildingMapper.insert(fcBuilding);
            fcBuildings.add(fcBuilding);
        }
        return fcBuildings;
    }

    /**
     * 添加楼宇详细信息
     * @param fcBuilding
     * @return
     */
    public int updateBuilding(FcBuilding fcBuilding){
        int result = fcBuildingMapper.updateById(fcBuilding);
        return result;
    }

    public List<FcUnit> selectUnit(UnitMessage unitMessage){
        List<FcUnit> fu = new ArrayList<>();
        for (Integer i = 0; i < unitMessage.getUnitCount(); i++) {
            FcUnit fcUnit = new FcUnit();
            fcUnit.setBuildingCode(unitMessage.getBuildingCode());
            fcUnit.setUnitCode(unitMessage.getBuildingCode()+ "U" + (i+1));
            fcUnit.setUnitName(unitMessage.getBuildingCode()+ "第" + (i+1) + "单元");
            fcUnitMapper.insert(fcUnit);
            fu.add(fcUnit);
        }
        return fu;
    }

    public int updateUnit(FcUnit fcUnit){
        return fcUnitMapper.updateById(fcUnit);
    }

    public List<FcCell> insertCell(CellMessage[] cellMessages){
        List<FcCell> fcs = new ArrayList<>();
        // 单元集合
        for (CellMessage cellMessage : cellMessages) {
            // 楼层
            for (int i = 0; i < cellMessage.getStopFloor(); i++) {
                // 房间号
                for (int j = 0; j < cellMessage.getStopCellId(); j++) {
                    FcCell fc = new FcCell();
                    fc.setUnitCode(cellMessage.getUnitCode());
                    fc.setUnitCode(cellMessage.getUnitCode());
                    fc.setCellName(i + "0" + j);
                    fc.setCellCode("C" + i + "0" + j);
                    fc.setFloorNumber(i);
                    fcCellMapper.insert(fc);
                    fcs.add(fc);
                }
            }
        }
        return fcs;
    }
}
