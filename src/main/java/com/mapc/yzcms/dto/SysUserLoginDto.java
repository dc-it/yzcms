package com.mapc.yzcms.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 系统用户登陆dto
 *
 * @author duchao
 */
@Data
public class SysUserLoginDto implements Serializable {

	/**
	 * 账户
	 */
	@NotBlank(message = "账户不能为空")
	private String account;

	/**
	 * 密码
	 */
	@NotBlank(message = "密码不能为空")
	private String password;
}
