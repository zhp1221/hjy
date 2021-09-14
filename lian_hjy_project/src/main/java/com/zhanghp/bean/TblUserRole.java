package com.zhanghp.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 用户角色表
 * </p>
 *
 * @author zhanghp
 * @since 2021-09-12
 */
public class TblUserRole implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 用户编号
     */
    private String userId;

    /**
     * 角色编号
     */
    private Integer roleId;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "TblUserRole{" +
        "userId=" + userId +
        ", roleId=" + roleId +
        "}";
    }
}
