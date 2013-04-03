package com.golf.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.golf.Config;
import com.golf.entity.ProductCategory;
import com.golf.service.ProductCategoryService;
import com.golf.tools.PagedTool;
import com.opensymphony.xwork2.ActionSupport;

public class ProductCategoryAction extends ActionSupport {

	private static final long serialVersionUID = 2801256599554299998L;

	private Logger m_logger = Logger.getLogger(ProductCategoryAction.class);

	private List<ProductCategory> m_productCategorys;

	private int m_productCategoryId;

	private ProductCategoryService m_productCategoryService;

	private ProductCategory m_productCategory = new ProductCategory();
	
	private PagedTool m_pagedTool = new PagedTool(Config.DEFAULT_PAGE_NUMBER);

	public PagedTool getPagedTool() {
		return m_pagedTool;
	}

	public ProductCategory getProductCategory() {
		return m_productCategory;
	}

	public List<ProductCategory> getProductCategorys() {
		return m_productCategorys;
	}

	public String productCategoryAddSubmit() {
		try {
			int id = m_productCategoryService.insertProductCategory(m_productCategory);
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

	public String productCategoryDelete() {
		try {
			int count = m_productCategoryService.deleteProductCategory(m_productCategoryId);
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

	public String productCategoryList() {
		try {
			//m_pagedTool.setTotalNumber(m_productCategoryService.queryAllProductCategorys().size());
			//m_productCategorys = m_productCategoryService.queryPagedProductCategorys(m_pagedTool);

			m_productCategorys = m_productCategoryService.queryAllProductCategorys();
			
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String productCategoryUpdate() {
		try {
			m_productCategory = m_productCategoryService.findProductCategory(m_productCategoryId);
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String productCategoryUpdateSubmit() {
		try {
			int count = m_productCategoryService.updateProductCategory(m_productCategory);
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

	public void setIndex(int index){
		m_pagedTool.setPageIndex(index);
	}

	public void setPagedTool(PagedTool pagedTool) {
		m_pagedTool = pagedTool;
	}
	public void setProductCategory(ProductCategory productCategory) {
		m_productCategory = productCategory;
	}

	public void setProductCategoryId(int productCategoryId) {
		m_productCategoryId = productCategoryId;
	}

	public void setProductCategoryService(ProductCategoryService productCategoryService) {
		m_productCategoryService = productCategoryService;
	}
}