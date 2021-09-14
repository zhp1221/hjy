package com.zhanghp.returnJson;

/**
 * @author: zhanghp
 * @version: 1.0
 */
public class Permission {
    private String permissionId;

    public Permission() {
    }

    public Permission(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }
}
