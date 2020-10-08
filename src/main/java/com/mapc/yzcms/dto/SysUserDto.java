package com.mapc.yzcms.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.time.LocalDateTime;

@ApiModel("系统用户")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@EqualsAndHashCode(callSuper = false)
public class SysUserDto extends PageDto {

    @ApiModelProperty(name = "id", value = "系统用户id")
    private Integer id;

    @ApiModelProperty(name = "password", value = "密码")
    private String password;

    @ApiModelProperty(name = "nickName", value = "昵称")
    private String nickName;

    @ApiModelProperty(name = "remark", value = "备注")
    private String remark;

    @ApiModelProperty(name = "loginTime", value = "最后登陆时间")
    private LocalDateTime loginTime;

    @ApiModelProperty(name = "status", value = "状态:true->启用，false->禁用", allowableValues = "true,false")
    private Boolean status;

    @ApiModelProperty(name = "account", value = "账户：username、email、phone")
    private String account;
}
