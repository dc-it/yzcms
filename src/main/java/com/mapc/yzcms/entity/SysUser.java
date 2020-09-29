package com.mapc.yzcms.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 用户实体
 *
 * @author duchao
 */
@Entity
@Table(name = "sys_user")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@DynamicUpdate
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
public class SysUser extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	/**
	 * 用户名：字母数字必须有
	 */
	private String username;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 手机号
	 */
	private String phone;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 昵称
	 */
	private String nickName;

	/**
	 * 备注信息
	 */
	private String remark;

	/**
	 * 最后登陆时间
	 */
	private LocalDateTime loginTime;

	/**
	 * 状态：启用、禁用
	 */
	private Boolean status;

	/**
	 * 账户
	 * 可能是username、email、phone
	 */
	@Transient
	private String account;
}
