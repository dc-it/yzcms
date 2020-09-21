package com.mapc.yzcms.dao;

import com.mapc.yzcms.entity.CmsMenu;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 菜单
 *
 * @author duchao
 */
public interface CmsMenuRepository extends JpaRepository<CmsMenu, Long> {
}
