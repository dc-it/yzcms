package com.mapc.yzcms.entity;

import lombok.*;
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
@Table(name = "cms_article")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@DynamicUpdate
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
public class CmsArticle extends BaseEntity {

	/**
	 * 标题
	 */
	private String title;

	/**
	 * 关键字
	 */
	private String keywords;

	/**
	 * 描述
	 */
	private String description;

	/**
	 * 内容
	 */
	private String content;

	/**
	 * 缩略图
	 */
	private long imageId;

	/**
	 * 作者
	 */
	private String author;

	/**
	 * 类型：1->推荐，2->置顶
	 */
	private int type;

	/**
	 * 是否审核
	 */
	private boolean check;

	/**
	 * 阅读数
	 */
	private int pageview;

	/**
	 * 所属菜单
	 */
	private long menuId;

	/**
	 * 所属网站
	 */
	private long websiteId;

}
