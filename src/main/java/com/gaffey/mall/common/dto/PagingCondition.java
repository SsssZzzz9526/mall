package com.gaffey.mall.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 分页条件
 *
 * @author gaffey
 * @created 2020-09-17 22:43:00
 */
@Data
public class PagingCondition {

    @ApiModelProperty(value = "页数")
    private Integer pageNum = 1;

    @ApiModelProperty(value = "每页显示记录数")
    private Integer pageSize = 10;
}
