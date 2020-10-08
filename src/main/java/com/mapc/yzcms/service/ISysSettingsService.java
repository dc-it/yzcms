package com.mapc.yzcms.service;

import com.mapc.yzcms.entity.SysSettings;

/**
 * 接口
 *
 * @author duchao
 */
public interface ISysSettingsService extends IBaseService<SysSettings, Integer> {

    /**
     * 获取系统设置
     *
     * @return
     */
    SysSettings getSysSettings();
}
