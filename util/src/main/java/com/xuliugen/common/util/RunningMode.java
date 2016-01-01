package com.xuliugen.common.util;

/***
 * 使用debug模式必须在加上 -DrunningMode=debug
 * eclipse加在preferences->tomcat->jvmSettings->append to jvm parameters的最后
 */
public class RunningMode {
    private static RunningModeType running_mode = init();

    public enum RunningModeType {
        DEVELOP, PRODUCT
    }

    private static RunningModeType init() {
        if (RunningModeType.DEVELOP.name().equalsIgnoreCase(System.getProperty("runningMode"))) {
            return RunningModeType.DEVELOP;
        }
        return RunningModeType.PRODUCT;
    }

    public static String getRunningMode() {
        return running_mode.name();
    }

    public static boolean isDevelop() {
        if (running_mode.equals(RunningModeType.DEVELOP)) {
            return true;
        }
        return false;
    }
}
