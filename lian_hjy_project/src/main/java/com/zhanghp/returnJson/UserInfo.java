package com.zhanghp.returnJson;

/**
 * @author: zhanghp
 * @version: 1.0
 */
public class UserInfo {
    private String name;
    private String avatar = "/avatar2.jpg";
    private Permissions role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Permissions getRole() {
        return role;
    }

    public void setRole(Permissions role) {
        this.role = role;
    }

    public UserInfo(String name, Permissions role) {
        this.name = name;
        this.role = role;
    }
}
