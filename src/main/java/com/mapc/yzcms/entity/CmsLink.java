package com.mapc.yzcms.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 友情链接实体类
 *
 * @author duchao
 */
@Entity
@Table(name = "cms_link")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@DynamicUpdate
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
public class CmsLink extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 缩略图（关联cms_file）
	 */
	private Long cmsImageId;

	/**
	 * 网址
	 */
	private String url;

	/**
	 * 描述
	 */
	private String description;

	/**
	 * 顺序
	 */
	private Integer sort;

	/**
	 * 所属网站
	 */
	private Integer cmsWebsiteId;

	/**
	 * 审核状态
	 */
	private Boolean check;
}
