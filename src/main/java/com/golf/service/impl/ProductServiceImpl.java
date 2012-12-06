package com.golf.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import com.golf.dao.ProductDao;
import com.golf.dao.ProductImageDao;
import com.golf.entity.Image;
import com.golf.entity.Product;
import com.golf.entity.ProductImage;
import com.golf.service.ImageService;
import com.golf.service.ProductCategoryService;
import com.golf.service.ProductService;
import com.golf.tools.PagedTool;

public class ProductServiceImpl implements InitializingBean, ProductService {

	private ProductDao m_productDao;

	private ProductCategoryService m_productCategoryService;

	private ImageService m_imageService;

	private ProductImageDao m_productImageDao;

	private Map<Integer, Product> m_products = new LinkedHashMap<Integer, Product>();

	@SuppressWarnings("unchecked")
	@Override
	public void afterPropertiesSet() throws Exception {
		List<Product> all = m_productDao.findAllProduct();

		for (Product product : all) {
			int productCategoryId = product.getProductCategoryId();
			product.setProductCategory(m_productCategoryService.findProductCategory(productCategoryId));
			m_products.put(product.getId(), product);
		}
		
	}

	@Override
	public List<Product> queryAllProducts() {
		return new ArrayList<Product>(m_products.values());
	}
	
	public List<Product> queryPagedProducts(PagedTool pagedTool,int type,int productCategoryId){
		List<Product> result = new ArrayList<Product>();

		List<Product> all =new ArrayList<Product>(m_products.values());
		for (Product temp : all) {
			if (productCategoryId > 0) {
				if (temp.getProductCategoryId() == productCategoryId) {
					result.add(temp);
				}
			} else if (type > 0) {
				if (temp.getProductCategory().getType() == type) {
					result.add(temp);
				}
			} else {
				result.add(temp);
			}
		}

		return result.subList(pagedTool.getFromIndex(), pagedTool.getToIndex());
	}

	public int queryTotalSize(int type,int productCategoryId){
		List<Product> result = new ArrayList<Product>();

		List<Product> all =new ArrayList<Product>(m_products.values());
		for (Product temp : all) {
			if (productCategoryId > 0) {
				if (temp.getProductCategoryId() == productCategoryId) {
					result.add(temp);
				}
			} else if (type > 0) {
				if (temp.getProductCategory().getType() == type) {
					result.add(temp);
				}
			} else {
				result.add(temp);
			}
		}
		return result.size();
	}


	@Override
	public int insertProduct(Product product) {
		int id = m_productDao.insert(product);
		if (id > 0) {
			product.setProductCategory(m_productCategoryService.findProductCategory(product.getProductCategoryId()));
			m_products.put(product.getId(), product);
		}
		return id;
	}

	@Override
	public int updateProduct(Product product) {
		int id = m_productDao.update(product);
		if (id > 0) {
			product.setProductCategory(m_productCategoryService.findProductCategory(product.getProductCategoryId()));
			m_products.put(product.getId(), product);
		}
		return id;
	}

	@Override
	public int deleteProduct(int productId) {
		int id = m_productDao.delete(productId);
		if (id > 0) {
			m_products.remove(productId);
		}
		return id;
	}

	@Override
	public Product findProduct(int productId) {
		Product product = m_products.get(productId);
		if (product == null) {
			Product temp = m_productDao.findById(productId);
			if (temp != null) {
				m_products.put(productId, temp);
			}
			return temp;
		}
		return product;
	}

	public void setProductDao(ProductDao productDao) {
		m_productDao = productDao;
	}

	public void setProductCategoryService(ProductCategoryService productCategoryService) {
		m_productCategoryService = productCategoryService;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Image> findImagesByProductId(int productId) {
		List<Image> results = new ArrayList<Image>();
		List<ProductImage> images = m_productImageDao.findByProductId(productId);
		for (ProductImage image : images) {
			results.add(m_imageService.findImage(image.getImageId()));
		}
		return results;
	}

	@Override
	public void insertProductImage(ProductImage productImage) {
		m_productImageDao.insert(productImage);
	}

	public void setImageService(ImageService imageService) {
		m_imageService = imageService;
	}

	public void setProductImageDao(ProductImageDao productImageDao) {
		m_productImageDao = productImageDao;
	}

	@Override
   public Object deleteProductImage(ProductImage productImage) {
		return m_productImageDao.delete(productImage);
   }
	
}
