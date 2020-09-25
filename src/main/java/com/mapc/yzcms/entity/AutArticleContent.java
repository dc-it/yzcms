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
@Table(name = "aut_article_content")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@DynamicUpdate
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
public class AutArticleContent extends BaseEntity {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	/**
	 * 内容
	 */
	private String content;

	/**
	 * 所属文章id
	 */
	private Long articleId;

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
