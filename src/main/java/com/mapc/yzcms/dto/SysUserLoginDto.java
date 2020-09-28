package com.mapc.yzcms.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 系统用户登录dto
 *
 * @author duchao
 */
@ApiModel(value = "用户登录")
@Data
public class SysUserLoginDto implements Serializable {

	@ApiModelProperty(name = "account",value = "账户")
	@NotBlank(message = "账户不能为空")
	private String account;

	@ApiModelProperty(name = "password",value = "密码")
	@NotBlank(message = "密码不能为空")
	private String password;
}
