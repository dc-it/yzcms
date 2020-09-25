package com.mapc.yzcms.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.collection.CollectionUtil;
import com.mapc.yzcms.common.util.DataUtil;
import com.mapc.yzcms.dto.ResultData;
import com.mapc.yzcms.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

/**
 * @author duchao
 */
@Transactional(rollbackFor = Exception.class)
public class BaseService<T, K> implements IBaseService<T, K> {

	@PersistenceContext
	private EntityManager entityManager;
	private Class<T> clazz;
	private SimpleJpaRepository jpaRepository;

	@Autowired
	public BaseService() {
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz = (Class<T>) pt.getActualTypeArguments()[0];
	}

	@PostConstruct
	public void init() {
		jpaRepository = new SimpleJpaRepository(clazz, entityManager);
	}

	/**
	 * 添加
	 *
	 * @param entity 实例
	 */
	@Override
	public void add(T entity) {
		jpaRepository.save(entity);
	}

	/**
	 * 更新
	 *
	 * @param entity 实例
	 */
	@Override
	public void update(K id, T entity) {
		Optional<T> entityOptional = jpaRepository.findById(id);
		entityOptional.ifPresent(obj -> {
			//过滤空字符串
			DataUtil.converterBlank2Null(entity, clazz);
			BeanUtil.copyProperties(entity, obj, new CopyOptions() {{
				setIgnoreNullValue(true);
			}});
			jpaRepository.save(obj);
		});
	}

	/**
	 * 删除
	 *
	 * @param id 主键
	 */
	@Override
	public void delete(K id) {
		jpaRepository.deleteById(id);
	}

	/**
	 * 获取某个对象
	 *
	 * @param id 主键
	 * @return
	 */
	@Override
	public T get(K id) {
		return (T) jpaRepository.getOne(id);
	}

	/**
	 * 获取集合
	 *
	 * @param entity 对象
	 * @return
	 */
	@Override
	public List<T> getList(T entity) {
		return jpaRepository.findAll(Example.of(entity));
	}

	/**
	 * 获取分页
	 *
	 * @param entity   实体
	 * @param pageable 分页参数
	 * @return
	 */
	@Override
	public Page<T> getPage(T entity, Pageable pageable) {
		return jpaRepository.findAll(Example.of(entity), pageable);
	}

	/**
	 * 获取列表/分页
	 *
	 * @param entity
	 * @param pageable
	 * @return
	 */
	@Override
	public ResultData<T> getListOrPage(T entity, Pageable pageable) {

		ResultData<T> resultData = new ResultData<>();

		if(pageable==null){
			//resultData.setData(this.getList(entity));
		}else{
			Page<T> page = this.getPage(entity, pageable);
		}

		return null;
	}
}
