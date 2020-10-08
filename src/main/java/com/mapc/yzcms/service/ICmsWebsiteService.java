package com.mapc.yzcms.service;

import com.mapc.yzcms.common.api.ListOrPage;
import com.mapc.yzcms.dto.CmsWebsiteDto;
import com.mapc.yzcms.entity.CmsWebsite;

/**
 * 站点服务
 *
 * @author duchao
 */
public interface ICmsWebsiteService extends IBaseService<CmsWebsite, Integer> {

	/**
	 * 添加新站点
	 *
	 * @param cmsWebsiteDto 站点
	 */
	void addWebsite(CmsWebsiteDto cmsWebsiteDto);

	/**
	 * 更新站点
	 *
	 * @param cmsWebsiteDto 站点
	 */
	void updateWebsite(CmsWebsiteDto cmsWebsiteDto);

	/**
	 * 删除新站点
	 *
	 * @param cmsWebsiteId 站点id
	 */
	void deleteWebsite(Integer cmsWebsiteId);

	/**
	 * 获取新站点
	 *
	 * @param cmsWebsiteId 站点id
	 */
	CmsWebsite getWebsite(Integer cmsWebsiteId);

	/**
	 * 获取站点列表/分页
	 * @param cmsWebsiteDto 查询参数
	 * @return
	 */
	ListOrPage getCmsWebsiteListOrPage(CmsWebsiteDto cmsWebsiteDto);
}
