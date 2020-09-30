package com.mapc.yzcms.controller;

import com.mapc.yzcms.common.api.ListOrPage;
import com.mapc.yzcms.common.api.Result;
import com.mapc.yzcms.entity.AutArticle;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;

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

	@PostMapping
	public Result<Object> addAutArticle(@RequestBody AutArticle autArticle){

		return Result.success();
	}
}
