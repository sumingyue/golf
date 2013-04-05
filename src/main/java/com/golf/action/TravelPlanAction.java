package com.golf.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.golf.Config;
import com.golf.entity.Travel;
import com.golf.entity.TravelPlan;
import com.golf.service.TravelPlanService;
import com.golf.service.TravelService;
import com.golf.tools.PagedTool;
import com.opensymphony.xwork2.ActionSupport;

public class TravelPlanAction extends ActionSupport {

	private static final long serialVersionUID = 2801256599554299998L;

	private static final String LIST = "travelPlanList.do";

	private Logger m_logger = Logger.getLogger(TravelPlanAction.class);

	private List<TravelPlan> m_travelPlans;

	private int m_travelPlanId;

	private TravelService m_travelService;

	private List<Travel> m_travels;

	private int m_travelId;

	private TravelPlanService m_travelPlanService;

	private TravelPlan m_travelPlan = new TravelPlan();

	private String[] m_names = new String[5];

	private String[] m_contents = new String[5];

	private String[] m_des = new String[5];

	private PagedTool m_pagedTool = new PagedTool(Config.DEFAULT_PAGE_NUMBER);

	public String getActionList() {
		return LIST;
	}

	public PagedTool getPagedTool() {
		return m_pagedTool;
	}

	public int getTravelId() {
		return m_travelId;
	}

	public TravelPlan getTravelPlan() {
		return m_travelPlan;
	}

	public List<TravelPlan> getTravelPlans() {
		return m_travelPlans;
	}

	public List<Travel> getTravels() {
		return m_travels;
	}

	public void setDes(String[] des) {
		m_des = des;
	}

	public void setNames(String[] names) {
		m_names = names;
	}

	public void setContents(String[] contents) {
		m_contents = contents;
	}

	public void setIndex(int index) {
		m_pagedTool.setPageIndex(index);
	}

	public void setPagedTool(PagedTool pagedTool) {
		m_pagedTool = pagedTool;
	}

	public void setTravelId(int travelId) {
		m_travelId = travelId;
	}

	public void setTravelPlan(TravelPlan travelPlan) {
		m_travelPlan = travelPlan;
	}

	public void setTravelPlanId(int travelPlanId) {
		m_travelPlanId = travelPlanId;
	}

	public void setTravelPlanService(TravelPlanService travelPlanService) {
		m_travelPlanService = travelPlanService;
	}

	public void setTravelService(TravelService travelService) {
		m_travelService = travelService;
	}

	public String travelPlanAdd() {
		m_travels = m_travelService.queryAllTravels();
		return SUCCESS;
	}

	public String travelPlanAddSubmit() {
		int size = m_names.length;

		String result = SUCCESS;

		for (int i = 0; i < size; i++) {
			try {
				String name = m_names[i];
				if (name != null && name.length() > 0) {
					TravelPlan temp = new TravelPlan();
					
					temp.setContent(m_contents[i]);
					temp.setName(m_names[i]);
					temp.setDes(m_des[i]);
					temp.setTravelId(m_travelId);

					int id = m_travelPlanService.insertTravelPlan(temp);

					if (id <= 0) {
						result = ERROR;
					}
				}
			} catch (Exception e) {
				m_logger.error(e);
				result = ERROR;
			}
		}
		return result;
	}

	public String travelPlanDelete() {
		try {
			int count = m_travelPlanService.deleteTravelPlan(m_travelPlanId);
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

	public String travelPlanList() {
		try {
			m_travelPlans = m_travelPlanService.queryAllTravelPlans(0);

			if (m_travelPlans != null) {
				for (TravelPlan plan : m_travelPlans) {
					plan.setTravel(m_travelService.findTravel(plan.getTravelId()));
				}
			}
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String travelPlanUpdate() {
		m_travels = m_travelService.queryAllTravels();
		try {
			m_travelPlan = m_travelPlanService.findTravelPlan(m_travelPlanId);
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String travelPlanUpdateSubmit() {
		try {
			int count = m_travelPlanService.updateTravelPlan(m_travelPlan);
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

}