package com.mapc.yzcms.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@ApiModel("系统角色")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@EqualsAndHashCode(callSuper = false)
public class SysRoleDto extends PageDto{

    @ApiModelProperty(name = "id", value = "角色id")
    private Integer id;

    /**
     * 角色名称
     */
    @ApiModelProperty(name = "name", value = "角色名称")
    private String name;

    /**
     * 描述
     */
    @ApiModelProperty(name = "description", value = "角色描述")
    private String description;

    @ApiModelProperty(name = "sort", value = "排序")
    private Integer sort;

    @ApiModelProperty(name = "status", value = "状态:true->启用，false->禁用", allowableValues = "true,false")
    private Boolean status;
}
