package com.mapc.yzcms.common.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 结果数据
 *
 * @author duchao
 */
@ApiModel(value = "结果数据")
public class ListOrPage {

	@Getter
	@Setter
	@ApiModelProperty(name = "page",value = "是否是分页",allowableValues = "false,true")
	private boolean page;

	@Getter
	@Setter
	@ApiModelProperty(name = "totalElements",value = "data条数")
	private Long totalElement;

	@Getter
	@Setter
	@ApiModelProperty(name = "totalElements",value = "data条数")
	private Integer totalPage;

	@Getter
	@Setter
	@ApiModelProperty(name = "pageNumber",value = "页码")
	private Integer pageNumber;

	@Getter
	@Setter
	@ApiModelProperty(name = "pageSize",value = "页码大小")
	private Integer pageSize;

	@Getter
	@ApiModelProperty(name = "data",value = "数据")
	private Object data;

	public <T> void setData(T data) {
		this.data = data;
	}
}
