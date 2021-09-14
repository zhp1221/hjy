package com.zhanghp.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 角色菜单权限
 * </p>
 *
 * @author zhanghp
 * @since 2021-09-12
 */
public class TblRoleMenuPrivi implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 模块id
     */
    private Integer modelId;


    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    @Override
    public String toString() {
        return "TblRoleMenuPrivi{" +
        "roleId=" + roleId +
        ", modelId=" + modelId +
        "}";
    }
}
