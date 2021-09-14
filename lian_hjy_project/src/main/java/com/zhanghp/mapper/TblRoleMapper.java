package com.zhanghp.mapper;

import com.zhanghp.bean.TblRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 角色档案 Mapper 接口
 * </p>
 *
 * @author zhanghp
 * @since 2021-09-12
 */
public interface TblRoleMapper extends BaseMapper<TblRole> {
    public List<TblRole> role();
}
