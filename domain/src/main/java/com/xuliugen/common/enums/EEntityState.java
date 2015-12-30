package com.xuliugen.common.enums;

/**
 * 实体状态枚举（对应数据库中记录）
 */
public enum EEntityState {
    VALID(0, "有效"),
    INVALID(1, "无效");

    public Integer val;
    public String desc;

    EEntityState(Integer val, String desc) {
        this.val = val;
        this.desc = desc;
    }

    public static EEntityState getTypeByVal(Integer val) {
        EEntityState defaultState = VALID;
        for (EEntityState eEntityState : EEntityState.values()) {
            if (eEntityState.val.equals(val)) {
                return eEntityState;
            }
        }
        return defaultState;
    }

    public static String getDescByVal(Integer val) {
        return getTypeByVal(val).desc;
    }

}
