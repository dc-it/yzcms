package com.mapc.yzcms.service;

import com.mapc.yzcms.common.api.ListOrPage;
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
	 * 批量添加
	 *
	 * @param entityList 实例集合
	 */
	void batchAdd(List<T> entityList);

	/**
	 * 更新
	 *
	 * @param id     实例id
	 * @param entity 实例
	 */
	void update(K id, T entity);

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

	/**
	 * 获取列表/分页
	 *
	 * @param entity
	 * @param pageable
	 * @return
	 */
	ListOrPage getListOrPage(T entity, Pageable pageable);

}
