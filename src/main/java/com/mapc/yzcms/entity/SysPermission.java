package com.mapc.yzcms.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 权限
 *
 * @author duchao
 */
@Entity
@Table(name = "sys_permission")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@DynamicUpdate
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
public class SysPermission extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	/**
	 * 父id
	 */
	private Integer pid;

	/**
	 * 权限名称
	 */
	private String name;

	/**
	 * 权限值
	 */
	private String value;

	/**
	 * 图标
	 */
	private String icon;

	/**
	 * 权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）
	 */
	private Integer type;

	/**
	 * 前端资源路径
	 */
	private String uri;

	/**
	 * 启用状态；0->禁用；1->启用
	 */
	private Boolean status;

	/**
	 * 排序
	 */
	private Integer sort;

}
