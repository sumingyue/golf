package com.golf.main;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.golf.entity.Category;
import com.golf.entity.Court;
import com.golf.entity.DrivingRange;
import com.golf.entity.ImageSpecial;
import com.golf.entity.LearnClub;
import com.golf.entity.News;
import com.golf.entity.SmallCategory;
import com.golf.entity.Team;
import com.golf.service.CategoryService;
import com.golf.service.CourtService;
import com.golf.service.DrivingRangeService;
import com.golf.service.ImageService;
import com.golf.service.ImageSpecialService;
import com.golf.service.LearnClubService;
import com.golf.service.NewsService;
import com.golf.service.TeamService;
import com.golf.tools.CollectionTool;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {

	private static final long serialVersionUID = 2801256589554299998L;

	private Logger m_logger = Logger.getLogger(IndexAction.class);

	private NewsService m_newsService;

	private ImageService m_imageService;

	private CategoryService m_categoryService;

	private CourtService m_courtService;

	private LearnClubService m_learnClubService;

	private DrivingRangeService m_drivingRangeService;

	private ImageSpecialService m_imageSpecialService;

	private TeamService m_teamService;

	private SmallCategory m_matchCategory;

	private List<ImageSpecial> m_imageSpecials;

	private List<Team> m_teams;

	private List<Court> m_courts;

	private List<LearnClub> m_learnClubs;

	private List<DrivingRange> m_drivingRanges;

	private List<News> m_latestImageNews;

	private List<NewsGroup> m_newsGroups = new ArrayList<NewsGroup>();

	private List<NewsGroup> m_localNewsGroups = new ArrayList<NewsGroup>();

	private List<SmallCategory> m_smallCategories;

	private static final int TEN = 9;

	private void buildNews() {
		m_latestImageNews = m_newsService.queryFixedImageNews(5, 0);

		for (News temp : m_latestImageNews) {
			temp.setImage(m_imageService.findImage(temp.getImageId()));
		}
		List<News> latestNews1 = m_newsService.queryFixedLatestNewsByCategoryId(6, 1);
		List<News> latestNews2 = m_newsService.queryFixedLatestNewsByCategoryId(6, 2);
		List<News> latestNews3 = m_newsService.queryFixedLatestNewsByCategoryId(6, 3);

		m_newsGroups.add(convert(latestNews1));
		m_newsGroups.add(convert(latestNews2));
		m_newsGroups.add(convert(latestNews3));
	}

	private NewsGroup convert(List<News> list) {
		NewsGroup group = new NewsGroup();

		group.setFirsts(list.subList(0, 2));
		group.setSeconds(list.subList(2, 6));
		return group;
	}

	private void buildTeamInfo() {
		m_teams = m_teamService.queryAllTeams();
		for (Team team : m_teams) {
			team.setLogo(m_imageService.findImage(team.getImageId()));
		}
		m_teams = CollectionTool.fixList(m_teams, 6, true);
	}

	private void buildLocalInfo() {
		m_courts = m_courtService.queryAllCourts();
		m_learnClubs = m_learnClubService.queryAllLearnClubs();
		m_drivingRanges = m_drivingRangeService.queryAllDrivingRanges();

		m_courts = CollectionTool.fixList(m_courts, TEN, true);
		m_learnClubs = CollectionTool.fixList(m_learnClubs, TEN, true);
		m_drivingRanges = CollectionTool.fixList(m_drivingRanges, TEN, true);
	}

	private void buildLocalNews() {
		int localNewId = 4;
		m_smallCategories = m_categoryService.queryAllSmallCategoryByTypeCategoryId(Category.NEWS, localNewId);

		for (SmallCategory temp : m_smallCategories) {
			NewsGroup group = new NewsGroup();
			List<News> imageNews = m_newsService.queryFixedImageNews(2, localNewId, temp.getId());
			List<News> detailNews = m_newsService.queryFixedNewsBySmallCategoryId(8, temp.getId());

			for (News news : imageNews) {
				news.setImage(m_imageService.findImage(news.getImageId()));
			}

			group.setFirsts(imageNews);
			group.setSeconds(detailNews);
			m_localNewsGroups.add(group);
		}
	}

	private void buildPics() {
		// For jinxiong golf pic
		int categoryId = 5;
		int smallCategoryId = 0;
		List<SmallCategory> smallCategories = m_categoryService.queryAllSmallCategoryByTypeCategoryId(Category.IMAGE,
		      categoryId);

		if (smallCategories != null) {
			for (SmallCategory temp : smallCategories) {
				if (temp.getId() > smallCategoryId) {
					smallCategoryId = temp.getId();
					m_matchCategory = temp;
				}
			}
		}
		if (smallCategoryId > 0) {
			m_imageSpecials = m_imageSpecialService.queryAllImageSpecials(categoryId, smallCategoryId);
			if (m_imageSpecials != null) {
				for (ImageSpecial temp : m_imageSpecials) {
					temp.setImage(m_imageService.findImage(temp.getImageId()));
				}
			}
			CollectionTool.fixList(m_imageSpecials, 4, true);
		}
	}

	@Override
	public String execute() throws Exception {
		try {
			buildNews();
			buildLocalInfo();
			buildLocalNews();
			buildTeamInfo();
			buildPics();
		} catch (Exception e) {
			m_logger.error(e);
			return ERROR;
		}
		return SUCCESS;
	}

	public List<Court> getCourts() {
		return m_courts;
	}

	public List<LearnClub> getLearnClubs() {
		return m_learnClubs;
	}

	public List<DrivingRange> getDrivingRanges() {
		return m_drivingRanges;
	}

	public void setNewsService(NewsService newsService) {
		m_newsService = newsService;
	}

	public void setImageService(ImageService imageService) {
		m_imageService = imageService;
	}

	public void setCategoryService(CategoryService categoryService) {
		m_categoryService = categoryService;
	}

	public void setCourtService(CourtService courtService) {
		m_courtService = courtService;
	}

	public void setLearnClubService(LearnClubService learnClubService) {
		m_learnClubService = learnClubService;
	}

	public void setDrivingRangeService(DrivingRangeService drivingRangeService) {
		m_drivingRangeService = drivingRangeService;
	}

	public List<News> getLatestImageNews() {
		return m_latestImageNews;
	}

	public List<NewsGroup> getNewsGroups() {
		return m_newsGroups;
	}

	public List<NewsGroup> getLocalNewsGroups() {
		return m_localNewsGroups;
	}

	public List<SmallCategory> getSmallCategories() {
		return m_smallCategories;
	}

	public List<Team> getTeams() {
		return m_teams;
	}

	public void setTeamService(TeamService teamService) {
		m_teamService = teamService;
	}

	public static class NewsGroup {

		private List<News> m_firsts;

		private List<News> m_seconds;

		public List<News> getFirsts() {
			return m_firsts;
		}

		public void setFirsts(List<News> firsts) {
			m_firsts = firsts;
		}

		public List<News> getSeconds() {
			return m_seconds;
		}

		public void setSeconds(List<News> seconds) {
			m_seconds = seconds;
		}
	}

	public List<ImageSpecial> getImageSpecials() {
		return m_imageSpecials;
	}

	public void setImageSpecialService(ImageSpecialService imageSpecialService) {
		m_imageSpecialService = imageSpecialService;
	}

	public SmallCategory getMatchCategory() {
		return m_matchCategory;
	}

}