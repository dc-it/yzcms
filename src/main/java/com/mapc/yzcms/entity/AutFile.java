package com.mapc.yzcms.entity;

import com.mapc.yzcms.common.util.SnowflakeIdUtil;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 文件实体类
 *
 * @author duchao
 */
@Entity
@Table(name = "aut_file")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@DynamicUpdate
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
public class AutFile extends BaseEntity {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 文件地址
	 */
	private String path;

	/**
	 * 类型：1->图片
	 */
	private String type;

	/**
	 * 所属网站
	 */
	private Integer cmsWebsiteId;

	@PrePersist
	private void init() {
		this.id = SnowflakeIdUtil.generateId();
	}
}
