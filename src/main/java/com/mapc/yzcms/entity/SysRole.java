package com.mapc.yzcms.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 用户实体
 *
 * @author duchao
 */
@Entity
@Table(name = "sys_role")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@DynamicUpdate
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
public class SysRole extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	/**
	 * 角色名称
	 */
	private String name;

	/**
	 * 描述
	 */
	private String description;

	/**
	 * 后台用户数量
	 */
	private Integer adminCount;

	/**
	 * 排序
	 */
	private Integer sort;

	/**
	 * 状态
	 */
	private Boolean status;
}
