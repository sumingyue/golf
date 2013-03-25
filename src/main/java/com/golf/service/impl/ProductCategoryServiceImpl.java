package com.golf.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import com.golf.dao.ProductCategoryDao;
import com.golf.entity.ProductCategory;
import com.golf.service.ProductCategoryService;
import com.golf.tools.PagedTool;

public class ProductCategoryServiceImpl implements InitializingBean, ProductCategoryService {

	private ProductCategoryDao m_productCategoryDao;

	private Map<Integer, ProductCategory> m_productCategorys = new LinkedHashMap<Integer, ProductCategory>();

	@SuppressWarnings("unchecked")
	@Override
	public void afterPropertiesSet() throws Exception {
		List<ProductCategory> categories = m_productCategoryDao.findAllProductCategory();

		for (ProductCategory productCategory : categories) {
			m_productCategorys.put(productCategory.getId(), productCategory);
		}
	}

	@Override
	public int deleteProductCategory(int productCategoryId) {
		int id = m_productCategoryDao.delete(productCategoryId);
		if (id > 0) {
			m_productCategorys.remove(productCategoryId);
		}
		return id;
	}

	@Override
	public ProductCategory findProductCategory(int productCategoryId) {
		ProductCategory productCategory = m_productCategorys.get(productCategoryId);
		if (productCategory == null) {
			ProductCategory temp = m_productCategoryDao.findById(productCategoryId);
			if (temp != null) {
				m_productCategorys.put(productCategoryId, temp);
			}
			return temp;
		}
		return productCategory;
	}

	@Override
	public int insertProductCategory(ProductCategory productCategory) {
		int id = m_productCategoryDao.insert(productCategory);
		if (id > 0) {
			m_productCategorys.put(productCategory.getId(), productCategory);
		}
		return id;
	}

	@Override
	public List<ProductCategory> queryAllProductCategorys() {
		ArrayList<ProductCategory> arrayList = new ArrayList<ProductCategory>(m_productCategorys.values());
		Collections.sort(arrayList, new ProductCategoryCompator());
		return arrayList;
	}

	@Override
   public List<ProductCategory> queryPagedProductCategorys(PagedTool pagedTool) {
		List<ProductCategory> result = queryAllProductCategorys();
		return result.subList(pagedTool.getFromIndex(), pagedTool.getToIndex());

   }

	@Override
	public List<ProductCategory> queryProductCategoryByType(int type) {
		ArrayList<ProductCategory> all = new ArrayList<ProductCategory>(m_productCategorys.values());
		List<ProductCategory> result = new ArrayList<ProductCategory>();

		for (ProductCategory temp : all) {
			if (temp.getType() == type || type == 0) {
				result.add(temp);
			}
		}
		return result;
	}

	public void setProductCategoryDao(ProductCategoryDao productCategoryDao) {
		m_productCategoryDao = productCategoryDao;
	}

	@Override
	public int updateProductCategory(ProductCategory productCategory) {
		int id = m_productCategoryDao.update(productCategory);
		if (id > 0) {
			m_productCategorys.put(productCategory.getId(), productCategory);
		}
		return id;
	}

	public static class ProductCategoryCompator implements Comparator<ProductCategory> {

		@Override
		public int compare(ProductCategory o1, ProductCategory o2) {
			int type1 = o1.getType();
			int type2 = o2.getType();
			return type1 - type2;
		}

	}
}
