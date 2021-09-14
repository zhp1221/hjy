package com.zhanghp.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 分组用户
 * </p>
 *
 * @author zhanghp
 * @since 2021-09-12
 */
public class TblGroupsUser implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 分组id
     */
    private Integer groupId;

    /**
     * 对象id
     */
    private String objId;

    /**
     * 绑定类型
     */
    private Integer objType;


    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
    }

    public Integer getObjType() {
        return objType;
    }

    public void setObjType(Integer objType) {
        this.objType = objType;
    }

    @Override
    public String toString() {
        return "TblGroupsUser{" +
        "groupId=" + groupId +
        ", objId=" + objId +
        ", objType=" + objType +
        "}";
    }
}
