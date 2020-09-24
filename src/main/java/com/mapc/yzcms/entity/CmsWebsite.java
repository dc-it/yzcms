package com.mapc.yzcms.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

/**
 * 网站实体类
 *
 * @author duchao
 */
@ApiModel(value = "网站元素据")
@Entity
@Table(name = "cms_website")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@DynamicUpdate
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
public class CmsWebsite extends BaseEntity{

	@ApiModelProperty(name = "id",value = "主键")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@ApiModelProperty(name = "name",value = "名称")
	private String name;

	@ApiModelProperty(name = "keywords",value = "关键字")
	private String keywords;

	@ApiModelProperty(name = "description",value = "描述")
	private String description;

	@ApiModelProperty(name = "description",value = "访问网址")
	private String url;

	@ApiModelProperty(name = "path",value = "静态网站服务器保存路径")
	private String path;

	@ApiModelProperty(name = "templateGroupId",value = "使用的模板")
	private long templateGroupId;

	@ApiModelProperty(name = "icp",value = "icp备案")
	private String icp;

	@ApiModelProperty(name = "ower",value = "拥有者/站长")
	private String ower;

	@ApiModelProperty(name = "owerWechat",value = "拥有者联系微信（多个逗号相隔）")
	private String owerWechat;

	@ApiModelProperty(name = "owerQq",value = "拥有者联系qq（多个逗号相隔）")
	private String owerQq;

	@ApiModelProperty(name = "owerEmail",value = "拥有者联系邮箱（多个逗号相隔）")
	private String owerEmail;

	@ApiModelProperty(name = "owerHomepage",value = "拥有者主页（多个逗号相隔）")
	private String owerHomepage;

	@ApiModelProperty(name = "sort",value = "顺序")
	private int sort;

	@ApiModelProperty(name = "databaseName",value = "使用数据库名")
	private String databaseName;

	@ApiModelProperty(name = "databaseUrl",value = "数据库连接地址")
	private String databaseUrl;

	@ApiModelProperty(name = "databaseUsername",value = "数据库账户")
	private String databaseUsername;

	@ApiModelProperty(name = "databasePassword",value = "数据库密码")
	private String databasePassword;

	@ApiModelProperty(name = "databaseLocal",value = "数据库是否在配置文件中配置的服务器")
	private boolean databaseLocal;
}
