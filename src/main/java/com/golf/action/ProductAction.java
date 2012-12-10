package com.golf.action;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.golf.Config;
import com.golf.entity.Image;
import com.golf.entity.Product;
import com.golf.entity.ProductCategory;
import com.golf.entity.ProductImage;
import com.golf.entity.UploadFile;
import com.golf.service.ImageService;
import com.golf.service.ProductCategoryService;
import com.golf.service.ProductService;
import com.golf.tools.ImageTools;
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

	private File m_upload;

	private int insertImage() {
		String fileName = m_uploadFile.getFilename();
		String relativePath = Config.IMAGE_PATH + ImageTools.getImageStorePath(fileName, "_normal", Image.PRODUCT);
		String storePath = ServletActionContext.getServletContext().getRealPath("/") + "/" + relativePath;

		String compressRelativePath = Config.IMAGE_PATH + ImageTools.getImageStorePath(fileName, "_small", Image.PRODUCT);
		String compressStorePath = ServletActionContext.getServletContext().getRealPath("/") + "/" + compressRelativePath;

		String originalPath = ImageTools.getOriginalPath(fileName, Image.PRODUCT);
		m_uploadFile.setOriginalPath(originalPath);

		m_uploadFile.setPath(relativePath);
		m_uploadFile.setStorePath(storePath);

		m_uploadFile.setCompressedPath(compressRelativePath);
		m_uploadFile.setCompressedStorePath(compressStorePath);

		return m_imageService.insert(m_upload, m_uploadFile, Image.PRODUCT, Image.PRODUCT_WIDTH, Image.PRODUCT_HEIGHT,
		      true, Image.PRODUCT_SMALL_WIDTH, Image.PRODUCT_SMALL_HEIGHT);

	}

	public String productList() {
		try {
			m_productCategorys = m_productCategoryService.queryProductCategoryByType(m_type);
			int totalSize = m_productService.queryTotalSize(m_type, m_productCategoryId);

			m_pagedTool.setTotalNumber(totalSize);

			m_products = m_productService.queryPagedProducts(m_pagedTool, m_type, m_productCategoryId);
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String productAdd() {
		m_productCategorys = m_productCategoryService.queryAllProductCategorys();
		return SUCCESS;
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

	public String productAddImageSubmit() {
		try {
			int imageId = insertImage();
			if (imageId > 0) {
				m_productId = m_product.getId();
				ProductImage productImage = new ProductImage();
				productImage.setImageId(imageId);
				productImage.setProductId(m_productId);
				m_productService.insertProductImage(productImage);
			} else {
				addActionError("Upload Image Fail");
				return ERROR;
			}
		} catch (Exception e) {
			addActionError(e.getMessage());
			return ERROR;
		}
		addActionMessage("Upload Success!");
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

	public Product getProduct() {
		return m_product;
	}

	public void setProduct(Product product) {
		m_product = product;
	}

	public void setProductService(ProductService productService) {
		m_productService = productService;
	}

	public List<Product> getProducts() {
		return m_products;
	}

	public void setProductId(int productId) {
		m_productId = productId;
	}

	public void setProductCategoryService(ProductCategoryService productCategoryService) {
		m_productCategoryService = productCategoryService;
	}

	public List<ProductCategory> getProductCategorys() {
		return m_productCategorys;
	}

	public int getProductId() {
		return m_productId;
	}

	public void setUpload(File file) {
		m_upload = file;
	}

	public void setUploadFileName(String filename) {
		m_uploadFile.setFilename(filename);
	}

	public void setUploadContentType(String contentType) {
		m_uploadFile.setContentType(contentType);
	}

	public void setImageService(ImageService imageService) {
		m_imageService = imageService;
	}

	public void setImageId(int imageId) {
		m_imageId = imageId;
	}

	public int getType() {
		return m_type;
	}

	public void setType(int type) {
		m_type = type;
	}

	public int getProductCategoryId() {
		return m_productCategoryId;
	}

	public void setProductCategoryId(int productCategoryId) {
		m_productCategoryId = productCategoryId;
	}

	public void setIndex(int index) {
		m_pagedTool.setPageIndex(index);
	}

	public PagedTool getPagedTool() {
		return m_pagedTool;
	}

	public void setPagedTool(PagedTool pagedTool) {
		m_pagedTool = pagedTool;
	}
}