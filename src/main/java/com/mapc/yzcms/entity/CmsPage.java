package com.mapc.yzcms.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 单页实体类
 *
 * @author duchao
 */
@Entity
@Table(name = "cms_page")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@DynamicUpdate
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
public class CmsPage extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

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
	 * 访问路径
	 */
	private String path;

	/**
	 * 所属网站
	 */
	private Integer cmsWebsiteId;
}
