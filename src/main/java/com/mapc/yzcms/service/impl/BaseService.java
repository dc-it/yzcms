package com.mapc.yzcms.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.mapc.yzcms.common.util.AssertUtil;
import com.mapc.yzcms.common.util.DataUtil;
import com.mapc.yzcms.common.api.ListOrPage;
import com.mapc.yzcms.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author duchao
 */
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
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void add(T entity) {
		jpaRepository.save(entity);
	}

	/**
	 * 添加
	 *
	 * @param entityList 实例
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void batchAdd(List<T> entityList) {
		jpaRepository.saveAll(entityList);
	}

	/**
	 * 更新
	 *
	 * @param entity 实例
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void update(K id, T entity) {
		AssertUtil.notNull(id,"id不能为空");
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
	@Transactional(rollbackFor = Exception.class)
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
	public ListOrPage getListOrPage(T entity, Pageable pageable) {

		ListOrPage listOrPage = new ListOrPage();

		if(pageable==null){
			listOrPage.setPage(false);
			listOrPage.setData(this.getList(entity));
		}else{

			Objects.requireNonNull(pageable.getPageNumber(),"页码不能为空");
			Objects.requireNonNull(pageable.getPageSize(),"一页条数不能为空");

			PageRequest pageRequest = PageRequest.of(pageable.getPageNumber()-1, pageable.getPageSize());

			Page<T> page = this.getPage(entity, pageRequest);
			listOrPage.setPage(true);
			listOrPage.setData(page.getContent());
			listOrPage.setTotalPage(page.getTotalPages());
			listOrPage.setTotalElement(page.getTotalElements());
			listOrPage.setPageSize(page.getPageable().getPageSize());
			listOrPage.setPageNumber(page.getPageable().getPageNumber()+1);
		}
		return listOrPage;
	}
}
