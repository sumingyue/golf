package com.golf.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import com.golf.dao.ProductOrderDao;
import com.golf.entity.ProductOrder;
import com.golf.service.ProductOrderService;
import com.golf.service.ProductService;
import com.golf.tools.PagedTool;

public class ProductOrderServiceImpl implements InitializingBean, ProductOrderService {

	private ProductOrderDao m_productOrderDao;

	private ProductService m_productService;

	private Map<Integer, ProductOrder> m_productOrders = new LinkedHashMap<Integer, ProductOrder>();

	@SuppressWarnings("unchecked")
	@Override
	public void afterPropertiesSet() throws Exception {
		List<ProductOrder> categories = m_productOrderDao.findAllProductOrder();

		for (ProductOrder productOrder : categories) {
			productOrder.setProduct(m_productService.findProduct(productOrder.getProductId()));
			m_productOrders.put(productOrder.getId(), productOrder);
		}
	}

	@Override
	public int deleteProductOrder(int productOrderId) {
		int id = m_productOrderDao.delete(productOrderId);
		if (id > 0) {
			m_productOrders.remove(productOrderId);
		}
		return id;
	}

	@Override
	public ProductOrder findProductOrder(int productOrderId) {
		ProductOrder productOrder = m_productOrders.get(productOrderId);
		if (productOrder == null) {
			productOrder = m_productOrderDao.findById(productOrderId);
			if (productOrder != null) {
				m_productOrders.put(productOrderId, productOrder);
			}
		}
		return productOrder;
	}

	@Override
	public int insertProductOrder(ProductOrder productOrder) {
		int id = m_productOrderDao.insert(productOrder);
		if (id > 0) {
			productOrder.setProduct(m_productService.findProduct(productOrder.getProductId()));
			m_productOrders.put(productOrder.getId(), productOrder);
		}
		return id;
	}

	@Override
	public List<ProductOrder> queryAllProductOrders() {
		ArrayList<ProductOrder> arrayList = new ArrayList<ProductOrder>(m_productOrders.values());
		Collections.sort(arrayList,new ProductOrderCompator());
		return arrayList;
	}

	@Override
   public List<ProductOrder> queryPagedProductOrders(PagedTool pagedTool) {
		List<ProductOrder> result = queryAllProductOrders();
		return result.subList(pagedTool.getFromIndex(), pagedTool.getToIndex());

   }

	public void setProductOrderDao(ProductOrderDao productOrderDao) {
		m_productOrderDao = productOrderDao;
	}

	public void setProductService(ProductService productService) {
		m_productService = productService;
	}
	
	@Override
	public int updateProductOrder(ProductOrder productOrder) {
		int id = m_productOrderDao.update(productOrder);
		if (id > 0) {
			productOrder.setProduct(m_productService.findProduct(productOrder.getProductId()));
			m_productOrders.put(productOrder.getId(), productOrder);
		}
		return id;
	}

	public static class ProductOrderCompator implements Comparator<ProductOrder> {

		@Override
		public int compare(ProductOrder o1, ProductOrder o2) {
			return o2.getId()-o1.getId();
		}
	}
}
