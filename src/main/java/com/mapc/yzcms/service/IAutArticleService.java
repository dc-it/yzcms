package com.mapc.yzcms.service;

import com.mapc.yzcms.entity.AutArticle;

/**
 * 文章服务
 *
 * @author duchao
 */
public interface IAutArticleService extends IBaseService<AutArticle, Long> {

    /**
     * 添加文章
     *
     * @param autArticle 文章
     */
    void addArticle(AutArticle autArticle);
}
