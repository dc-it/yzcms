package com.mapc.yzcms.service.impl;

import com.mapc.yzcms.dao.CmsArticleRepository;
import com.mapc.yzcms.entity.CmsArticle;
import com.mapc.yzcms.service.ICmsArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 文章服务
 *
 * @author duchao
 */
@Slf4j
@Transactional(rollbackFor = Exception.class)
@Service
public class CmsArticleService extends BaseService<CmsArticle, Long> implements ICmsArticleService {

    private final CmsArticleRepository cmsArticleRepository;

    @Autowired
    public CmsArticleService(CmsArticleRepository cmsArticleRepository) {
        this.cmsArticleRepository = cmsArticleRepository;
    }

    @Override
    public void addArticle(CmsArticle cmsArticle){
        this.add(cmsArticle);
    }
}
