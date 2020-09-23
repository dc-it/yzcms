package com.mapc.yzcms.entity;

import com.mapc.yzcms.common.util.SnowflakeIdUtil;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 文章标签实体类
 *
 * @author duchao
 */
@Entity
@Table(name = "aut_tag")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@DynamicUpdate
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
public class AutTag extends BaseEntity {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	private long id;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 排序
	 */
	private int sort;

	/**
	 * 这个标签下文章数量
	 */
	private int articleNum;

	/**
	 * 所属网站
	 */
	private long websiteId;

	@PrePersist
	private void init() {
		this.id = SnowflakeIdUtil.generateId();
	}
}
