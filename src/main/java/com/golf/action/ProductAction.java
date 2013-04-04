package com.golf.action;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;

import com.golf.Config;
import com.golf.entity.Image;
import com.golf.entity.ImageType;
import com.golf.entity.Product;
import com.golf.entity.ProductCategory;
import com.golf.entity.ProductImage;
import com.golf.entity.UploadFile;
import com.golf.service.ImageService;
import com.golf.service.ProductCategoryService;
import com.golf.service.ProductService;
import com.golf.tools.PagedTool;
import com.opensymphony.xwork2.ActionSupport;

public class ProductAction extends ActionSupport {

	private static final long serialVersionUID = 2801256599554299998L;

	private Logger m_logger = Logger.getLogger(ProductAction.class);

	private List<Product> m_products;

	private List<ProductCategory> m_productCategorys;

	private int m_productId;

	private int m_imageId;

	private int m_type;

	private int m_productCategoryId;

	private ProductService m_productService;

	private ProductCategoryService m_productCategoryService;

	private PagedTool m_pagedTool = new PagedTool(Config.DEFAULT_PAGE_NUMBER);

	private Product m_product = new Product();

	private ImageService m_imageService;

	private UploadFile m_uploadFile = new UploadFile();

	private UploadFile[] m_uploadFiles = new UploadFile[5];

	private File[] m_uploads = new File[5];

	public PagedTool getPagedTool() {
		return m_pagedTool;
	}

	public Product getProduct() {
		return m_product;
	}

	public int getProductCategoryId() {
		return m_productCategoryId;
	}

	public List<ProductCategory> getProductCategorys() {
		return m_productCategorys;
	}

	public int getProductId() {
		return m_productId;
	}

	public List<Product> getProducts() {
		return m_products;
	}

	public int getType() {
		return m_type;
	}

	private int insertImage(File file, UploadFile uploadFile) {
		return m_imageService.insert(file, m_uploadFile, ImageType.PRODUCT);
	}

	public String productAdd() {
		m_productCategorys = m_productCategoryService.queryAllProductCategorys();
		return SUCCESS;
	}

	public String productAddImageSubmit() {
		int size = m_uploads.length;

		String result = SUCCESS;

		for (int i = 0; i < size; i++) {
			try {
				ProductImage temp = new ProductImage();
				File file = m_uploads[i];

				if (file != null) {
					int imageId = insertImage(file, m_uploadFiles[i]);

					temp.setImageId(imageId);
					temp.setProductId(m_product.getId());
					int id = m_productService.insertProductImage(temp);

					if (id <= 0) {
						result = ERROR;
					}
				}
			} catch (Exception e) {
				m_logger.error(e);
				result = ERROR;
			}
		}
		m_productId = m_product.getId();
		return result;
	}

	public String productAddSubmit() {
		try {
			int id = m_productService.insertProduct(m_product);
			m_productId = id;
			if (id > 0) {
				return SUCCESS;
			} else {
				return ERROR;
			}

		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
	}

	public String productDelete() {
		try {
			int count = m_productService.deleteProduct(m_productId);
			if (count > 0) {
				return SUCCESS;
			} else {
				return ERROR;
			}
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
	}

	public String productImageDelete() {
		ProductImage productImage = new ProductImage();
		productImage.setProductId(m_productId);
		productImage.setImageId(m_imageId);

		m_productId = productImage.getProductId();

		int count = (Integer) m_productService.deleteProductImage(productImage);
		if (count > 0) {
			return SUCCESS;
		} else {
			this.addActionError("Delete Image Error");
			return ERROR;
		}
	}

	public String productList() {
		try {
			// m_productCategorys = m_productCategoryService.queryProductCategoryByType(m_type);
			// int totalSize = m_productService.queryTotalSize(m_type, m_productCategoryId);
			//
			// m_pagedTool.setTotalNumber(totalSize);
			//
			// m_products = m_productService.queryPagedProducts(m_pagedTool, m_type, m_productCategoryId);
			m_products = m_productService.queryAllProducts();
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String productUpdate() {
		try {
			m_productCategorys = m_productCategoryService.queryAllProductCategorys();
			m_product = m_productService.findProduct(m_productId);

			List<Image> images = m_productService.findImagesByProductId(m_productId);
			m_product.setImages(images);
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String productUpdateSubmit() {
		try {
			int count = m_productService.updateProduct(m_product);
			if (count > 0) {
				return SUCCESS;
			} else {
				return ERROR;
			}
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
	}

	public void setImageId(int imageId) {
		m_imageId = imageId;
	}

	public void setImageService(ImageService imageService) {
		m_imageService = imageService;
	}

	public void setIndex(int index) {
		m_pagedTool.setPageIndex(index);
	}

	public void setPagedTool(PagedTool pagedTool) {
		m_pagedTool = pagedTool;
	}

	public void setProduct(Product product) {
		m_product = product;
	}

	public void setProductCategoryId(int productCategoryId) {
		m_productCategoryId = productCategoryId;
	}

	public void setProductCategoryService(ProductCategoryService productCategoryService) {
		m_productCategoryService = productCategoryService;
	}

	public void setProductId(int productId) {
		m_productId = productId;
	}

	public void setProductService(ProductService productService) {
		m_productService = productService;
	}

	public void setType(int type) {
		m_type = type;
	}

	public void setUploadContentType(String contentType) {
		m_uploadFile.setContentType(contentType);
	}

	public void setUploadFileName(String filename) {
		m_uploadFile.setFilename(filename);
	}

	public void setUploads(File[] uploads) {
		m_uploads = uploads;
	}

	public void setUploadsContentType(String contentType) {
		String[] contentTypes = contentType.split(",");
		for (int i = 0; i < contentTypes.length; i++) {
			UploadFile upload = m_uploadFiles[i];
			if (upload == null) {
				upload = new UploadFile();
				m_uploadFiles[i] = upload;
			}
			m_uploadFiles[i].setContentType(contentTypes[i]);
		}
	}

	public void setUploadsFileName(String filename) {
		String[] fileNames = filename.split(",");
		for (int i = 0; i < fileNames.length; i++) {
			UploadFile upload = m_uploadFiles[i];
			if (upload == null) {
				upload = new UploadFile();
				m_uploadFiles[i] = upload;
			}
			m_uploadFiles[i].setFilename(fileNames[i]);
		}
	}
}