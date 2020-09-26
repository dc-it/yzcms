package com.mapc.yzcms.controller;

import com.mapc.yzcms.common.api.Result;
import com.mapc.yzcms.common.api.ListOrPage;
import com.mapc.yzcms.dto.CmsWebsiteDto;
import com.mapc.yzcms.service.ICmsWebsiteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 站点元素据控制器
 *
 * @author duchao
 */
@Api(tags = "CMS-网站元数据")
@RestController
@RequestMapping("/cms/websites")
public class CmsWebsiteController {

	private final ICmsWebsiteService cmsWebsiteService;

	@Autowired
	public CmsWebsiteController(ICmsWebsiteService cmsWebsiteService) {
		this.cmsWebsiteService = cmsWebsiteService;
	}

	@ApiOperation("获取站点列表/分页")
	@GetMapping
	public Result<ListOrPage> getCmsWebsiteList(CmsWebsiteDto cmsWebsiteDto) {
		return Result.success(cmsWebsiteService.getWebsiteListOrPage(cmsWebsiteDto));
	}

	@ApiOperation("获取某个站点")
	@ApiImplicitParam(name = "id", value = "站点id", required = true)
	@GetMapping("/{id}")
	public Result<Object> addCmsWebsite(@PathVariable("id") Integer cmsWebsiteId) {
		return Result.success(cmsWebsiteService.getWebsite(cmsWebsiteId));
	}

	@ApiOperation("创建站点")
	@PostMapping
	public Result<Object> addCmsWebsite(@Validated @RequestBody CmsWebsiteDto cmsWebsiteDto) {
		cmsWebsiteService.addWebsite(cmsWebsiteDto);
		return Result.success();
	}

	@ApiOperation("删除站点")
	@ApiImplicitParam(name = "id", value = "站点id", required = true)
	@DeleteMapping("/{id}")
	public Result<Object> deleteCmsWebsite(@PathVariable("id") Integer cmsWebsiteId) {
		cmsWebsiteService.deleteWebsite(cmsWebsiteId);
		return Result.success();
	}

	@ApiOperation("更新站点")
	@ApiImplicitParam(name = "id", value = "站点id", required = true)
	@PutMapping("/{id}")
	public Result<Object> updateCmsWebsite(@PathVariable("id") Integer cmsWebsiteId, @RequestBody CmsWebsiteDto cmsWebsiteDto) {
		cmsWebsiteDto.setId(cmsWebsiteId);
		cmsWebsiteService.updateWebsite(cmsWebsiteDto);
		return Result.success();
	}

}
