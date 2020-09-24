package com.mapc.yzcms.service;

import com.mapc.yzcms.entity.CmsMenu;

/**
 * 接口
 *
 * @author duchao
 */
public interface ICmsMenuService extends IBaseService<CmsMenu, Integer> {

    /**
     * 添加菜单
     *
     * @param cmsMenu 菜单
     */
    void addMenu(CmsMenu cmsMenu);
}
