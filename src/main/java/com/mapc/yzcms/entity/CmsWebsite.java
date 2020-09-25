package com.mapc.yzcms.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * 网站实体类
 *
 * @author duchao
 */
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
public class CmsWebsite extends BaseEntity {

	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 关键字
	 */
	private String keywords;

	/**
	 * 描述
	 */
	private String description;

	/**
	 * logo图片
	 */
	private Integer logoImageId;

	/**
	 * 网站slogan
	 */
	private String slogan;

	/**
	 * 访问网址
	 */
	private String url;

	/**
	 * 静态网站服务器保存路径
	 */
	private String path;

	/**
	 * 使用的模板
	 */
	private Integer cmsTemplateGroupId;

	/**
	 * icp备案
	 */
	private String icp;

	/**
	 * 拥有者/站长
	 */
	private String ower;

	/**
	 * 拥有者联系微信（多个逗号相隔）
	 */
	private String owerWechat;

	/**
	 * 拥有者联系qq（多个逗号相隔）
	 */
	private String owerQq;

	/**
	 * 拥有者联系邮箱（多个逗号相隔）
	 */
	private String owerEmail;

	/**
	 * 拥有者主页（多个逗号相隔）
	 */
	private String owerHomepage;

	/**
	 * 排序
	 */
	private Integer sort;

	/**
	 * 使用数据库名
	 */
	private String databaseName;

	/**
	 * 数据库连接地址
	 */
	private String databaseUrl;

	/**
	 * 数据库账户
	 */
	private String databaseUsername;

	/**
	 * 数据库密码
	 */
	private String databasePassword;

	/**
	 * 数据库是否在配置文件中配置的服务器
	 */
	private Boolean databaseLocal;
}
