package com.zhanghp.service;

import com.zhanghp.bean.TblUserRecord;
import com.zhanghp.mapper.TblUserRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: zhanghp
 * @version: 1.0
 */
@Service
public class LoginService {
    @Autowired
    private TblUserRecordMapper tblUserRecordMapper;
    public TblUserRecord login(String username,String password){
        return tblUserRecordMapper.login(username,password);
    }
}
