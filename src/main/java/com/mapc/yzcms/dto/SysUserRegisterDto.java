package com.mapc.yzcms.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 系统用户注册dto
 *
 * @author duchao
 */
@ApiModel(value = "用户注册")
@Data
public class SysUserRegisterDto implements Serializable {

	@ApiModelProperty(name = "account", value = "账户")
	@NotBlank(message = "账户不能为空")
	private String account;

	@ApiModelProperty(name = "password", value = "密码")
	@NotBlank(message = "密码不能为空")
	private String password;

	@ApiModelProperty(name = "captcha", value = "验证码")
	@NotBlank(message = "验证码不能为空")
	private String captcha;
}
