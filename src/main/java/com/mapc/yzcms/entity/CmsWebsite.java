package com.mapc.yzcms.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

/**
 * 网站实体类
 *
 * @author duchao
 */
@Entity
@Table(name = "cms_website")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@DynamicUpdate
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
public class CmsWebsite extends BaseEntity{

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 关键字
	 */
	private String keywords;

	/**
	 * 描述
	 */
	private String description;

	/**
	 * 网址
	 */
	private String url;

	/**
	 * 顺序
	 */
	private int sort;

	/**
	 * 使用的模板
	 */
	private long templateGroupId;

	/**
	 * icp备案
	 */
	private String icp;

	/**
	 * 拥有者（站长）
	 */
	private String ower;

	/**
	 * 联系邮箱
	 */
	private String email;
}
