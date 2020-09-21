package com.mapc.yzcms.dao;

import com.mapc.yzcms.entity.CmsArticle;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 文章
 *
 * @author duchao
 */
public interface CmsArticleRepository extends JpaRepository<CmsArticle, Long> {
}
