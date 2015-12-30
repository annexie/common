package com.xuliugen.common.enums;

/**
 * 数据库中记录状态的枚举
 */
public enum ERecordState {
    VALID(0, "有效"),
    INVALID(1, "无效");

    public Integer val;
    public String desc;

    ERecordState(Integer val, String desc) {
        this.val = val;
        this.desc = desc;
    }

    public static ERecordState getTypeByVal(Integer val) {
        ERecordState defaultState = VALID;
        for (ERecordState eRecordState : ERecordState.values()) {
            if (eRecordState.val.equals(val)) {
                return eRecordState;
            }
        }
        return defaultState;
    }

    public static String getDescByVal(Integer val) {
        return getTypeByVal(val).desc;
    }

}
