package com.zhanghp.objectValues;

/**
 * 用于接收前端step2.vue向后端传递相应的参数
 * 由于bean里没有相对应的实体类，所以创建此类接收
 * @author: zhanghp
 * @version: 1.0
 */
public class UnitMessage {
    private String buildingCode;
    private Integer unitCount;

    public UnitMessage() {
    }

    public UnitMessage(String buildingCode, Integer unitCount) {
        this.buildingCode = buildingCode;
        this.unitCount = unitCount;
    }

    @Override
    public String toString() {
        return "UnitMessage{" +
                "buildingCode='" + buildingCode + '\'' +
                ", unitCount=" + unitCount +
                '}';
    }

    public String getBuildingCode() {
        return buildingCode;
    }

    public void setBuildingCode(String buildingCode) {
        this.buildingCode = buildingCode;
    }

    public Integer getUnitCount() {
        return unitCount;
    }

    public void setUnitCount(Integer unitCount) {
        this.unitCount = unitCount;
    }
}
