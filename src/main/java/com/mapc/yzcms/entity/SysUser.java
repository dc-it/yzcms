package com.mapc.yzcms.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "系统用户")
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
	@ApiModelProperty(name = "username",value = "用户名")
	private String username;

	@ApiModelProperty(name = "password",value = "密码")
	private String password;

	@ApiModelProperty(name = "phone",value = "手机号")
	private String phone;

	@ApiModelProperty(name = "email",value = "邮箱")
	private String email;

	@ApiModelProperty(name = "nickName",value = "昵称")
	private String nickName;

	@ApiModelProperty(name = "remark",value = "备注")
	private String remark;

	@ApiModelProperty(name = "loginTime",value = "最后登陆时间")
	private LocalDateTime loginTime;

	@ApiModelProperty(name = "status",value = "状态:true->启用，false->禁用",allowableValues = "true,false")
	private Boolean status;

	/**
	 * 账户
	 * 可能是username、email、phone
	 */
	@Transient
	private String account;
}
