package com.mapc.yzcms.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 菜单
 *
 * @author duchao
 */
@Entity
@Table(name = "cms_menu")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@DynamicUpdate
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
public class CmsMenu extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	/**
	 * 所属网站
	 */
	private long websiteId;

	/**
	 * 所属父id
	 */
	private long pid;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 名称（英文）
	 */
	private String enname;

	/**
	 * 关键字
	 */
	private String keywords;

	/**
	 * 地址
	 */
	private String path;

	/**
	 * 描述
	 */
	private String description;

	/**
	 * 排序
	 */
	private int sort;
}
