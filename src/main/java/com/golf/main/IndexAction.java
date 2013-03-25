package com.golf.main;

import java.util.ArrayList;
import java.util.List;

import com.golf.Config;
import com.golf.entity.Category;
import com.golf.entity.Court;
import com.golf.entity.CourtImage;
import com.golf.entity.ImageSpecial;
import com.golf.entity.Media;
import com.golf.entity.News;
import com.golf.entity.Player;
import com.golf.entity.SmallCategory;
import com.golf.entity.SpecialNews;
import com.golf.entity.TeamNews;
import com.golf.service.AdwordsService;
import com.golf.service.CategoryService;
import com.golf.service.CourtImageService;
import com.golf.service.CourtService;
import com.golf.service.ImageService;
import com.golf.service.ImageSpecialService;
import com.golf.service.MediaService;
import com.golf.service.NewsService;
import com.golf.service.PlayerService;
import com.golf.service.SpecialNewsService;
import com.golf.service.TeamNewsService;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {

	private static final long serialVersionUID = 2801256589554299998L;

	private PlayerService m_playerService;

	private NewsService m_newsService;

	private MediaService m_mediaService;

	private ImageService m_imageService;

	private ImageSpecialService m_imageSpecialService;

	private CategoryService m_categoryService;

	private List<ImageSpecial> m_imageSpecials;

	private List<Media> m_youQingMedias = new ArrayList<Media>();

	private List<Media> m_heZuoMedias = new ArrayList<Media>();

	private CourtService m_courtService;

	private CourtImage m_courtImage;

	private CourtImageService m_courtImageService;

	private Court m_court;

	private List<Court> m_courts;

	private SpecialNewsService m_specialNewsService;

	private AdwordsService m_adwordsService;

	private TeamNewsService m_teamNewsService;

	private List<TeamNews> m_teamNews;

	private List<Player> m_jiangJinPlayers;

	private List<Player> m_jiFenPlayers;

	private List<TeamNews> m_qiuDuiHuoDongs;

	private News m_lianXiChang;

	private List<SpecialNews> m_specialNews;

	private NewsGroup m_newsZongHe;

	private NewsGroup m_newsSaiShi;

	private NewsGroup m_newsLvYou;

	private NewsGroup m_newsPingLun;

	private NewsGroup m_newsXueYuan;

	private NewsGroup m_newsZiXun;

	private NewsGroup buildNewsByCategoryId(int categoryId, int imageNewSize) {
		NewsGroup temp = new NewsGroup();
		List<News> hotNews = m_newsService.queryFixedNewsByCategoryId(10, categoryId);
		List<News> imageNews = m_newsService.queryFixedImageNewsByCategoryId(imageNewSize, categoryId);

		if (imageNews != null) {
			for (News n : imageNews) {
				n.setImage(m_imageService.findImage(n.getImageId()));
			}
		}
		temp.setFirstNews(hotNews.get(0));
		temp.setSecondNews(hotNews.subList(1, 5));
		temp.setThirdNews(hotNews.subList(5, 10));
		temp.setImageNews(imageNews);

		List<SmallCategory> categorys = m_categoryService
		      .queryAllSmallCategoryByTypeCategoryId(Category.NEWS, categoryId);

		for (int i = 0; i < categorys.size(); i++) {
			SmallCategory smallCategory = categorys.get(i);
			List<News> lastestNews = m_newsService.queryFixedNewsBySmallCategoryId(9, smallCategory.getId());

			temp.setSmallCategoryNews(i + 1, smallCategory, lastestNews);
		}
		return temp;
	}

	@Override
	public String execute() throws Exception {
		m_newsZongHe = buildNewsByCategoryId(Config.CATE_ZongHe, 3);
		m_newsSaiShi = buildNewsByCategoryId(Config.CATE_SaiShi, 3);
		m_newsLvYou = buildNewsByCategoryId(Config.CATE_LvYou, 3);
		m_newsPingLun = buildNewsByCategoryId(Config.CATE_PingLun, 3);
		m_newsXueYuan = buildNewsByCategoryId(Config.CATE_XueYuan, 3);
		m_newsZiXun = buildNewsByCategoryId(Config.CATE_ZiXun, 3);

		queryOther();
		queryMedia();
		queryPlayer();
		return SUCCESS;
	}

	public AdwordsService getAdwordsService() {
		return m_adwordsService;
	}

	public Court getCourt() {
		return m_court;
	}

	public CourtImage getCourtImage() {
		return m_courtImage;
	}

	public List<Court> getCourts() {
		return m_courts;
	}

	public List<Media> getHeZuoMedias() {
		return m_heZuoMedias;
	}

	public List<ImageSpecial> getImageSpecials() {
		return m_imageSpecials;
	}

	public List<Player> getJiangJinPlayers() {
		return m_jiangJinPlayers;
	}

	public List<Player> getJiFenPlayers() {
		return m_jiFenPlayers;
	}

	public News getLianXiChang() {
		return m_lianXiChang;
	}

	public NewsGroup getNewsLvYou() {
		return m_newsLvYou;
	}

	public NewsGroup getNewsPingLun() {
		return m_newsPingLun;
	}

	public NewsGroup getNewsSaiShi() {
		return m_newsSaiShi;
	}

	public NewsGroup getNewsXueYuan() {
		return m_newsXueYuan;
	}

	public NewsGroup getNewsZiXun() {
		return m_newsZiXun;
	}

	public NewsGroup getNewsZongHe() {
		return m_newsZongHe;
	}

	public List<TeamNews> getQiuDuiHuoDongs() {
		return m_qiuDuiHuoDongs;
	}

	public List<SpecialNews> getSpecialNews() {
		return m_specialNews;
	}

	public List<TeamNews> getTeamNews() {
		return m_teamNews;
	}

	public List<Media> getYouQingMedias() {
		return m_youQingMedias;
	}

	private void queryMedia() {
		List<Media> all = m_mediaService.queryAllMedias();

		for (Media temp : all) {
			if (temp.getType().equalsIgnoreCase(Config.YouQingLianJie)) {
				m_youQingMedias.add(temp);
			} else {
				m_heZuoMedias.add(temp);
			}
		}
	}

	private void queryOther() {
		m_imageSpecials = m_imageSpecialService.queryFixedImageSpecials(2);
		if (m_imageSpecials != null) {
			for (ImageSpecial temp : m_imageSpecials) {
				temp.setImage(m_imageService.findImage(temp.getImageId()));
			}
		}

		m_specialNews = m_specialNewsService.queryLastestSpecialNews(6);
		m_teamNews = m_teamNewsService.queryFixedTeamNewss(12);

		List<Court> all = m_courtService.queryFixedCourts(6);
		m_court = all.get(0);
		m_courts = all.subList(1, 6);

		List<CourtImage> images = m_courtImageService.queryAllCourtImages(m_court.getId());
		if (images != null && images.size() > 0) {
			m_courtImage = images.get(0);
			m_courtImage.setImage(m_imageService.findImage(m_courtImage.getImageId()));
		}
	}

	private void queryPlayer() {
		m_jiangJinPlayers = m_playerService.queryPlayers("bonus", 6);
		m_jiFenPlayers = m_playerService.queryPlayers("score", 6);
	}

	public void setAdwordsService(AdwordsService adwordsService) {
		m_adwordsService = adwordsService;
	}

	public void setCategoryService(CategoryService cateogryService) {
		m_categoryService = cateogryService;
	}

	public void setCourtImageService(CourtImageService courtImageService) {
		m_courtImageService = courtImageService;
	}

	public void setCourtService(CourtService courtService) {
		m_courtService = courtService;
	}

	public void setImageService(ImageService imageService) {
		m_imageService = imageService;
	}

	public void setImageSpecialService(ImageSpecialService imageSpecialService) {
		m_imageSpecialService = imageSpecialService;
	}

	public void setMediaService(MediaService mediaService) {
		m_mediaService = mediaService;
	}

	public void setNewsService(NewsService newsService) {
		m_newsService = newsService;
	}

	public void setPlayerService(PlayerService playerService) {
		m_playerService = playerService;
	}

	public void setSpecialNewsService(SpecialNewsService specialNewsService) {
		m_specialNewsService = specialNewsService;
	}

	public void setTeamNewsService(TeamNewsService teamNewsService) {
		m_teamNewsService = teamNewsService;
	}

	public static class NewsGroup {
		private News m_firstNews;

		private List<News> m_secondNews;

		private List<News> m_thirdNews;

		private List<News> m_imageNews;

		private SmallCategory m_smallCategory1;

		private SmallCategory m_smallCategory2;

		private SmallCategory m_smallCategory3;

		private SmallCategory m_smallCategory4;

		private SmallCategory m_smallCategory5;

		private SmallCategory m_smallCategory6;
		
		private SmallCategory m_smallCategory7;

		private SmallCategory m_smallCategory8;

		private SmallCategory m_smallCategory9;

		private List<News> m_smallCategoryNews1;

		private List<News> m_smallCategoryNews2;

		private List<News> m_smallCategoryNews3;

		private List<News> m_smallCategoryNews4;

		private List<News> m_smallCategoryNews5;

		private List<News> m_smallCategoryNews6;
		
		private List<News> m_smallCategoryNews7;

		private List<News> m_smallCategoryNews8;

		private List<News> m_smallCategoryNews9;

		public News getFirstNews() {
			return m_firstNews;
		}

		public List<News> getImageNews() {
			return m_imageNews;
		}

		public List<News> getSecondNews() {
			return m_secondNews;
		}

		public SmallCategory getSmallCategory1() {
			return m_smallCategory1;
		}

		public SmallCategory getSmallCategory2() {
			return m_smallCategory2;
		}

		public SmallCategory getSmallCategory3() {
			return m_smallCategory3;
		}

		public SmallCategory getSmallCategory4() {
			return m_smallCategory4;
		}

		public SmallCategory getSmallCategory5() {
			return m_smallCategory5;
		}

		public SmallCategory getSmallCategory6() {
			return m_smallCategory6;
		}

		public SmallCategory getSmallCategory7() {
			return m_smallCategory7;
		}

		public SmallCategory getSmallCategory8() {
			return m_smallCategory8;
		}

		public SmallCategory getSmallCategory9() {
			return m_smallCategory9;
		}

		public List<News> getSmallCategoryNews1() {
			return m_smallCategoryNews1;
		}

		public List<News> getSmallCategoryNews2() {
			return m_smallCategoryNews2;
		}

		public List<News> getSmallCategoryNews3() {
			return m_smallCategoryNews3;
		}

		public List<News> getSmallCategoryNews4() {
			return m_smallCategoryNews4;
		}

		public List<News> getSmallCategoryNews5() {
			return m_smallCategoryNews5;
		}

		public List<News> getSmallCategoryNews6() {
			return m_smallCategoryNews6;
		}

		public List<News> getSmallCategoryNews7() {
			return m_smallCategoryNews7;
		}

		public List<News> getSmallCategoryNews8() {
			return m_smallCategoryNews8;
		}

		public List<News> getSmallCategoryNews9() {
			return m_smallCategoryNews9;
		}

		public List<News> getThirdNews() {
			return m_thirdNews;
		}

		public void setFirstNews(News firstNews) {
			m_firstNews = firstNews;
		}

		public void setImageNews(List<News> imageNews) {
			m_imageNews = imageNews;
		}

		public void setSecondNews(List<News> secondNews) {
			m_secondNews = secondNews;
		}

		public void setSmallCategoryNews(int index, SmallCategory smallCategory, List<News> news) {
			if (index == 1) {
				m_smallCategoryNews1 = news;
				m_smallCategory1 = smallCategory;
			} else if (index == 2) {
				m_smallCategoryNews2 = news;
				m_smallCategory2 = smallCategory;
			} else if (index == 3) {
				m_smallCategoryNews3 = news;
				m_smallCategory3 = smallCategory;
			} else if (index == 4) {
				m_smallCategoryNews4 = news;
				m_smallCategory4 = smallCategory;
			} else if (index == 5) {
				m_smallCategoryNews5 = news;
				m_smallCategory5 = smallCategory;
			} else if (index == 6) {
				m_smallCategoryNews6 = news;
				m_smallCategory6 = smallCategory;
			}else if (index == 7) {
				m_smallCategoryNews7 = news;
				m_smallCategory7 = smallCategory;
			}else if (index == 8) {
				m_smallCategoryNews8 = news;
				m_smallCategory8 = smallCategory;
			}else if (index == 9) {
				m_smallCategoryNews9 = news;
				m_smallCategory9 = smallCategory;
			}
		}

		public void setSmallCategoryNews1(List<News> smallCategoryNews1) {
			m_smallCategoryNews1 = smallCategoryNews1;
		}

		public void setSmallCategoryNews2(List<News> smallCategoryNews2) {
			m_smallCategoryNews2 = smallCategoryNews2;
		}

		public void setSmallCategoryNews3(List<News> smallCategoryNews3) {
			m_smallCategoryNews3 = smallCategoryNews3;
		}

		public void setSmallCategoryNews4(List<News> smallCategoryNews4) {
			m_smallCategoryNews4 = smallCategoryNews4;
		}

		public void setSmallCategoryNews5(List<News> smallCategoryNews5) {
			m_smallCategoryNews5 = smallCategoryNews5;
		}

		public void setSmallCategoryNews6(List<News> smallCategoryNews6) {
			m_smallCategoryNews6 = smallCategoryNews6;
		}

		public void setThirdNews(List<News> thirdNews) {
			m_thirdNews = thirdNews;
		}

	}

}