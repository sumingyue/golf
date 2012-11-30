package com.golf.service;

import java.util.List;

import com.golf.entity.ProductCategory;
import com.golf.tools.PagedTool;

public interface ProductCategoryService {

	public List<ProductCategory> queryProductCategoryByType(int type);
	
	public List<ProductCategory> queryAllProductCategorys();

	public int insertProductCategory(ProductCategory productCategory);

	public int updateProductCategory(ProductCategory productCategory);

	public int deleteProductCategory(int productCategoryId);

	public ProductCategory findProductCategory(int productCategoryId);

	public List<ProductCategory> queryPagedProductCategorys(PagedTool pagedTool);

}
