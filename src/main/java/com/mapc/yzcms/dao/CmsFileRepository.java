package com.mapc.yzcms.dao;

import com.mapc.yzcms.entity.CmsFile;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 站点元数据文件
 *
 * @author duchao
 */
public interface CmsFileRepository extends JpaRepository<CmsFile, Integer> {
}
