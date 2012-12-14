package com.golf.dao;

import java.util.List;

import com.golf.entity.ProductImage;

public class ProductImageDao {

	private BaseDao m_baseDao;

	public void setBaseDao(BaseDao baseDao) {
		m_baseDao = baseDao;
	}

	@SuppressWarnings("rawtypes")
   public List findByProductId(int productId) {
		return  m_baseDao.queryForList("productImage.findByProductId", productId);
	}

	public int insert(ProductImage productImage) {
		return (Integer) m_baseDao.insert("productImage.insert", productImage);
	}

	public int delete(ProductImage productImage) {
		return (Integer)m_baseDao.delete("productImage.delete", productImage);
	}
}
