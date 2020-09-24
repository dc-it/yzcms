/*
 Navicat Premium Data Transfer

 Source Server         : 182.92.202.68-me
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : 182.92.202.68:8003
 Source Schema         : yzcms

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 23/09/2020 16:35:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for aut_article
-- ----------------------------
DROP TABLE IF EXISTS `aut_article`;
CREATE TABLE `aut_article`
(
    `id`          bigint(0)                                               NOT NULL,
    `titile`      varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
    `keywords`    varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关键字',
    `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
    `image_id`    bigint(0)                                               NULL DEFAULT NULL COMMENT '缩略图id',
    `author_id`   int(0)                                                  NULL DEFAULT NULL COMMENT '作者',
    `type`        int(0)                                                  NULL DEFAULT NULL COMMENT '1->推荐，2->置顶',
    `path`        varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访问路径',
    `menu_id`     int(0)                                                  NULL DEFAULT NULL COMMENT '菜单id',
    `website_id`  int(0)                                                  NULL DEFAULT NULL COMMENT '网站id',
    `pageview`    int(0)                                                  NULL DEFAULT 0 COMMENT '阅读数',
    `check`       bit(1)                                                  NULL DEFAULT NULL COMMENT '是否审核',
    `create_time` datetime(0)                                             NULL DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime(0)                                             NULL DEFAULT NULL COMMENT '更新时间',
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
    `id`          bigint(0)                                       NOT NULL COMMENT '主键',
    `article_id`  bigint(0)                                       NOT NULL COMMENT '文章id',
    `menu_id`     int(0)                                          NOT NULL COMMENT '菜单id',
    `website_id`  int(0)                                          NOT NULL COMMENT '网站id',
    `content`     text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
    `create_time` datetime(0)                                     NULL DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime(0)                                     NULL DEFAULT NULL COMMENT '更新时间',
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
    `id`          bigint(0)   NOT NULL,
    `article_id`  bigint(0)   NOT NULL COMMENT '文章id',
    `tag_id`      bigint(0)   NOT NULL COMMENT '标签id',
    `website_id`  int(0)      NOT NULL COMMENT '网站id',
    `create_time` datetime(0) NOT NULL COMMENT '创建时间',
    `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
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
    `id`          int(0)                                                  NOT NULL AUTO_INCREMENT,
    `username`    varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账户名',
    `password`    varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
    `nick_name`   varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '昵称',
    `image_id`    bigint(0)                                               NULL DEFAULT NULL COMMENT '头像（关联cms_file）',
    `phone`       varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '手机号',
    `email`       varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '邮箱',
    `remark`      varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
    `login_time`  datetime(0)                                             NULL DEFAULT NULL COMMENT '最后登陆时间',
    `create_time` datetime(0)                                             NULL DEFAULT NULL COMMENT '创建时间/入驻时间',
    `update_time` datetime(0)                                             NULL DEFAULT NULL COMMENT '更新时间',
    `status`      bit(1)                                                  NULL DEFAULT NULL COMMENT '状态：启用、禁用',
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
    `id`          bigint(0)                                               NOT NULL,
    `name`        varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件名',
    `path`        varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件地址',
    `type`        int(0)                                                  NULL DEFAULT NULL COMMENT '类型：1->图片',
    `website_id`  int(0)                                                  NULL DEFAULT NULL COMMENT '所属网站',
    `create_time` datetime(0)                                             NULL DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime(0)                                             NULL DEFAULT NULL COMMENT '更新时间',
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
    `id`          int(0)                                                 NOT NULL AUTO_INCREMENT,
    `author_id`   int(0)                                                 NULL DEFAULT NULL COMMENT '所属作者',
    `name`        varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分组名',
    `enname`      varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分组英文名',
    `path`        varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访问路径',
    `pid`         int(0)                                                 NULL DEFAULT NULL COMMENT '父id',
    `create_time` datetime(0)                                            NULL DEFAULT NULL COMMENT '创建时间/入驻时间',
    `update_time` datetime(0)                                            NULL DEFAULT NULL COMMENT '更新时间',
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
    `id`          int(0)      NOT NULL AUTO_INCREMENT,
    `group_id`    int(0)      NULL DEFAULT NULL COMMENT '文章分组id',
    `article_id`  bigint(0)   NULL DEFAULT NULL COMMENT '文章id',
    `author_id`   int(0)      NULL DEFAULT NULL COMMENT '作者id',
    `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间/入驻时间',
    `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
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
    `id`          bigint(0)                                               NOT NULL COMMENT 'tag id',
    `name`        varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
    `sort`        int(0)                                                  NULL DEFAULT NULL COMMENT '排序',
    `article_num` int(0)                                                  NULL DEFAULT NULL COMMENT '文章数量',
    `website_id`  int(0)                                                  NULL DEFAULT NULL COMMENT '所属网站id',
    `create_time` datetime(0)                                             NULL DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime(0)                                             NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cms_link
-- ----------------------------
DROP TABLE IF EXISTS `cms_link`;
CREATE TABLE `cms_link`
(
    `id`          int(0)                                                  NOT NULL AUTO_INCREMENT,
    `name`        varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '友链名称',
    `image_id`    bigint(0)                                               NULL DEFAULT NULL COMMENT '缩略图',
    `url`         varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '网址',
    `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
    `sort`        int(0)                                                  NULL DEFAULT NULL COMMENT '排序',
    `website_id`  int(0)                                                  NULL DEFAULT NULL COMMENT '所属网站',
    `create_time` datetime(0)                                             NULL DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime(0)                                             NULL DEFAULT NULL COMMENT '更新时间',
    `create_by`   int(0)                                                  NULL DEFAULT NULL COMMENT '创建人',
    `update_by`   int(0)                                                  NULL DEFAULT NULL COMMENT '更信任',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cms_menu
-- ----------------------------
DROP TABLE IF EXISTS `cms_menu`;
CREATE TABLE `cms_menu`
(
    `id`          int(0)                                                  NOT NULL AUTO_INCREMENT,
    `name`        varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '名称',
    `enname`      varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '名称（英文）',
    `keywords`    varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关键字',
    `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
    `path`        varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '访问地址',
    `sort`        int(0)                                                  NULL DEFAULT NULL COMMENT '排序',
    `pid`         int(0)                                                  NULL DEFAULT NULL COMMENT '父id',
    `website_id`  int(0)                                                  NULL DEFAULT NULL COMMENT '所属网站',
    `create_time` datetime(0)                                             NULL DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime(0)                                             NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cms_page
-- ----------------------------
DROP TABLE IF EXISTS `cms_page`;
CREATE TABLE `cms_page`
(
    `id`          int(0)                                                  NOT NULL AUTO_INCREMENT,
    `title`       varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '标题',
    `keywords`    varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '关键字',
    `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
    `content`     text CHARACTER SET utf8 COLLATE utf8_general_ci         NULL COMMENT '内容',
    `website_id`  int(0)                                                  NULL DEFAULT NULL COMMENT '所属网站',
    `path`        varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访问地址',
    `create_time` datetime(0)                                             NULL DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime(0)                                             NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cms_template
-- ----------------------------
DROP TABLE IF EXISTS `cms_template`;
CREATE TABLE `cms_template`
(
    `id`                int(0)                                                  NOT NULL AUTO_INCREMENT,
    `name`              varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '模板名',
    `type`              int(0)                                                  NULL DEFAULT NULL COMMENT '类型：1->首页，2->频道页，3->列表页，4->详情页',
    `path`              varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '访问路径（templateGroupPath+templatePath）',
    `description`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
    `template_group_id` int(0)                                                  NULL DEFAULT NULL COMMENT '模板组id',
    `create_time`       datetime(0)                                             NULL DEFAULT NULL COMMENT '创建时间',
    `update_time`       datetime(0)                                             NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cms_template_group
-- ----------------------------
DROP TABLE IF EXISTS `cms_template_group`;
CREATE TABLE `cms_template_group`
(
    `id`          int(0)                                                  NOT NULL AUTO_INCREMENT,
    `name`        varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '模板组名称',
    `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
    `path`        varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '一套模板的访问地址',
    `create_time` datetime(0)                                             NULL DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime(0)                                             NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cms_website
-- ----------------------------
DROP TABLE IF EXISTS `cms_website`;
CREATE TABLE `cms_website`
(
    `id`                int(0)                                                  NOT NULL AUTO_INCREMENT,
    `name`              varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '网站名称',
    `keywords`          varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关键字',
    `description`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
    `url`               varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网址',
    `template_group_id` int(0)                                                  NULL DEFAULT NULL COMMENT '模板组id',
    `path`              varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '静态网站服务器保存地址',
    `icp`               varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'icp备案',
    `ower`              varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '站长/拥有者',
    `ower_wechat`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '拥有者微信',
    `ower_qq`           varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '拥有者qq',
    `ower_email`        varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '拥有者邮箱',
    `ower_homepage`     varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '拥有者个人主页',
    `sort`              int(0)                                                  NULL DEFAULT NULL COMMENT '排序',
    `database_name`     varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据库名',
    `create_time`       datetime(0)                                             NULL DEFAULT NULL COMMENT '创建时间',
    `update_time`       datetime(0)                                             NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cms_website_generate
-- ----------------------------
DROP TABLE IF EXISTS `cms_website_generate`;
CREATE TABLE `cms_website_generate`
(
    `id`          int(0)                                                 NOT NULL AUTO_INCREMENT,
    `type`        int(0)                                                 NULL DEFAULT NULL COMMENT '生成网站类型：1->完全静态，2->伪静态',
    `url`         varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访问地址',
    `path`        varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '服务器保存路径',
    `website_id`  int(0)                                                 NULL DEFAULT NULL COMMENT '所属网站id',
    `use`         bit(1)                                                 NULL DEFAULT NULL COMMENT '使用状态：0未使用，1使用',
    `create_time` datetime(0)                                            NULL DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime(0)                                            NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict`
(
    `id`          int(0)                                                 NOT NULL AUTO_INCREMENT,
    `label`       varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文本',
    `value`       varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '值',
    `pid`         int(0)                                                 NULL DEFAULT NULL COMMENT '父id，跟字典默认为0',
    `create_time` datetime(0)                                            NULL DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime(0)                                            NULL DEFAULT NULL COMMENT '更新时间',
    `create_by`   int(0)                                                 NULL DEFAULT NULL COMMENT '创建人',
    `update_by`   int(0)                                                 NULL DEFAULT NULL COMMENT '更信任',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`
(
    `id`          int(0)                                                  NOT NULL AUTO_INCREMENT,
    `pid`         int(0)                                                  NULL DEFAULT NULL COMMENT '父级权限id',
    `name`        varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
    `value`       varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限值',
    `icon`        varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
    `type`        int(0)                                                  NULL DEFAULT NULL COMMENT '权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）',
    `uri`         varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '前端资源路径',
    `status`      int(0)                                                  NULL DEFAULT NULL COMMENT '启用状态；0->禁用；1->启用',
    `sort`        int(0)                                                  NULL DEFAULT NULL COMMENT '排序',
    `create_time` datetime(0)                                             NULL DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime(0)                                             NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`
(
    `id`          int(0)                                                  NOT NULL AUTO_INCREMENT,
    `name`        varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
    `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
    `admin_count` int(0)                                                  NULL DEFAULT NULL COMMENT '后台用户数量',
    `sort`        int(0)                                                  NULL DEFAULT 0,
    `status`      int(0)                                                  NULL DEFAULT 1 COMMENT '启用状态：0->禁用；1->启用',
    `create_time` datetime(0)                                             NULL DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime(0)                                             NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role_permission_relation
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission_relation`;
CREATE TABLE `sys_role_permission_relation`
(
    `id`            int(0)      NOT NULL AUTO_INCREMENT,
    `role_id`       int(0)      NULL DEFAULT NULL,
    `permission_id` int(0)      NULL DEFAULT NULL,
    `create_time`   datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 18
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '后台用户角色和权限关系表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_settings
-- ----------------------------
DROP TABLE IF EXISTS `sys_settings`;
CREATE TABLE `sys_settings`
(
    `id`           int(0)                                                  NOT NULL AUTO_INCREMENT,
    `file_url`     varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '系统文件存放地址',
    `template_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '系统模板存放地址',
    `create_time`  datetime(0)                                             NULL DEFAULT NULL COMMENT '创建时间',
    `update_time`  datetime(0)                                             NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`
(
    `id`          int(0)                                                  NOT NULL AUTO_INCREMENT,
    `username`    varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL,
    `password`    varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL,
    `imageId`     bigint(0)                                               NULL DEFAULT NULL COMMENT '头像（关联cms_file）',
    `phone`       varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '手机号',
    `email`       varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
    `nick_name`   varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
    `remark`      varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
    `login_time`  datetime(0)                                             NULL DEFAULT NULL COMMENT '最后登录时间',
    `status`      bit(1)                                                  NULL DEFAULT b'1' COMMENT '帐号启用状态：0->禁用；1->启用',
    `create_time` datetime(0)                                             NULL DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime(0)                                             NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user_permission_relation
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_permission_relation`;
CREATE TABLE `sys_user_permission_relation`
(
    `id`            int(0)      NOT NULL AUTO_INCREMENT,
    `user_id`       int(0)      NULL DEFAULT NULL,
    `permission_id` int(0)      NULL DEFAULT NULL,
    `own`           bit(1)      NULL DEFAULT NULL COMMENT '是否有此权限，补充角色权限',
    `create_time`   datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '后台用户和权限关系表(除角色中定义的权限以外的加减权限)'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role_relation`;
CREATE TABLE `sys_user_role_relation`
(
    `id`          int(0)      NOT NULL AUTO_INCREMENT,
    `user_id`     int(0)      NULL DEFAULT NULL,
    `role_id`     int(0)      NULL DEFAULT NULL,
    `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 17
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '后台用户和角色关系表'
  ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
