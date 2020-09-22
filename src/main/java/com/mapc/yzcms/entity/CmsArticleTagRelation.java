package com.mapc.yzcms.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

/**
 * 文章标签关联实体类
 *
 * @author duchao
 */
@Entity
@Table(name = "cms_article_tag_relation")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@DynamicUpdate
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
public class CmsArticleTagRelation extends BaseEntity{

	/**
	 * 文章id
	 */
	private long articleId;

	/**
	 * 标签id
	 */
	private long tagId;

	/**
	 * 所属网站
	 */
	private long websiteId;
}
