package com.seed.enums;

/**
 * @Author Jack
 * @Des
 * @Date 2017/3/17 16:41
 */
public enum BaseTest {

    SUCCESS(1, "预约成功"), NO_NUMBER(0, "库存不足"), REPEAT_APPOINT(-1, "重复预约"), INNER_ERROR(-2, "系统异常");

    private int state;
    private String stateInfo;

    BaseTest(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static BaseTest stateOf(int index) {
        for (BaseTest state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }


}
