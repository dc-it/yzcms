package com.mapc.yzcms.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author duchao
 */
public interface IBaseService<T, K> {

    /**
     * 添加
     *
     * @param entity 实例
     */
    void add(T entity);

    /**
     * 更新
     *
     * @param entity 实例
     */
    void update(T entity);

    /**
     * 删除
     *
     * @param id 主键
     */
    void delete(K id);

    /**
     * 获取某个对象
     *
     * @param id 主键
     * @return
     */
    T get(K id);

    /**
     * 获取集合
     *
     * @param entity 对象
     * @return
     */
    List<T> getList(T entity);

    /**
     * 获取分页
     *
     * @param entity   实体
     * @param pageable 分页参数
     * @return
     */
    Page<T> getPage(T entity, Pageable pageable);

}
