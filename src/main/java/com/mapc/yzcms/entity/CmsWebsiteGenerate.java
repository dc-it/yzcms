package com.mapc.yzcms.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 静化态网站生成
 *
 * @author duchao
 */
@Entity
@Table(name = "cms_website_generate")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@DynamicUpdate
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
public class CmsWebsiteGenerate extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	/**
	 * 生成网站类型：1->完全静态，2->伪静态
	 */
	private int type;

	/**
	 * 访问网址（demo.xxx.com）
	 */
	private String url;

	/**
	 * 静态网站服务器保存路径
	 */
	private String path;

	/**
	 * 所属网站
	 */
	private long websiteId;

	/**
	 * 使用状态
	 */
	private boolean use;
}
