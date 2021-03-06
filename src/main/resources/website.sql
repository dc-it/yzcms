SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for aut_article
-- ----------------------------
DROP TABLE IF EXISTS `aut_article`;
CREATE TABLE `aut_article`
(
    `id`             bigint(0)                                               NOT NULL,
    `titile`         varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
    `keywords`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关键字',
    `description`    varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
    `aut_image_id`   bigint(0)                                               NULL DEFAULT NULL COMMENT '缩略图id',
    `aut_author_id`  bigint(0)                                               NULL DEFAULT NULL COMMENT '作者',
    `type`           int(0)                                                  NULL DEFAULT NULL COMMENT '1->推荐，2->置顶',
    `path`           varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访问路径',
    `cms_menu_id`    int(0)                                                  NULL DEFAULT NULL COMMENT '菜单id',
    `cms_website_id` int(0)                                                  NULL DEFAULT NULL COMMENT '网站id',
    `pageview`       int(0)                                                  NULL DEFAULT 0 COMMENT '阅读数',
    `verify`         bit(1)                                                  NULL DEFAULT NULL COMMENT '是否审核',
    `create_time`    datetime(0)                                             NULL DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime(0)                                             NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for aut_article_content
-- ----------------------------
DROP TABLE IF EXISTS `aut_article_content`;
CREATE TABLE `aut_article_content`
(
    `id`             bigint(0)                                       NOT NULL COMMENT '主键',
    `aut_article_id` bigint(0)                                       NOT NULL COMMENT '文章id',
    `cms_menu_id`    int(0)                                          NOT NULL COMMENT '菜单id',
    `cms_website_id` int(0)                                          NOT NULL COMMENT '网站id',
    `content`        text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
    `create_time`    datetime(0)                                     NULL DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime(0)                                     NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for aut_article_tag_relation
-- ----------------------------
DROP TABLE IF EXISTS `aut_article_tag_relation`;
CREATE TABLE `aut_article_tag_relation`
(
    `id`             bigint(0)   NOT NULL,
    `aut_article_id` bigint(0)   NOT NULL COMMENT '文章id',
    `aut_tag_id`     bigint(0)   NOT NULL COMMENT '标签id',
    `cms_website_id` int(0)      NOT NULL COMMENT '网站id',
    `create_time`    datetime(0) NOT NULL COMMENT '创建时间',
    `update_time`    datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for aut_author
-- ----------------------------
DROP TABLE IF EXISTS `aut_author`;
CREATE TABLE `aut_author`
(
    `id`            int(0)                                                  NOT NULL AUTO_INCREMENT,
    `username`      varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账户名',
    `password`      varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
    `nick_name`     varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '昵称',
    `aut_avatar_id` bigint(0)                                               NULL DEFAULT NULL COMMENT '头像（关联aut_file）',
    `phone`         varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '手机号',
    `email`         varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '邮箱',
    `remark`        varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
    `login_time`    datetime(0)                                             NULL DEFAULT NULL COMMENT '最后登陆时间',
    `create_time`   datetime(0)                                             NULL DEFAULT NULL COMMENT '创建时间/入驻时间',
    `update_time`   datetime(0)                                             NULL DEFAULT NULL COMMENT '更新时间',
    `status`        bit(1)                                                  NULL DEFAULT NULL COMMENT '状态：启用、禁用',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for aut_file
-- ----------------------------
DROP TABLE IF EXISTS `aut_file`;
CREATE TABLE `aut_file`
(
    `id`             bigint(0)                                               NOT NULL,
    `name`           varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件名',
    `path`           varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件地址',
    `type`           int(0)                                                  NULL DEFAULT NULL COMMENT '类型：1->图片',
    `cms_website_id` int(0)                                                  NULL DEFAULT NULL COMMENT '所属网站',
    `create_time`    datetime(0)                                             NULL DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime(0)                                             NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for aut_group
-- ----------------------------
DROP TABLE IF EXISTS `aut_group`;
CREATE TABLE `aut_group`
(
    `id`            bigint(0)                                              NOT NULL AUTO_INCREMENT,
    `aut_author_id` bigint(0)                                              NULL DEFAULT NULL COMMENT '所属作者',
    `name`          varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分组名',
    `enname`        varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分组英文名',
    `path`          varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访问路径',
    `pid`           bigint(0)                                              NULL DEFAULT NULL COMMENT '父id',
    `create_time`   datetime(0)                                            NULL DEFAULT NULL COMMENT '创建时间/入驻时间',
    `update_time`   datetime(0)                                            NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for aut_group_article_relation
-- ----------------------------
DROP TABLE IF EXISTS `aut_group_article_relation`;
CREATE TABLE `aut_group_article_relation`
(
    `id`             bigint(0)   NOT NULL AUTO_INCREMENT,
    `aut_group_id`   bigint(0)   NULL DEFAULT NULL COMMENT '文章分组id',
    `aut_article_id` bigint(0)   NULL DEFAULT NULL COMMENT '文章id',
    `aut_author_id`  bigint(0)   NULL DEFAULT NULL COMMENT '作者id',
    `create_time`    datetime(0) NULL DEFAULT NULL COMMENT '创建时间/入驻时间',
    `update_time`    datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for aut_tag
-- ----------------------------
DROP TABLE IF EXISTS `aut_tag`;
CREATE TABLE `aut_tag`
(
    `id`             bigint(0)                                               NOT NULL COMMENT 'tag id',
    `name`           varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
    `sort`           int(0)                                                  NULL DEFAULT NULL COMMENT '排序',
    `article_num`    int(0)                                                  NULL DEFAULT NULL COMMENT '文章数量',
    `cms_website_id` int(0)                                                  NULL DEFAULT NULL COMMENT '所属网站id',
    `create_time`    datetime(0)                                             NULL DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime(0)                                             NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;