package com.mapc.yzcms.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 文章分组
 *
 * @author duchao
 */
@Entity
@Table(name = "aut_group")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@DynamicUpdate
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
public class AutGroup extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	/**
	 * 作者
	 */
	private int authorId;

	/**
	 * 组名
	 */
	private String name;

	/**
	 * 组名（英文）
	 */
	private String enname;

	/**
	 * 访问路径
	 */
	private String path;

	/**
	 * 父id，跟字典为0
	 */
	private int pid;

}
