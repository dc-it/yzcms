package com.mapc.yzcms.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 文章模板实体类（一套模板，一个实例）
 * 存于 classpath:templates目录下，一个文件夹一套模板
 *
 * @author duchao
 */
@Entity
@Table(name = "cms_template_group")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@DynamicUpdate
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
public class CmsTemplateGroup extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	/**
	 * 模板名称
	 */
	private String name;

	/**
	 * 描述
	 */
	private String description;

	/**
	 * 模板组的访问地址
	 */
	private String path;


}
