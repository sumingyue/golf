package com.golf.service;

import java.util.List;

import com.golf.entity.Image;
import com.golf.entity.Product;
import com.golf.entity.ProductImage;
import com.golf.tools.PagedTool;

public interface ProductService {

	public int deleteProduct(int productId);	
	
	public Object deleteProductImage(ProductImage productImage);

	public List<Image> findImagesByProductId(int productId);

	public Product findProduct(int productId);

	public int insertProduct(Product product);

	public int insertProductImage(ProductImage productImage);

	public List<Product> queryAllProducts();

	public List<Product> queryPagedProducts(PagedTool tool,int categoryId,int smallCategoryId);
	
	public int queryTotalSize(int categoryId,int smallCategoryId);
	
	public int updateProduct(Product product);
}
