-- 建库
CREATE DATABASE `coursedb` CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';

-- course表
CREATE TABLE `coursedb`.`course`  (
                                        `cid` bigint(0) NOT NULL,
                                        `cname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                                        `user_id` bigint(0) NOT NULL,
                                        `cstatus` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                                        PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

CREATE TABLE `coursedb`.`course_1`  (
                                      `cid` bigint(0) NOT NULL,
                                      `cname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                                      `user_id` bigint(0) NOT NULL,
                                      `cstatus` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                                      PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

CREATE TABLE `coursedb`.`course_2`  (
                                      `cid` bigint(0) NOT NULL,
                                      `cname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                                      `user_id` bigint(0) NOT NULL,
                                      `cstatus` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                                      PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- user表
CREATE TABLE `coursedb`.`user`  (
                                        `userid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                                        `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                                        `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                                        `password_cipher` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                                        `userstatus` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                                        `age` int(0) DEFAULT NULL,
                                        `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'F or M',
                                        PRIMARY KEY (`userid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

CREATE TABLE `coursedb`.`user_1`  (
                                    `userid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                                    `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                                    `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                                    `password_cipher` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                                    `userstatus` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                                    `age` int(0) DEFAULT NULL,
                                    `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'F or M',
                                    PRIMARY KEY (`userid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

CREATE TABLE `coursedb`.`user_2`  (
                                    `userid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                                    `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                                    `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                                    `password_cipher` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                                    `userstatus` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                                    `age` int(0) DEFAULT NULL,
                                    `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'F or M',
                                    PRIMARY KEY (`userid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
-- 用户信息表
CREATE TABLE `coursedb`.`user_course_info`  (
                                         `infoid` bigint(0) NOT NULL,
                                         `userid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                                         `courseid` bigint(0) DEFAULT NULL,
                                         PRIMARY KEY (`infoid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
-- 字典表
CREATE TABLE `coursedb`.`dict`  (
                                        `dictId` bigint(0) NOT NULL,
                                        `dictkey` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                                        `dictVal` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                                        PRIMARY KEY (`dictId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

CREATE TABLE `coursedb`.`dict_1`  (
                                    `dictId` bigint(0) NOT NULL,
                                    `dictkey` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                                    `dictVal` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                                    PRIMARY KEY (`dictId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

CREATE TABLE `coursedb`.`dict_2`  (
                                    `dictId` bigint(0) NOT NULL,
                                    `dictkey` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                                    `dictVal` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                                    PRIMARY KEY (`dictId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;