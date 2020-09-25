package com.mapc.yzcms.dao;

import com.mapc.yzcms.entity.AutGroupArticleRelation;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 分组文章关联
 *
 * @author duchao
 */
public interface AutGroupArticleRelationRepository extends JpaRepository<AutGroupArticleRelation, Long> {
}
