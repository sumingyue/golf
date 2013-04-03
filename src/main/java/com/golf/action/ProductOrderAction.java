package com.golf.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.golf.Config;
import com.golf.entity.ProductOrder;
import com.golf.service.ProductOrderService;
import com.golf.tools.PagedTool;
import com.opensymphony.xwork2.ActionSupport;

public class ProductOrderAction extends ActionSupport {

	private static final long serialVersionUID = 2801256599554299998L;

	private Logger m_logger = Logger.getLogger(ProductOrderAction.class);

	private List<ProductOrder> m_productOrders;

	private int m_productOrderId;

	private ProductOrderService m_productOrderService;

	private ProductOrder m_productOrder = new ProductOrder();

	private PagedTool m_pagedTool = new PagedTool(Config.DEFAULT_PAGE_NUMBER);

	public PagedTool getPagedTool() {
		return m_pagedTool;
	}

	public ProductOrder getProductOrder() {
		return m_productOrder;
	}

	public List<ProductOrder> getProductOrders() {
		return m_productOrders;
	}

	public String productOrderAddSubmit() {
		try {
			int id = m_productOrderService.insertProductOrder(m_productOrder);
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

	public String productOrderDelete() {
		try {
			int count = m_productOrderService.deleteProductOrder(m_productOrderId);
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

	public String productOrderList() {
		try {
//			m_pagedTool.setTotalNumber(m_productOrderService.queryAllProductOrders().size());
//			m_productOrders = m_productOrderService.queryPagedProductOrders(m_pagedTool);
//			
			m_productOrders = m_productOrderService.queryAllProductOrders();
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String productOrderUpdate() {
		try {
			m_productOrder = m_productOrderService.findProductOrder(m_productOrderId);
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String productOrderUpdateSubmit() {
		try {
			int count = m_productOrderService.updateProductOrder(m_productOrder);
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
	public void setProductOrder(ProductOrder productOrder) {
		m_productOrder = productOrder;
	}

	public void setProductOrderId(int productOrderId) {
		m_productOrderId = productOrderId;
	}

	public void setProductOrderService(ProductOrderService productOrderService) {
		m_productOrderService = productOrderService;
	}
}