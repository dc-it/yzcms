package com.mapc.yzcms.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 结果数据
 *
 * @author duchao
 */
@ApiModel(value = "结果数据")
@Data
public class ResultData<T> {

	@ApiModelProperty(name = "total",value = "data条数")
	private Integer total;

	@ApiModelProperty(name = "page",value = "页码")
	private Integer page;

	@ApiModelProperty(name = "size",value = "页码大小")
	private Integer size;

	@ApiModelProperty(name = "size",value = "数据")
	private T data;
}
