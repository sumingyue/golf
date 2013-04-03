package com.golf.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.golf.entity.Court;
import com.golf.entity.Travel;
import com.golf.entity.TravelCourt;
import com.golf.entity.TravelHotel;
import com.golf.entity.TravelPlan;
import com.golf.service.CourtService;
import com.golf.service.TravelCourtService;
import com.golf.service.TravelHotelService;
import com.golf.service.TravelPlanService;
import com.golf.service.TravelService;
import com.opensymphony.xwork2.ActionSupport;

public class TravelAction extends ActionSupport {

	private static final long serialVersionUID = 2801256599554299998L;

	private Logger m_logger = Logger.getLogger(TravelAction.class);

	private static final String LIST = "travelList.do";

	private List<Travel> m_travels;

	private int m_travelId;

	private TravelService m_travelService;

	private TravelHotelService m_travelHotelService;

	private TravelCourtService m_travelCourtService;

	private List<TravelHotel> m_travelHotels;
	
	private List<TravelPlan> m_travelPlans;
	
	private TravelPlanService m_travelPlanService;

	private Travel m_travel = new Travel();

	private List<Court> m_courts;

	private CourtService m_courtService;

	private Integer[] m_courtSelected = new Integer[100];

	public String getActionList() {
		return LIST;
	}

	public Travel getTravel() {
		return m_travel;
	}

	public List<Travel> getTravels() {
		return m_travels;
	}

	public String travelAdd() {
		m_courts = m_courtService.queryAllCourts();
		m_travelHotels = m_travelHotelService.queryAllTravelHotels();
		return SUCCESS;
	}

	public String travelAddSubmit() {
		try {
			int id = m_travelService.insertTravel(m_travel);
			for (Integer temp : m_courtSelected) {
				if (temp > 0) {
					int travelId = m_travel.getId();

					TravelCourt travelCourt = new TravelCourt();
					travelCourt.setCourtId(temp);
					travelCourt.setTravelId(travelId);
					m_travelCourtService.insertTravelCourt(travelCourt);
				}
			}

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

	public String travelDelete() {
		try {
			int count = m_travelService.deleteTravel(m_travelId);
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

	public String travelList() {
		try {
			// m_pagedTool.setTotalNumber(m_travelService.queryAllTravels().size());
			// m_travels = m_travelService.queryPagedTravels(m_pagedTool);
			m_travels = m_travelService.queryAllTravels();
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String travelUpdate() {
		try {
			m_courts = m_courtService.queryAllCourts();
			m_travelHotels = m_travelHotelService.queryAllTravelHotels();
			m_travel = m_travelService.findTravel(m_travelId);
			m_travelPlans = m_travelPlanService.queryAllTravelPlans(m_travelId);
			
			List<TravelCourt> courts = m_travelCourtService.queryAllByTravelId(m_travel.getId());
			if (courts != null) {
				for (int i = 0; i < courts.size(); i++) {
					m_courtSelected[i] = courts.get(i).getCourtId();
				}
			}
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String travelUpdateSubmit() {
		try {
			int count = m_travelService.updateTravel(m_travel);

			m_travelCourtService.deleteByTravelId(m_travel.getId());
			for (Integer temp : m_courtSelected) {
				if (temp > 0) {
					int travelId = m_travel.getId();

					TravelCourt travelCourt = new TravelCourt();
					travelCourt.setCourtId(temp);
					travelCourt.setTravelId(travelId);
					m_travelCourtService.insertTravelCourt(travelCourt);
				}
			}

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

	public void setId(int id) {
		m_travelId = id;
	}

	public void setTravel(Travel travel) {
		m_travel = travel;
	}

	public void setTravelId(int travelId) {
		m_travelId = travelId;
	}

	public void setTravelService(TravelService travelService) {
		m_travelService = travelService;
	}

	public void setTravelHotelService(TravelHotelService travelHotelService) {
		m_travelHotelService = travelHotelService;
	}

	public List<TravelHotel> getTravelHotels() {
		return m_travelHotels;
	}

	public List<Court> getCourts() {
		return m_courts;
	}

	public void setCourtService(CourtService courtService) {
		m_courtService = courtService;
	}

	public Integer[] getCourtSelected() {
		return m_courtSelected;
	}

	public void setCourtSelected(Integer[] courtSelected) {
		m_courtSelected = courtSelected;
	}

	public void setTravelCourtService(TravelCourtService travelCourtService) {
		m_travelCourtService = travelCourtService;
	}

	public List<TravelPlan> getTravelPlans() {
		return m_travelPlans;
	}

	public void setTravelPlanService(TravelPlanService travelPlanService) {
		m_travelPlanService = travelPlanService;
	}
	
}