package com.mapc.yzcms.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

/**
 * 文章
 *
 * @author duchao
 */
@Entity
@Table(name = "cms_article_content")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@DynamicUpdate
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
public class CmsArticleContent extends BaseEntity {

	/**
	 * 内容
	 */
	private String content;

	/**
	 * 所属文章id
	 */
	private long articleId;

	/**
	 * 所属菜单
	 */
	private long menuId;

	/**
	 * 所属网站
	 */
	private long websiteId;

}
