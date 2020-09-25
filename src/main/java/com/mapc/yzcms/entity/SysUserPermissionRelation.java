package com.mapc.yzcms.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 用户权限关联实体类
 *
 * @author duchao
 */
@Entity
@Table(name = "sys_user_permission_relation")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@DynamicUpdate
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
public class SysUserPermissionRelation extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	/**
	 * 用户id
	 */
	private Integer sysUserId;

	/**
	 * 权限id
	 */
	private Integer sysPermissionId;

	/**
	 * 是否拥有此权限，补充角色权限用的不足
	 */
	private Boolean own;
}
