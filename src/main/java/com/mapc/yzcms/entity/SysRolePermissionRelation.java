package com.mapc.yzcms.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

/**
 * 角色权限关联实体类
 *
 * @author duchao
 */
@Entity
@Table(name = "sys_role_permission_relation")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@DynamicUpdate
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
public class SysRolePermissionRelation extends BaseEntity{

	/**
	 * 角色id
	 */
	private long roleId;

	/**
	 * 权限id
	 */
	private long permissionId;
}
