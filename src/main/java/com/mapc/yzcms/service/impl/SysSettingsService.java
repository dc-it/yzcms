package com.mapc.yzcms.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.mapc.yzcms.dao.SysSettingsRepository;
import com.mapc.yzcms.entity.SysSettings;
import com.mapc.yzcms.service.ISysSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 设置
 *
 * @author duchao
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class SysSettingsService extends BaseService<SysSettings, Integer> implements ISysSettingsService {

    private final SysSettingsRepository sysSettingsRepository;

    @Autowired
    public SysSettingsService(SysSettingsRepository sysSettingsRepository) {
        this.sysSettingsRepository = sysSettingsRepository;
    }

    /**
     * 获取系统设置
     *
     * @return
     */
    @Override
    public SysSettings getSysSettings() {
        List<SysSettings> sysSettingsList = this.getList(null);
        return CollectionUtil.isNotEmpty(sysSettingsList)?sysSettingsList.get(0):null;
    }
}
