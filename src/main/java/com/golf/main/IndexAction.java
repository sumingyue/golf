package com.golf.main;

import java.util.ArrayList;
import java.util.List;

import com.golf.Config;
import com.golf.entity.Court;
import com.golf.entity.CourtImage;
import com.golf.entity.ImageSpecial;
import com.golf.entity.Media;
import com.golf.entity.News;
import com.golf.entity.Player;
import com.golf.entity.SpecialNews;
import com.golf.entity.TeamNews;
import com.golf.service.AdwordsService;
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

	private News m_firstJiaoDian;

	private List<News> m_firstJiaoDians;

	private List<News> m_secondJiaoDians;

	private News m_firstSaiShi;

	private List<News> m_firstSaiShis;

	private List<News> m_secondSaiShis;

	private List<News> m_huoDongZiXuns;

	private List<News> m_youHuiXinXis;

	private List<News> m_renCaiQiuGongs;

	private List<News> m_benDiShiShangs;

	private List<News> m_sheHuiReDians;

	private List<News> m_zongHeZiXuns;

	private List<TeamNews> m_qiuDuiHuoDongs;

	private List<News> m_lvYouImages;

	private List<News> m_lvYous;

	private List<News> m_renWuImages;

	private List<News> m_renWus;

	private List<News> m_gaoQiuDongTais;

	private List<News> m_qiuJieGuShis;

	private List<News> m_xieHuiXinWens;

	private List<News> m_guanDianPingLuns;

	private List<News> m_gongQiuXinXis;

	private List<News> m_lianXiChangs;

	private List<News> m_imageNews;

	private List<SpecialNews> m_specialNews;

	private void queryPingLun() {
		m_gaoQiuDongTais = m_newsService.queryFixedNewsByCategoryId(8, Config.RenWu_GaoQiuDongTai);
		m_qiuJieGuShis = m_newsService.queryFixedNewsByCategoryId(8, Config.RenWu_QiuJieGuShi);
		m_xieHuiXinWens = m_newsService.queryFixedNewsByCategoryId(8, Config.RenWu_XieHuiXinWen);
		m_guanDianPingLuns = m_newsService.queryFixedNewsByCategoryId(8, Config.RenWu_GuanDianPingLun);

		m_renWuImages = m_newsService.queryFixedImageNewsByCategoryId(2, Config.CATE_RenWu);
		m_renWus = m_newsService.queryFixedImageNewsByCategoryId(8, Config.CATE_RenWu);
	}

	private void queryLvYou() {
		m_lvYouImages = m_newsService.queryFixedImageNewsByCategoryId(2, Config.CATE_LvYou);
		m_lvYous = m_newsService.queryFixedImageNewsByCategoryId(8, Config.CATE_LvYou);
	}

	private void querySaiShi() {
		// 赛事新闻
		List<News> matchNews = m_newsService.queryFixedNewsByCategoryId(11, Config.CATE_SaiShi);
		m_firstSaiShi = matchNews.get(0);
		m_firstSaiShis = matchNews.subList(1, 5);
		m_secondSaiShis = matchNews.subList(5, 11);
	}

	private void queryJiaoDian() {
		// 热点新闻
		List<News> hostNews = m_newsService.queryFixedNewsByCategoryId(11, 0);
		m_firstJiaoDian = hostNews.get(0);
		m_firstJiaoDians = hostNews.subList(1, 5);
		m_secondJiaoDians = hostNews.subList(5, 11);
	}

	private void queryZiXun() {
		// 综合咨询
		m_huoDongZiXuns = m_newsService.queryFixedNewsBySmallCategoryId(8, Config.ZiXun_HuoDongZiXun);
		m_youHuiXinXis = m_newsService.queryFixedNewsBySmallCategoryId(8, Config.ZiXun_YouHuiXinXi);
		m_renCaiQiuGongs = m_newsService.queryFixedNewsBySmallCategoryId(8, Config.ZiXun_RenCaiGongQiu);

		m_benDiShiShangs = m_newsService.queryFixedNewsBySmallCategoryId(8, Config.ZiXun_BenDiShiShang);
		m_sheHuiReDians = m_newsService.queryFixedNewsBySmallCategoryId(8, Config.ZiXun_SheHuiReDian);
		m_zongHeZiXuns = m_newsService.queryFixedNewsBySmallCategoryId(8, Config.ZiXun_ZongheZiXun);
		m_gongQiuXinXis = m_newsService.queryFixedNewsBySmallCategoryId(8, Config.ZiXun_GongQiuXinXi);
		m_lianXiChangs = m_newsService.queryFixedNewsBySmallCategoryId(8, Config.ZiXun_LianXiChang);
	}

	@Override
	public String execute() throws Exception {
		queryJiaoDian();
		querySaiShi();
		queryPingLun();
		queryZiXun();
		queryLvYou();
		queryPlayer();
		queryMedia();

		queryOther();
		return SUCCESS;
	}

	private void queryOther() {
		m_imageNews = m_newsService.queryFixedImageNewsByCategoryId(3, 0);
		for (News temp : m_imageNews) {
			temp.setImage(m_imageService.findImage(temp.getImageId()));
		}

		m_imageSpecials = m_imageSpecialService.queryFixedImageSpecials(4);
		for (ImageSpecial temp : m_imageSpecials) {
			temp.setImage(m_imageService.findImage(temp.getImageId()));
		}

		m_specialNews = m_specialNewsService.queryLastestSpecialNews(10);

		m_teamNews = m_teamNewsService.queryFixedTeamNewss(10);

		List<Court> all = m_courtService.queryFixedCourts(4);
		m_court = all.get(0);
		m_courts = all.subList(1, 4);

		List<CourtImage> images = m_courtImageService.queryAllCourtImages(m_court.getId());
		if (images.size() > 0) {
			m_courtImage = images.get(0);
			m_courtImage.setImage(m_imageService.findImage(m_courtImage.getImageId()));
		}
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

	private void queryPlayer() {
		m_jiangJinPlayers = m_playerService.queryPlayers("bonus", 6);
		m_jiFenPlayers = m_playerService.queryPlayers("score", 6);
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

	public void setAdwordsService(AdwordsService adwordsService) {
		m_adwordsService = adwordsService;
	}

	public AdwordsService getAdwordsService() {
		return m_adwordsService;
	}

	public News getFirstJiaoDian() {
		return m_firstJiaoDian;
	}

	public List<News> getFirstJiaoDians() {
		return m_firstJiaoDians;
	}

	public List<News> getSecondJiaoDians() {
		return m_secondJiaoDians;
	}

	public News getFirstSaiShi() {
		return m_firstSaiShi;
	}

	public List<News> getFirstSaiShis() {
		return m_firstSaiShis;
	}

	public List<News> getSecondSaiShis() {
		return m_secondSaiShis;
	}

	public List<News> getHuoDongZiXuns() {
		return m_huoDongZiXuns;
	}

	public List<News> getYouHuiXinXis() {
		return m_youHuiXinXis;
	}

	public List<News> getRenCaiQiuGongs() {
		return m_renCaiQiuGongs;
	}

	public List<News> getBenDiShiShangs() {
		return m_benDiShiShangs;
	}

	public List<News> getSheHuiReDians() {
		return m_sheHuiReDians;
	}

	public List<News> getZongHeZiXuns() {
		return m_zongHeZiXuns;
	}

	public List<TeamNews> getQiuDuiHuoDongs() {
		return m_qiuDuiHuoDongs;
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

	public List<News> getGaoQiuDongTais() {
		return m_gaoQiuDongTais;
	}

	public List<News> getQiuJieGuShis() {
		return m_qiuJieGuShis;
	}

	public List<News> getXieHuiXinWens() {
		return m_xieHuiXinWens;
	}

	public List<News> getGuanDianPingLuns() {
		return m_guanDianPingLuns;
	}

	public List<Player> getJiangJinPlayers() {
		return m_jiangJinPlayers;
	}

	public List<Player> getJiFenPlayers() {
		return m_jiFenPlayers;
	}

	public List<Media> getYouQingMedias() {
		return m_youQingMedias;
	}

	public List<Media> getHeZuoMedias() {
		return m_heZuoMedias;
	}

	public List<News> getGongQiuXinXis() {
		return m_gongQiuXinXis;
	}

	public List<News> getLianXiChangs() {
		return m_lianXiChangs;
	}

	public void setSpecialNewsService(SpecialNewsService specialNewsService) {
		m_specialNewsService = specialNewsService;
	}

	public List<SpecialNews> getSpecialNews() {
		return m_specialNews;
	}

	public void setImageSpecialService(ImageSpecialService imageSpecialService) {
		m_imageSpecialService = imageSpecialService;
	}

	public List<ImageSpecial> getImageSpecials() {
		return m_imageSpecials;
	}

	public void setTeamNewsService(TeamNewsService teamNewsService) {
		m_teamNewsService = teamNewsService;
	}

	public List<TeamNews> getTeamNews() {
		return m_teamNews;
	}

	public Court getCourt() {
		return m_court;
	}

	public List<Court> getCourts() {
		return m_courts;
	}

	public void setCourtService(CourtService courtService) {
		m_courtService = courtService;
	}

	public void setCourtImageService(CourtImageService courtImageService) {
		m_courtImageService = courtImageService;
	}

	public CourtImage getCourtImage() {
		return m_courtImage;
	}

	public List<News> getImageNews() {
		return m_imageNews;
	}

}