package com.mapc.yzcms.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 站点编辑dto
 * 用于add、update接口入参
 * add操作接口需使用@Validated开启验证
 *
 * @author duchao
 */
@ApiModel(value = "网站元素据")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@EqualsAndHashCode(callSuper = false)
public class CmsWebsiteDto extends PageDto {

	@ApiModelProperty(name = "id", value = "主键")
	private Integer id;

	@NotBlank(message = "名称不能为空")
	@ApiModelProperty(name = "name", value = "名称")
	private String name;

	@NotBlank(message = "关键字不能为空")
	@ApiModelProperty(name = "keywords", value = "关键字")
	private String keywords;

	@NotBlank(message = "描述不能为空")
	@ApiModelProperty(name = "description", value = "描述")
	private String description;

	@ApiModelProperty(name = "logo", value = "logo")
	private Integer cmsLogoId;

	@ApiModelProperty(name = "slogan", value = "slogan")
	private String slogan;

	@NotBlank(message = "访问网址不能为空")
	@ApiModelProperty(name = "description", value = "访问网址")
	private String url;

	@NotBlank(message = "保存路径不能为空")
	@ApiModelProperty(name = "path", value = "静态网站保存路径")
	private String path;

	@NotNull(message = "使用的模板不能为空")
	@ApiModelProperty(name = "templateGroupId", value = "使用的模板")
	private Integer templateGroupId;

	@ApiModelProperty(name = "icp", value = "icp备案")
	private String icp;

	@ApiModelProperty(name = "ower", value = "拥有者/站长")
	private String ower;

	@ApiModelProperty(name = "owerWechat", value = "拥有者联系微信（多个逗号相隔）")
	private String owerWechat;

	@ApiModelProperty(name = "owerQq", value = "拥有者联系qq（多个逗号相隔）")
	private String owerQq;

	@ApiModelProperty(name = "owerEmail", value = "拥有者联系邮箱（多个逗号相隔）")
	private String owerEmail;

	@ApiModelProperty(name = "owerHomepage", value = "拥有者主页（多个逗号相隔）")
	private String owerHomepage;

	@ApiModelProperty(name = "sort", value = "顺序")
	private Integer sort;

	@NotBlank(message = "数据库名称不能为空")
	@ApiModelProperty(name = "databaseName", value = "使用数据库名")
	private String databaseName;

	@ApiModelProperty(name = "databaseUrl", value = "数据库连接地址")
	private String databaseUrl;

	@ApiModelProperty(name = "databaseUsername", value = "数据库账户")
	private String databaseUsername;

	@ApiModelProperty(name = "databasePassword", value = "数据库密码")
	private String databasePassword;

	@NotNull(message = "数据库类型不能为空")
	@ApiModelProperty(name = "databaseLocal", value = "数据库是否在配置文件中配置的服务器：true->本服务器，false->其他服务器", allowableValues = "false,true")
	private Boolean databaseLocal;
}
