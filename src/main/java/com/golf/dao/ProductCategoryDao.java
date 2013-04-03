package com.golf.dao;

import java.util.List;

import com.golf.entity.ProductCategory;

public class ProductCategoryDao {

	private BaseDao m_baseDao;

	public int delete(int id) {
		return (Integer) m_baseDao.delete("productCategory.delete", id);
	}

	@SuppressWarnings("rawtypes")
   public List findAllProductCategory() {
		return m_baseDao.queryForList("productCategory.findAll");
	}

	public ProductCategory findById(int id) {
		return (ProductCategory) m_baseDao.queryForObject("productCategory.findById", id);
	}

	public int insert(ProductCategory productCategory) {
		return (Integer) m_baseDao.insert("productCategory.insert", productCategory);
	}

	public void setBaseDao(BaseDao baseDao) {
		m_baseDao = baseDao;
	}

	public int update(ProductCategory productCategory) {
		return m_baseDao.update("productCategory.update", productCategory);
	}
}
