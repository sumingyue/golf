package com.golf.main;

import java.util.List;

import com.golf.entity.Image;
import com.golf.entity.Product;
import com.golf.entity.ProductCategory;
import com.golf.entity.ProductOrder;
import com.golf.service.AdwordsService;
import com.golf.service.ProductCategoryService;
import com.golf.service.ProductOrderService;
import com.golf.service.ProductService;
import com.golf.tools.PagedTool;
import com.opensymphony.xwork2.ActionSupport;

public class UserProductAction extends ActionSupport {

	private static final long serialVersionUID = 2801256589554291998L;

	private static final int SIZE = 20;

	private ProductService m_productService;

	private ProductCategoryService m_productCategoryService;

	private PagedTool m_pagedTool = new PagedTool(SIZE);

	private List<Product> m_products;

	private List<ProductCategory> m_category1;

	private List<ProductCategory> m_category2;

	private List<ProductCategory> m_category3;

	private List<ProductCategory> m_category4;

	private int m_type = 1;

	private int m_productId;

	private int m_productCategoryId = 0;

	private ProductCategory m_productCategory;

	private Product m_product;

	private ProductOrder m_productOrder = new ProductOrder();

	private ProductOrderService m_productOrderService;

	private AdwordsService m_adwordsService;

	@Override
	public String execute() throws Exception {
		m_productCategory = m_productCategoryService.findProductCategory(m_productCategoryId);
		m_category1 = m_productCategoryService.queryProductCategoryByType(1);
		m_category2 = m_productCategoryService.queryProductCategoryByType(2);
		m_category3 = m_productCategoryService.queryProductCategoryByType(3);
		m_category4 = m_productCategoryService.queryProductCategoryByType(4);

		int totalSize = m_productService.queryTotalSize(m_type, m_productCategoryId);
		m_pagedTool.setTotalNumber(totalSize);

		m_products = m_productService.queryPagedProducts(m_pagedTool, m_type, m_productCategoryId);

		for (Product product : m_products) {
			product = m_productService.findProduct(product.getId());

			List<Image> images = m_productService.findImagesByProductId(product.getId());
			product.setImages(images);
			if (images.size() > 0) {
				product.setImage(images.get(0));
			}
		}
		return SUCCESS;
	}

	public String productDetail() {
		m_category1 = m_productCategoryService.queryProductCategoryByType(1);
		m_category2 = m_productCategoryService.queryProductCategoryByType(2);
		m_category3 = m_productCategoryService.queryProductCategoryByType(3);
		m_category4 = m_productCategoryService.queryProductCategoryByType(4);
		m_product = m_productService.findProduct(m_productId);

		List<Image> images = m_productService.findImagesByProductId(m_product.getId());
		m_product.setImages(images);
		return SUCCESS;
	}

	public String userOrderSub() {
		m_productOrderService.insertProductOrder(m_productOrder);
		return SUCCESS;
	}

	public PagedTool getPagedTool() {
		return m_pagedTool;
	}

	public void setPagedTool(PagedTool pagedTool) {
		m_pagedTool = pagedTool;
	}

	public List<ProductCategory> getCategory1() {
		return m_category1;
	}

	public List<ProductCategory> getCategory2() {
		return m_category2;
	}

	public List<ProductCategory> getCategory3() {
		return m_category3;
	}

	public List<ProductCategory> getCategory4() {
		return m_category4;
	}

	public void setProductService(ProductService productService) {
		m_productService = productService;
	}

	public void setProductCategoryService(ProductCategoryService productCategoryService) {
		m_productCategoryService = productCategoryService;
	}

	public void setProductCategoryId(int productCategoryId) {
		m_productCategoryId = productCategoryId;
	}

	public void setId(int id) {
		m_productCategoryId = id;
		m_productId = id;
	}

	public List<Product> getProducts() {
		return m_products;
	}

	public ProductCategory getProductCategory() {
		return m_productCategory;
	}

	public int getType() {
		return m_type;
	}

	public void setType(int type) {
		m_type = type;
	}

	public Product getProduct() {
		return m_product;
	}

	public ProductOrder getProductOrder() {
		return m_productOrder;
	}

	public void setProductOrderService(ProductOrderService productOrderService) {
		m_productOrderService = productOrderService;
	}
	public void setAdwordsService(AdwordsService adwordsService) {
		m_adwordsService = adwordsService;
	}
	
	public AdwordsService getAdwordsService() {
		return m_adwordsService;
	}

}