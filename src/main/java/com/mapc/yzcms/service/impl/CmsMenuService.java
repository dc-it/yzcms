package com.mapc.yzcms.service.impl;

import com.mapc.yzcms.dao.CmsMenuRepository;
import com.mapc.yzcms.entity.AutArticle;
import com.mapc.yzcms.entity.CmsMenu;
import com.mapc.yzcms.service.ICmsMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 菜单
 *
 * @author duchao
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class CmsMenuService extends BaseService<CmsMenu,Integer> implements ICmsMenuService {

    private final CmsMenuRepository cmsMenuRepository;
    private final AutArticleService cmsArticleService;

    @Autowired
    public CmsMenuService(CmsMenuRepository cmsMenuRepository, AutArticleService cmsArticleService) {
        this.cmsMenuRepository = cmsMenuRepository;
        this.cmsArticleService = cmsArticleService;
    }

    @Override
    public void addMenu(CmsMenu cmsMenu){
        this.add(cmsMenu);
        cmsArticleService.addArticle(new AutArticle());
    }
}
