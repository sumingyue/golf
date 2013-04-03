package com.golf.dao;

import java.util.List;

import com.golf.entity.ProductOrder;

public class ProductOrderDao {

	private BaseDao m_baseDao;

	public int delete(int id) {
		return (Integer) m_baseDao.delete("productOrder.delete", id);
	}

	@SuppressWarnings("rawtypes")
   public List findAllProductOrder() {
		return m_baseDao.queryForList("productOrder.findAll");
	}

	public ProductOrder findById(int id) {
		return (ProductOrder) m_baseDao.queryForObject("productOrder.findById", id);
	}

	public int insert(ProductOrder productOrder) {
		return (Integer) m_baseDao.insert("productOrder.insert", productOrder);
	}

	public void setBaseDao(BaseDao baseDao) {
		m_baseDao = baseDao;
	}

	public int update(ProductOrder productOrder) {
		return m_baseDao.update("productOrder.update", productOrder);
	}
}
