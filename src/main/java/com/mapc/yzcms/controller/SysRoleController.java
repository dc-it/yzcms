package com.mapc.yzcms.controller;

import com.mapc.yzcms.common.api.ListOrPage;
import com.mapc.yzcms.common.api.Result;
import com.mapc.yzcms.dto.SysRoleDto;
import com.mapc.yzcms.entity.SysRole;
import com.mapc.yzcms.service.ISysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SYS-系统角色")
@RestController
@RequestMapping("/sys/roles")
public class SysRoleController {

	private final ISysRoleService sysRoleService;

	@Autowired
	public SysRoleController(ISysRoleService sysRoleService) {
		this.sysRoleService = sysRoleService;
	}

	@ApiOperation("获取角色列表/分页")
	@GetMapping
	public Result<ListOrPage> getSysRoleListOrPage(SysRoleDto sysRoleDto) {
		return Result.success(sysRoleService.getSysRoleListOrPage(sysRoleDto));
	}

	@ApiOperation("更新角色")
	@PutMapping("{id}")
	public Result<Void> updateSysRole(@PathVariable("id") Integer sysRoleId, @RequestBody SysRoleDto sysRoleDto) {
		SysRole sysRole = new SysRole();
		BeanUtils.copyProperties(sysRoleDto, sysRole);
		sysRoleService.update(sysRoleId, sysRole);
		return Result.success();
	}

	@ApiOperation("添加角色")
	@PostMapping
	public Result<Void> addSysRole(@Validated @RequestBody SysRoleDto sysRoleDto) {
		sysRoleService.addSysRole(sysRoleDto);
		return Result.success();
	}

}
