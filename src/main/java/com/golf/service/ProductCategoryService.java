package com.golf.service;

import java.util.List;

import com.golf.entity.ProductCategory;
import com.golf.tools.PagedTool;

public interface ProductCategoryService {

	public int deleteProductCategory(int productCategoryId);
	
	public ProductCategory findProductCategory(int productCategoryId);

	public int insertProductCategory(ProductCategory productCategory);

	public List<ProductCategory> queryAllProductCategorys();

	public List<ProductCategory> queryPagedProductCategorys(PagedTool pagedTool);

	public List<ProductCategory> queryProductCategoryByType(int type);

	public int updateProductCategory(ProductCategory productCategory);

}
