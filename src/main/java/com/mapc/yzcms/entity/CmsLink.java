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
	private int id;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 缩略图（关联cms_file）
	 */
	private long imageId;

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
	private int sort;

	/**
	 * 所属网站
	 */
	private long websiteId;

	/**
	 * 审核状态
	 */
	private boolean check;
}
