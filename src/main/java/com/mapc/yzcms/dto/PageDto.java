package com.mapc.yzcms.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.io.Serializable;

/**
 * 分页参数
 * 如果PageNumber有值，PageSize可有可无都可以
 *
 * @author duchao
 */
public class PageDto implements Serializable {

    private final static int PAGE_NUMBER = 1;
    private final static int PAGE_SIZE = 10;

    @Getter
    @ApiModelProperty(name = "pageNumber", value = "页码")
    protected Integer pageNumber;

    @ApiModelProperty(name = "pageNumber", value = "一页条数")
    protected Integer pageSize;

    public PageDto() {
    }

    public PageDto(Integer pageNumber, Integer pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setPageSize(Integer pageSize) {
        if (this.pageNumber != null) {
            this.pageSize = pageSize != null ? pageSize : PAGE_SIZE;
        }
    }

    public Integer getPageSize() {
        if (this.pageNumber != null) {
            return this.pageSize != null ? this.pageSize : PAGE_SIZE;
        }
        return null;
    }
}
