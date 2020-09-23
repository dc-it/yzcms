package com.mapc.yzcms.entity;

import com.mapc.yzcms.common.util.SnowflakeIdUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
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

	/**
	 * 创建人
	 */
	@Getter
	@Setter
	protected long createBy;

	@LastModifiedDate
	@Getter
	@Column(nullable = false)
	protected LocalDateTime updateTime;

	/**
	 * 更新人
	 */
	@Getter
	@Setter
	protected long updateBy;

//    @PreUpdate
//    private void setUpdateTime() {
//        this.updateTime = LocalDateTime.now();
//    }
}
