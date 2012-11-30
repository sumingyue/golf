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

	public Object insert(ProductImage productImage) {
		return (Object) m_baseDao.insert("productImage.insert", productImage);
	}

	public Object delete(ProductImage productImage) {
		Object object = m_baseDao.delete("productImage.delete", productImage);
		return  object;
	}
}
