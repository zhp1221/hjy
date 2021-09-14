package com.zhanghp.returnJson;

import java.util.List;

/**
 * @author: zhanghp
 * @version: 1.0
 */
public class Permissions {
    private List<Permission> permissions;

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public Permissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
