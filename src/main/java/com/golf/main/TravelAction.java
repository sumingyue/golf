package com.golf.main;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.golf.entity.Court;
import com.golf.entity.CourtImage;
import com.golf.entity.Travel;
import com.golf.entity.TravelCourt;
import com.golf.entity.TravelHotel;
import com.golf.entity.TravelHotelImage;
import com.golf.entity.TravelLog;
import com.golf.entity.TravelPlan;
import com.golf.service.CourtImageService;
import com.golf.service.CourtService;
import com.golf.service.ImageService;
import com.golf.service.TravelCourtService;
import com.golf.service.TravelHotelImageService;
import com.golf.service.TravelHotelService;
import com.golf.service.TravelLogService;
import com.golf.service.TravelPlanService;
import com.golf.service.TravelService;
import com.opensymphony.xwork2.ActionSupport;

public class TravelAction extends ActionSupport {

	private static final long serialVersionUID = 2801256599554299998L;

	private Logger m_logger = Logger.getLogger(TravelAction.class);

	private List<Travel> m_travels;

	private int m_travelId;

	private TravelService m_travelService;

	private TravelHotelService m_travelHotelService;

	private TravelCourtService m_travelCourtService;

	private TravelLogService m_travelLogService;

	private TravelHotelImageService m_travelHotelImageService;

	private ImageService m_imageService;

	private List<TravelHotelImage> m_hotelImages;

	private List<TravelHotel> m_travelHotels;

	private List<TravelPlan> m_travelPlans;

	private List<TravelLog> m_travelLogs;

	private TravelPlanService m_travelPlanService;

	private Travel m_travel = new Travel();

	private List<Court> m_courts;

	private CourtService m_courtService;

	private CourtImageService m_courtImageService;

	private List<CourtImage> m_courtImages = new ArrayList<CourtImage>();

	private Integer[] m_courtSelected = new Integer[100];

	private int m_travelLogId;

	private TravelLog m_travelLog;

	public Travel getTravel() {
		return m_travel;
	}

	public List<Travel> getTravels() {
		return m_travels;
	}

	public String travelList() {
		try {
			// m_pagedTool.setTotalNumber(m_travelService.queryAllTravels().size());
			// m_travels = m_travelService.queryPagedTravels(m_pagedTool);
			m_travels = m_travelService.queryAllTravels();
			m_travelLogs =m_travelLogService.queryAllTravelLogs();
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String travelLog() {
		m_travelLog = m_travelLogService.findTravelLog(m_travelLogId);
		if (m_travelLog != null) {
			m_travelLog.setTravel(m_travelService.findTravel(m_travelLog.getTravelId()));
		}
		return SUCCESS;
	}

	public String travelDetail() {
		try {
			m_courts = new ArrayList<Court>();
			m_travel = m_travelService.findTravel(m_travelId);
			m_travelPlans = m_travelPlanService.queryAllTravelPlans(m_travelId);
			m_travelLogs = m_travelLogService.queryTravelLogByTravelId(m_travelId);
			List<TravelCourt> courts = m_travelCourtService.queryAllByTravelId(m_travel.getId());

			for (TravelCourt temp : courts) {
				m_courts.add(m_courtService.findCourt(temp.getCourtId()));
			}

			m_travel.setTravelHotel(m_travelHotelService.findTravelHotel(m_travel.getTravelHotelId()));

			m_hotelImages = m_travelHotelImageService.queryAllTravelHotelImages(m_travel.getTravelHotelId());
			if (m_hotelImages != null) {
				for (TravelHotelImage temp : m_hotelImages) {
					temp.setImage(m_imageService.findImage(temp.getImageId()));
					temp.setTravelHotel(m_travelHotelService.findTravelHotel(temp.getTravelHotelId()));
				}
			}

			for (Court court : m_courts) {
				List<CourtImage> courtImage = m_courtImageService.queryAllCourtImages(court.getId());

				if (courtImage != null) {
					for (CourtImage temp : courtImage) {
						temp.setCourt(court);
						temp.setImage(m_imageService.findImage(temp.getImageId()));
					}
					m_courtImages.addAll(courtImage);
				}
			}
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public void setId(int id) {
		m_travelId = id;
		m_travelLogId = id;
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

	public void setTravelLogService(TravelLogService travelLogService) {
		m_travelLogService = travelLogService;
	}

	public List<TravelLog> getTravelLogs() {
		return m_travelLogs;
	}

	public void setImageService(ImageService imageService) {
		m_imageService = imageService;
	}

	public void setTravelHotelImageService(TravelHotelImageService travelHotelImageService) {
		m_travelHotelImageService = travelHotelImageService;
	}

	public void setLogger(Logger logger) {
		m_logger = logger;
	}

	public void setCourtImageService(CourtImageService courtImageService) {
		m_courtImageService = courtImageService;
	}

	public void setCourtImages(List<CourtImage> courtImages) {
		m_courtImages = courtImages;
	}

	public List<TravelHotelImage> getHotelImages() {
		return m_hotelImages;
	}

	public List<CourtImage> getCourtImages() {
		return m_courtImages;
	}

	public TravelLog getTravelLog() {
		return m_travelLog;
	}

}