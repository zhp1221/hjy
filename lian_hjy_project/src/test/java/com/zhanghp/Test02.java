package com.zhanghp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhanghp.bean.FcEstate;
import com.zhanghp.bean.TblCompany;
import com.zhanghp.bean.TblRole;
import com.zhanghp.bean.TblUserRecord;
import com.zhanghp.mapper.FcEstateMapper;
import com.zhanghp.mapper.TblCompanyMapper;
import com.zhanghp.mapper.TblRoleMapper;
import com.zhanghp.mapper.TblUserRecordMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author: zhanghp
 * @version: 1.0
 */
@SpringBootTest
public class Test02 {
    @Autowired
    private TblUserRecordMapper tblUserRecordMapper;
    @Autowired
    private TblRoleMapper tblRoleMapper;

    @Test
    public void privilege(){
        TblUserRecord admin = tblUserRecordMapper.login("admin", "c4ca4238a0b923820dcc509a6f75849b");
        /*System.out.println(admin);
        System.out.println("----------------------------");
        System.out.println(admin.getTblRole());
        System.out.println("----------------------");
        System.out.println(admin.getTblRole().getRolePrivileges());*/
        List<TblRole> role = tblRoleMapper.role();
        for (TblRole tblRole : role) {
            System.out.println(tblRole);
        }
        System.out.println(role.get(0));

    }
    @Autowired
    private TblCompanyMapper tblCompanyMapper;
    @Test
    public void company(){
        List<TblCompany> companies = tblCompanyMapper.selectCompany();
    }
    @Autowired
    private FcEstateMapper fcEstateMapper;
    @Test
    public void estate(){
        QueryWrapper<FcEstate> qw = new QueryWrapper<>();
        qw.eq("estate_code","1");
        FcEstate fcEstate = fcEstateMapper.selectOne(qw);
        System.out.println(fcEstate);
    }
}
