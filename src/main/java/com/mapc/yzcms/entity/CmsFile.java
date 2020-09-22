package com.mapc.yzcms.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

/**
 * 文件实体类
 *
 * @author duchao
 */
@Entity
@Table(name = "cms_file")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@DynamicUpdate
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
public class CmsFile extends BaseEntity {

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 地址
	 */
	private String uri;

	/**
	 * 类型：1->图片
	 */
	private String type;

	/**
	 * 所属网站
	 */
	private long websiteId;
}
