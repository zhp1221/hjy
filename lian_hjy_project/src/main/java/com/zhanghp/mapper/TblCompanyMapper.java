package com.zhanghp.mapper;

import com.zhanghp.bean.TblCompany;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 企业档案 Mapper 接口
 * </p>
 *
 * @author zhanghp
 * @since 2021-09-12
 */
public interface TblCompanyMapper extends BaseMapper<TblCompany> {
    public List<TblCompany > selectCompany();
}
