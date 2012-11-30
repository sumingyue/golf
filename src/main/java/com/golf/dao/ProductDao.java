package com.golf.dao;

import java.util.List;

import com.golf.entity.Product;

public class ProductDao {

	private BaseDao m_baseDao;

	public void setBaseDao(BaseDao baseDao) {
		m_baseDao = baseDao;
	}

	@SuppressWarnings("rawtypes")
   public List findAllProduct() {
		return m_baseDao.queryForList("product.findAll");
	}

	public Product findById(int id) {
		return (Product) m_baseDao.queryForObject("product.findById", id);
	}

	public int insert(Product product) {
		return (Integer) m_baseDao.insert("product.insert", product);
	}

	public int update(Product product) {
		return m_baseDao.update("product.update", product);
	}

	public int delete(int id) {
		return (Integer) m_baseDao.delete("product.delete", id);
	}
}
