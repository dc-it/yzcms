package com.mapc.yzcms.dao;

import com.mapc.yzcms.entity.SysSettings;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 系统设置
 *
 * @author duchao
 */
public interface SysSettingsRepository extends JpaRepository<SysSettings, Integer> {

}
