package com.mapc.yzcms.controller;

import com.mapc.yzcms.common.api.ListOrPage;
import com.mapc.yzcms.common.api.Result;
import com.mapc.yzcms.entity.AutArticle;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文章
 *
 * @author duchao
 */
@RestController
@RequestMapping("/aut/articles")
public class AutArticleController {

	@GetMapping
	public Result<ListOrPage> getAutArticleList(AutArticle autArticle){

		return Result.success();
	}

	@GetMapping("{id}")
	public Result<AutArticle> getAutArticle(@PathVariable ("id") String autArticleId){

		return Result.success();
	}
}
