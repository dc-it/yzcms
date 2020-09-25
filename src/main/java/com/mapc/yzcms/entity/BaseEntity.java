package com.mapc.yzcms.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author duchao
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

	@CreatedDate
	@Getter
	@Column(updatable = false, nullable = false)
	protected LocalDateTime createTime;

	@LastModifiedDate
	@Getter
	@Column(nullable = false)
	protected LocalDateTime updateTime;

//    @PreUpdate
//    private void setUpdateTime() {
//        this.updateTime = LocalDateTime.now();
//    }
}
