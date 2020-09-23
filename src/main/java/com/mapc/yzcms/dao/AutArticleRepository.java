package com.mapc.yzcms.dao;

import com.mapc.yzcms.entity.AutArticle;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 文章
 *
 * @author duchao
 */
public interface AutArticleRepository extends JpaRepository<AutArticle, Long> {
}
