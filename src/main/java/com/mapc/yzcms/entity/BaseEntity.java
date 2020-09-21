package com.mapc.yzcms.entity;

import com.mapc.yzcms.common.util.SnowflakeIdUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author duchao
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

	@Getter
	@Setter
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	protected long id;

	@CreatedDate
	@Getter
	@Column(updatable = false, nullable = false)
	protected LocalDateTime createTime;

	@LastModifiedDate
	@Getter
	@Column(nullable = false)
	protected LocalDateTime updateTime;

	@PrePersist
	private void init() {
		this.id = SnowflakeIdUtil.generateId();
	}

//    @PreUpdate
//    private void setUpdateTime() {
//        this.updateTime = LocalDateTime.now();
//    }
}
