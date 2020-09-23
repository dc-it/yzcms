package com.mapc.yzcms.service.impl;

import com.mapc.yzcms.dao.AutArticleRepository;
import com.mapc.yzcms.entity.AutArticle;
import com.mapc.yzcms.service.IAutArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 文章服务
 *
 * @author duchao
 */
@Slf4j
@Transactional(rollbackFor = Exception.class)
@Service
public class AutArticleService extends BaseService<AutArticle, Long> implements IAutArticleService {

    private final AutArticleRepository autArticleRepository;

    @Autowired
    public AutArticleService(AutArticleRepository autArticleRepository) {
        this.autArticleRepository = autArticleRepository;
    }

    @Override
    public void addArticle(AutArticle autArticle){
        this.add(autArticle);
    }
}
