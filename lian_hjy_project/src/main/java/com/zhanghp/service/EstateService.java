package com.zhanghp.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhanghp.bean.FcBuilding;
import com.zhanghp.bean.FcEstate;
import com.zhanghp.bean.TblCompany;
import com.zhanghp.mapper.FcBuildingMapper;
import com.zhanghp.mapper.FcEstateMapper;
import com.zhanghp.mapper.TblCompanyMapper;
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
            fcBuilding.setBuildingCode("B"+(i+1));
            fcBuilding.setBuildingName("第"+ (i+1) +"楼");
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
}
