package com.mapc.yzcms.entity;

import com.mapc.yzcms.common.util.SnowflakeIdUtil;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 文章
 *
 * @author duchao
 */
@Entity
@Table(name = "aut_article")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@DynamicUpdate
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
public class AutArticle extends BaseEntity {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

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
	 * 缩略图（关联cms_file）
	 */
	private Long autImageId;

	/**
	 * 作者id
	 */
	private Long autAuthorId;

	/**
	 * 类型：1->推荐，2->置顶
	 */
	private Integer type;

	/**
	 * 访问路径
	 */
	private String path;

	/**
	 * 是否审核
	 */
	private Boolean check;

	/**
	 * 阅读数
	 */
	private Integer pageview;

	/**
	 * 所属菜单
	 */
	private Integer cmsMenuId;

	/**
	 * 所属网站
	 */
	private Integer cmsWebsiteId;

	@PrePersist
	private void init() {
		this.id = SnowflakeIdUtil.generateId();
	}

}
