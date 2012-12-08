package com.golf.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.golf.entity.Court;
import com.golf.entity.CourtComments;
import com.golf.entity.CourtImage;
import com.golf.entity.CourtRaider;
import com.golf.service.AdwordsService;
import com.golf.service.CourtCommentsService;
import com.golf.service.CourtImageService;
import com.golf.service.CourtRaiderService;
import com.golf.service.CourtService;
import com.golf.service.ImageService;
import com.opensymphony.xwork2.ActionSupport;

public class CourtAction extends ActionSupport {

	private static final long serialVersionUID = -3076207530005562704L;

	private int m_courtId;

	private Court m_court;

	private CourtComments m_comments = new CourtComments();

	private CourtService m_courtService;

	private CourtCommentsService m_courtCommentsService;

	private CourtImageService m_courtImageService;

	private CourtRaiderService m_courtRaiderService;

	private ImageService m_imageService;

	private List<CourtComments> m_courtComments;

	private List<CourtImage> m_courtImages;

	private Map<String, RaiderGroup> m_groups = new LinkedHashMap<String, RaiderGroup>();

	private List<CourtRaider> m_all;

	@Override
	public String execute() throws Exception {
		m_court = m_courtService.findCourt(m_courtId);
		m_court.setMapImage(m_imageService.findImage(m_court.getMapImageId()));
		m_courtComments = m_courtCommentsService.queryAllCourtCommentss(m_courtId);
		m_courtImages = m_courtImageService.queryAllCourtImages(m_courtId);
		for (CourtImage temp : m_courtImages) {
			temp.setImage(m_imageService.findImage(temp.getImageId()));
		}

		m_all = m_courtRaiderService.queryAllCourtRaiders(m_courtId);

		for (CourtRaider temp : m_all) {
			String group = temp.getName();
			String index = temp.getIndexName();
			int imageId = temp.getImageId();
			temp.setImage(m_imageService.findImage(imageId));

			RaiderGroup raiderGroup = m_groups.get(group);
			if (raiderGroup == null) {
				raiderGroup = new RaiderGroup();
				raiderGroup.setName(group);
				m_groups.put(group, raiderGroup);
			}
			raiderGroup.getIndex().add(index);
		}
		return SUCCESS;
	}

	public String addComment() {
		m_courtCommentsService.insertCourtComments(m_comments);
		m_courtId = m_comments.getCourtId();
		return SUCCESS;
	}

	public Court getCourt() {
		return m_court;
	}

	public void setId(int courtId) {
		m_courtId = courtId;
	}

	public void setCourtId(int courtId) {
		m_courtId = courtId;
	}

	public void setCourtService(CourtService courtService) {
		m_courtService = courtService;
	}

	public void setCourtCommentsService(CourtCommentsService courtCommentsService) {
		m_courtCommentsService = courtCommentsService;
	}

	public void setCourtImageService(CourtImageService courtImageService) {
		m_courtImageService = courtImageService;
	}

	public void setCourtRaiderService(CourtRaiderService courtRaiderService) {
		m_courtRaiderService = courtRaiderService;
	}

	public CourtComments getComments() {
		return m_comments;
	}

	public List<CourtComments> getCourtComments() {
		return m_courtComments;
	}

	public List<CourtImage> getCourtImages() {
		return m_courtImages;
	}

	public void setImageService(ImageService imageService) {
		m_imageService = imageService;
	}

	public List<CourtRaider> getAll() {
		return m_all;
	}

	public List<RaiderGroup> getGroups() {
		Collection<RaiderGroup> values = m_groups.values();
		List<RaiderGroup> result = new ArrayList<RaiderGroup>(values);
		Collections.sort(result, new RadierGroupCompartor());
		return result;
	}

	private AdwordsService m_adwordsService;

	public void setAdwordsService(AdwordsService adwordsService) {
		m_adwordsService = adwordsService;
	}

	public AdwordsService getAdwordsService() {
		return m_adwordsService;
	}

	public int getCourtId() {
		return m_courtId;
	}

	public static class RadierGroupCompartor implements Comparator<RaiderGroup> {

		@Override
		public int compare(RaiderGroup o1, RaiderGroup o2) {
			return o1.getName().compareTo(o2.getName());
		}
	}

	public static class RaiderGroup {
		private String m_name;

		private List<String> m_index = new ArrayList<String>();

		public String getName() {
			return m_name;
		}

		public void setName(String name) {
			m_name = name;
		}

		public List<String> getIndex() {
			return m_index;
		}

		public void setIndex(List<String> index) {
			m_index = index;
		}
	}

}
