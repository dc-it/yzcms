package com.mapc.yzcms.service;

import com.mapc.yzcms.entity.CmsArticle;

/**
 * 文章服务
 *
 * @author duchao
 */
public interface ICmsArticleService extends IBaseService<CmsArticle, Long> {

    /**
     * 添加文章
     *
     * @param cmsArticle 文章
     */
    void addArticle(CmsArticle cmsArticle);
}
