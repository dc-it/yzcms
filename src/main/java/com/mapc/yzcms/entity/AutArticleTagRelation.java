package com.mapc.yzcms.entity;

import com.mapc.yzcms.common.util.SnowflakeIdUtil;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 文章标签关联实体类
 *
 * @author duchao
 */
@Entity
@Table(name = "aut_article_tag_relation")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@DynamicUpdate
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
public class AutArticleTagRelation extends BaseEntity{

	@Id
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	/**
	 * 文章id
	 */
	private Long autArticleId;

	/**
	 * 标签id
	 */
	private Long autTagId;

	/**
	 * 所属网站
	 */
	private Integer cmsWebsiteId;

	@PrePersist
	private void init() {
		this.id = SnowflakeIdUtil.generateId();
	}
}
