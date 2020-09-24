package com.mapc.yzcms.service;

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
	 * @param cmsWebsite 站点
	 */
	void addWebsite(CmsWebsite cmsWebsite);

	/**
	 * 删除新站点
	 *
	 * @param cmsWebsiteId 站点id
	 */
	void deleteWebsite(Integer cmsWebsiteId);
}
