package com.mapc.yzcms.entity;

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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;

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
	private long templateGroupId;

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
	 * 顺序
	 */
	private int sort;
}
