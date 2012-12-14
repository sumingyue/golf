package com.golf.service;

import java.util.List;

import com.golf.entity.Image;
import com.golf.entity.Product;
import com.golf.entity.ProductImage;
import com.golf.tools.PagedTool;

public interface ProductService {

	public List<Product> queryAllProducts();	
	
	public List<Product> queryPagedProducts(PagedTool tool,int categoryId,int smallCategoryId);

	public int queryTotalSize(int categoryId,int smallCategoryId);

	public int insertProduct(Product product);

	public int updateProduct(Product product);

	public int deleteProduct(int productId);

	public Product findProduct(int productId);

	public List<Image> findImagesByProductId(int productId);
	
	public int insertProductImage(ProductImage productImage);
	
	public Object deleteProductImage(ProductImage productImage);
}
