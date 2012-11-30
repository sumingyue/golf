package com.golf.service;

import java.util.List;

import com.golf.entity.ProductOrder;
import com.golf.tools.PagedTool;

public interface ProductOrderService {

	public List<ProductOrder> queryAllProductOrders();

	public int insertProductOrder(ProductOrder productOrder);

	public int updateProductOrder(ProductOrder productOrder);

	public int deleteProductOrder(int productOrderId);

	public ProductOrder findProductOrder(int productOrderId);

	public List<ProductOrder> queryPagedProductOrders(PagedTool pagedTool);

}
