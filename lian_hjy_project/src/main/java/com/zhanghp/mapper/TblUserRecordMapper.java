package com.zhanghp.mapper;

import com.zhanghp.bean.TblRole;
import com.zhanghp.bean.TblUserRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户档案 Mapper 接口
 * </p>
 *
 * @author zhanghp
 * @since 2021-09-12
 */
public interface TblUserRecordMapper extends BaseMapper<TblUserRecord> {
    public TblUserRecord login(@Param("username")String username,@Param("password")String password);


}
