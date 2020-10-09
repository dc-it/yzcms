package com.mapc.yzcms.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@ApiModel("系统角色")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@EqualsAndHashCode(callSuper = false)
public class SysRoleDto extends PageDto {

	@ApiModelProperty(name = "id", value = "角色id")
	private Integer id;

	@ApiModelProperty(name = "name", value = "角色名称")
	@NotBlank(message = "角色名称不能为空")
	private String name;

	@ApiModelProperty(name = "description", value = "角色描述")
	private String description;

	@ApiModelProperty(name = "sort", value = "排序")
	private Integer sort;

	@ApiModelProperty(name = "status", value = "状态:true->启用，false->禁用", allowableValues = "true,false")
	@NotNull(message = "角色状态不能为空")
	private Boolean status;

	@ApiModelProperty(name = "sysPermissionList", value = "关联权限")
	@NotNull(message = "关联权限不能为空")
	private List<SysPermissionDto> sysPermissionList;
}
