package com.mapc.yzcms.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 模板
 *
 * @author duchao
 */
@Entity
@Table(name = "cms_template")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@DynamicUpdate
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
public class CmsTemplate extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	/**
	 * 模板组id
	 */
	private long templateGroupId;

	/**
	 * 模板文件名
	 */
	private String name;

	/**
	 * 类型：1->首页，2->频道页，3->列表页，4->详情页
	 */
	private int type;

	/**
	 * 访问路径（templateGroupPath+templatePath）
	 */
	private String path;

	/**
	 * 描述
	 */
	private String description;
}
