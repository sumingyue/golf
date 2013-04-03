package com.golf.service;

import java.util.List;

import com.golf.entity.ProductOrder;
import com.golf.tools.PagedTool;

public interface ProductOrderService {

	public int deleteProductOrder(int productOrderId);

	public ProductOrder findProductOrder(int productOrderId);

	public int insertProductOrder(ProductOrder productOrder);

	public List<ProductOrder> queryAllProductOrders();

	public List<ProductOrder> queryPagedProductOrders(PagedTool pagedTool);

	public int updateProductOrder(ProductOrder productOrder);

}
