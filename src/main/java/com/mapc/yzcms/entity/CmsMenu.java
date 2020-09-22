package com.mapc.yzcms.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

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
@EqualsAndHashCode(callSuper = false)
@DynamicUpdate
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
public class CmsMenu extends BaseEntity {

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
	 * 地址
	 */
	private String url;

	/**
	 * 描述
	 */
	private String description;

	/**
	 * 排序
	 */
	private int sort;
}
