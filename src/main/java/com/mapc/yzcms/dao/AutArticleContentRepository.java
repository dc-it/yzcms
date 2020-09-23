package com.mapc.yzcms.dao;

import com.mapc.yzcms.entity.AutArticleContent;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 文章内容
 *
 * @author duchao
 */
public interface AutArticleContentRepository extends JpaRepository<AutArticleContent, Long> {
}
