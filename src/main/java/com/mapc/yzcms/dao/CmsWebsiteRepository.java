package com.mapc.yzcms.dao;

import com.mapc.yzcms.entity.CmsWebsite;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 网站
 *
 * @author duchao
 */
public interface CmsWebsiteRepository extends JpaRepository<CmsWebsite, Integer> {
}
