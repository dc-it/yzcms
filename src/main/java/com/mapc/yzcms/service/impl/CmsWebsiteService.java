package com.mapc.yzcms.service.impl;

import com.mapc.yzcms.common.util.NewWebsiteDbUtil;
import com.mapc.yzcms.dao.CmsWebsiteRepository;
import com.mapc.yzcms.entity.CmsWebsite;
import com.mapc.yzcms.service.ICmsWebsiteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 站点服务
 *
 * @author duchao
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class CmsWebsiteService extends BaseService<CmsWebsite, Integer> implements ICmsWebsiteService {

	private final CmsWebsiteRepository cmsWebsiteRepository;

	@Autowired
	public CmsWebsiteService(CmsWebsiteRepository cmsWebsiteRepository) {
		this.cmsWebsiteRepository = cmsWebsiteRepository;
	}

	/**
	 * 添加新站点
	 *
	 * @param cmsWebsite 站点
	 */
	@Override
	public void addWebsite(CmsWebsite cmsWebsite) {

		//保存站点元素据
		this.add(cmsWebsite);

		//初始化站点库
		NewWebsiteDbUtil.createSchema(cmsWebsite.getDatabaseName(), cmsWebsite.getUrl(), cmsWebsite.getDatabaseUsername(), cmsWebsite.getDatabasePassword());
	}

	/**
	 * 删除新站点
	 *
	 * @param cmsWebsiteId 站点id
	 */
	@Override
	public void deleteWebsite(Integer cmsWebsiteId) {

		CmsWebsite cmsWebsite = this.get(cmsWebsiteId);

		//删除站点库
		NewWebsiteDbUtil.dropSchema(cmsWebsite.getDatabaseName(), cmsWebsite.getUrl(), cmsWebsite.getDatabaseUsername(), cmsWebsite.getDatabasePassword());

		//删除站点元数据
		this.delete(cmsWebsiteId);
	}
}
