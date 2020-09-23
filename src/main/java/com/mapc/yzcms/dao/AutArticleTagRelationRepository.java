package com.mapc.yzcms.dao;

import com.mapc.yzcms.entity.AutArticleTagRelation;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 文章标签
 *
 * @author duchao
 */
public interface AutArticleTagRelationRepository extends JpaRepository<AutArticleTagRelation, Long> {
}
