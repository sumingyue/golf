package com.golf.main;

import java.util.List;

import com.golf.Config;
import com.golf.entity.Image;
import com.golf.entity.News;
import com.golf.entity.TeamNews;
import com.golf.service.AdwordsService;
import com.golf.service.CategoryService;
import com.golf.service.ImageService;
import com.golf.service.MediaService;
import com.golf.service.NewsService;
import com.golf.service.PlayerService;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {

	private static final long serialVersionUID = 2801256589554299998L;

	private PlayerService m_playerService;

	private NewsService m_newsService;

	private MediaService m_mediaService;

	private ImageService m_imageService;

	private CategoryService m_categoryService;

	private AdwordsService m_adwordsService;

	private News m_firstHot;

	private List<News> m_firstHots;

	private List<News> m_secondHots;

	private News m_firstMatch;

	private List<News> m_firstMatchs;

	private List<News> m_secondMatchs;

	private List<News> m_huoDongZiXun;

	private List<News> m_youHuiXinXi;

	private List<News> m_renCaiQiuGong;

	private List<News> m_benDiShiShang;

	private List<News> m_sheHuiReDian;

	private List<News> m_zongHeZiXun;

	private List<TeamNews> m_qiuDuiHuoDong;

	private List<News> m_lvYouImages;

	private List<News> m_lvYous;

	private List<News> m_renWuImages;

	private List<News> m_renWus;

	private List<News> m_dongTai;

	private List<News> m_qiuJie;

	private List<News> m_xieHuis;
	
	private List<News> m_pinLun;

	private void queryShouYe() {
		m_dongTai = m_newsService.queryNewsByCategoryId(8, Config.RenWu_DongTai);
		m_qiuJie = m_newsService.queryNewsByCategoryId(8, Config.RenWu_GuShi);
		m_xieHuis = m_newsService.queryNewsByCategoryId(8, Config.RenWu_XiuHui);
		m_pinLun =m_newsService.queryNewsByCategoryId(8,Config.RenWu_PingLun);
	}

	private void queryLvYou() {
		m_lvYouImages = m_newsService.queryImageNewsByCategoryId(2, Config.CATE_LvYou);
		m_lvYous = m_newsService.queryImageNewsByCategoryId(8, Config.CATE_LvYou);

		m_renWuImages = m_newsService.queryImageNewsByCategoryId(2, Config.CATE_RenWu);
		m_renWus = m_newsService.queryImageNewsByCategoryId(8, Config.CATE_RenWu);
		
	}

	private void querySaiShi() {
		// 赛事新闻
		List<News> matchNews = m_newsService.queryNewsByCategoryId(11, Config.CATE_SaiShi);
		m_firstMatch = matchNews.get(0);
		m_firstMatchs = matchNews.subList(1, 5);
		m_secondMatchs = matchNews.subList(5, 11);
	}

	private void queryHotNews() {
		// 热点新闻
		List<News> hostNews = m_newsService.queryHotNews(11);
		m_firstHot = hostNews.get(0);
		m_firstHots = hostNews.subList(1, 5);
		m_secondHots = hostNews.subList(5, 11);
	}

	private void queryOther() {
		// 球场资讯
		m_huoDongZiXun = m_newsService.queryNewsBySmallCategoryId(8, Config.QiuChang_HuoDong);
		m_youHuiXinXi = m_newsService.queryNewsBySmallCategoryId(8, Config.QiuChang_YouHui);
		m_renCaiQiuGong = m_newsService.queryNewsBySmallCategoryId(8, Config.QiuChang_RenCai);

		// 场外资讯
		m_benDiShiShang = m_newsService.queryNewsBySmallCategoryId(8, Config.ChangWai_BenDi);
		m_sheHuiReDian = m_newsService.queryNewsBySmallCategoryId(8, Config.ChangWai_PinWei);
		m_zongHeZiXun = m_newsService.queryNewsBySmallCategoryId(8, Config.ChangWai_ZongHe);
	}

	@Override
	public String execute() throws Exception {
		queryHotNews();
		querySaiShi();
		queryShouYe();
		queryOther();
		queryLvYou();

		return SUCCESS;
	}

	public void setPlayerService(PlayerService playerService) {
		m_playerService = playerService;
	}

	public void setNewsService(NewsService newsService) {
		m_newsService = newsService;
	}

	public void setMediaService(MediaService mediaService) {
		m_mediaService = mediaService;
	}

	public void setImageService(ImageService imageService) {
		m_imageService = imageService;
	}

	public void setCategoryService(CategoryService categoryService) {
		m_categoryService = categoryService;
	}

	public void setAdwordsService(AdwordsService adwordsService) {
		m_adwordsService = adwordsService;
	}

	public News getFirstHot() {
		return m_firstHot;
	}

	public List<News> getFirstHots() {
		return m_firstHots;
	}

	public List<News> getSecondHots() {
		return m_secondHots;
	}

	public News getFirstMatch() {
		return m_firstMatch;
	}

	public List<News> getFirstMatchs() {
		return m_firstMatchs;
	}

	public List<News> getSecondMatchs() {
		return m_secondMatchs;
	}

	public List<News> getHuoDongZiXun() {
		return m_huoDongZiXun;
	}

	public List<News> getYouHuiXinXi() {
		return m_youHuiXinXi;
	}

	public List<News> getRenCaiQiuGong() {
		return m_renCaiQiuGong;
	}

	public List<News> getBenDiShiShang() {
		return m_benDiShiShang;
	}

	public List<News> getSheHuiReDian() {
		return m_sheHuiReDian;
	}

	public List<News> getZongHeZiXun() {
		return m_zongHeZiXun;
	}

	public List<TeamNews> getQiuDuiHuoDong() {
		return m_qiuDuiHuoDong;
	}

	public List<News> getLvYouImages() {
		return m_lvYouImages;
	}

	public List<News> getLvYous() {
		return m_lvYous;
	}

	public List<News> getRenWuImages() {
		return m_renWuImages;
	}

	public List<News> getRenWus() {
		return m_renWus;
	}

	public List<News> getDongTai() {
		return m_dongTai;
	}

	public List<News> getQiuJie() {
		return m_qiuJie;
	}

	public List<News> getXieHuis() {
		return m_xieHuis;
	}

	public List<News> getPinLun() {
		return m_pinLun;
	}
	
}