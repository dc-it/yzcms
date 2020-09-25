package com.mapc.yzcms.service.impl;

import com.mapc.yzcms.common.config.datasource.DataSourceProperties;
import com.mapc.yzcms.common.util.AssertUtil;
import com.mapc.yzcms.common.util.NewWebsiteDbUtil;
import com.mapc.yzcms.dao.CmsWebsiteRepository;
import com.mapc.yzcms.dto.CmsWebsiteEditDto;
import com.mapc.yzcms.entity.CmsWebsite;
import com.mapc.yzcms.service.ICmsWebsiteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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
	private final DataSourceProperties dataSourceProperties;

	@Autowired
	public CmsWebsiteService(CmsWebsiteRepository cmsWebsiteRepository, DataSourceProperties dataSourceProperties) {
		this.cmsWebsiteRepository = cmsWebsiteRepository;
		this.dataSourceProperties = dataSourceProperties;
	}

	/**
	 * 添加新站点
	 *
	 * @param cmsWebsiteEditDto 站点
	 */
	@Override
	public void addWebsite(CmsWebsiteEditDto cmsWebsiteEditDto) {

		AssertUtil.isFalse(dataSourceProperties.getPrimaryDatabaseName().equals(cmsWebsiteEditDto.getDatabaseName()),"数据库名不能是{}",dataSourceProperties.getPrimaryDatabaseName());

		CmsWebsite cmsWebsite = new CmsWebsite();
		BeanUtils.copyProperties(cmsWebsiteEditDto,cmsWebsite);

		if (cmsWebsite.isDatabaseLocal()) {
			cmsWebsite.setDatabaseUrl(dataSourceProperties.getPrimaryDatabaseIpPort());
			cmsWebsite.setDatabaseUsername(dataSourceProperties.getUsername());
			cmsWebsite.setDatabasePassword(dataSourceProperties.getPassword());
		}

		//保存站点元素据
		this.add(cmsWebsite);

		//初始化站点库
		NewWebsiteDbUtil.createSchema(cmsWebsite.getDatabaseName(), cmsWebsite.getDatabaseUrl(), cmsWebsite.getDatabaseUsername(), cmsWebsite.getDatabasePassword());
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
		if (cmsWebsite.isDatabaseLocal()) {
			cmsWebsite.setDatabaseUrl(dataSourceProperties.getPrimaryDatabaseIpPort());
			cmsWebsite.setDatabaseUsername(dataSourceProperties.getUsername());
			cmsWebsite.setDatabasePassword(dataSourceProperties.getPassword());
		}
		NewWebsiteDbUtil.dropSchema(cmsWebsite.getDatabaseName(), cmsWebsite.getDatabaseUrl(), cmsWebsite.getDatabaseUsername(), cmsWebsite.getDatabasePassword());

		//删除站点元数据
		this.delete(cmsWebsiteId);
	}

	/**
	 * 更新站点
	 *
	 * @param cmsWebsiteEditDto 站点
	 */
	@Override
	public void updateWebsite(CmsWebsiteEditDto cmsWebsiteEditDto) {
		CmsWebsite cmsWebsite = new CmsWebsite();
		BeanUtils.copyProperties(cmsWebsiteEditDto,cmsWebsite);

		this.update(cmsWebsite);
	}
}
