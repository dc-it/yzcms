package com.mapc.yzcms.controller;

import com.mapc.yzcms.common.api.Result;
import com.mapc.yzcms.entity.CmsArticle;
import com.mapc.yzcms.entity.CmsMenu;
import com.mapc.yzcms.service.ICmsArticleService;
import com.mapc.yzcms.service.ICmsMenuService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 菜单
 *
 * @author duchao
 */
@RestController
@RequestMapping("/menu")
public class CmsMenuController {

    private final ICmsMenuService menuService;
    private final ICmsArticleService articleService;

    @Autowired
    public CmsMenuController(ICmsMenuService menuService, ICmsArticleService articleService) {
        this.menuService = menuService;
        this.articleService = articleService;
    }

    @GetMapping("/1")
    public Result<Object> addMenu(){
        return Result.success();
    }

    @PostMapping("/2")
    public Result<Object> addMenu2(){
        return Result.success();
    }

    @PutMapping
    public void updateMenu(@RequestBody CmsMenu cmsMenu){
        menuService.update(cmsMenu);
    }

}
