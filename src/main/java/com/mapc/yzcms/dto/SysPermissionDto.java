package com.mapc.yzcms.dto;

import com.mapc.yzcms.entity.SysPermission;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "系统权限")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@EqualsAndHashCode(callSuper = false)
public class SysPermissionDto implements Serializable {

    @ApiModelProperty(name = "id", value = "权限id")
    private Integer id;

    @ApiModelProperty(name = "pid", value = "父权限id")
    private Integer pid;

    @ApiModelProperty(name = "name", value = "权限名称")
    private String name;

    @ApiModelProperty(name = "url", value = "api映射路径")
    private String url;

    @ApiModelProperty(name = "method", value = "api请求方法")
    private String method;

    @ApiModelProperty(name = "icon", value = "图标")
    private String icon;

    @ApiModelProperty(name = "type", value = "权限类型：0->目录；1->菜单；2->按钮（接口绑定权限")
    private Integer type;

    @ApiModelProperty(name = "path", value = "前端资源路径")
    private String path;

    @ApiModelProperty(name = "status", value = "启用状态；false->禁用；true->启用")
    private Boolean status;

    @ApiModelProperty(name = "sort", value = "排序")
    private Integer sort;

    @ApiModelProperty(name = "children", value = "子权限列表")
    private List<SysPermission> children;


}
