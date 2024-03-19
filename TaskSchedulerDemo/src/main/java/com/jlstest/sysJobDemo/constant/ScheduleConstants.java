package com.jlstest.sysJobDemo.constant;

/**
 * @author JLS
 * @description:
 * @since 2024-02-18 15:00
 */
public class ScheduleConstants {

    public static enum Status {
        /**
         * 正常
         */
        NORMAL("0"),
        /**
         * 暂停
         */
        PAUSE("1");

        private final String value;

        Status(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public static final String TASK_PROPERTIES = "job";
}
