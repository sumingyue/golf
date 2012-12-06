package com.golf;

public class Config {

	public static final boolean DUBUG = true;

	public static final String IMAGE_PATH = "upload";

	public static final int DEFAULT_PAGE_NUMBER = 15;

	public static final int DEBUG_TOTAL = 106;

	public static final int TITLE_LENGTH = 15;

	public static final int NEWS_PAGED_NUMBER = 15;

	public static final int DEFAULT_MAX_TITLE_LENGTH = 18;
	
	public static final int DEFAULT_NORMAL_TITLE_LENGTH=15;

	public static final int DEFAULT_SMALL_TITLE_LENGTH = 12;

	// INSERT INTO category values (1,1,'高球新闻',now());
	// INSERT INTO category values (2,1,'高球赛事',now());
	// INSERT INTO category values (3,1,'人物评论',now());
	// INSERT INTO category values (4,1,'高球旅游',now());
	// INSERT INTO category values (5,1,'高球学院',now());
	// INSERT INTO category values (6,1,'综合资讯',now());
	public static final int CATE_ZongHe = 1;

	public static final int CATE_SaiShi = 2;

	public static final int CATE_RenWu = 3;

	public static final int CATE_LvYou = 4;

	public static final int CATE_XueYuan = 5;

	public static final int CATE_ZiXun = 6;

	// INSERT INTO smallCategory values (1,1,'国际新闻',now());
	// INSERT INTO smallCategory values (2,1,'国内新闻',now());
	// INSERT INTO smallCategory values (3,1,'产业新闻',now());
	// INSERT INTO smallCategory values (4,1,'品牌资讯',now());
	// INSERT INTO smallCategory values (5,1,'国外球声',now());
	// INSERT INTO smallCategory values (6,1,'综合关注',now());
	public static final int ZongHe_GuoJiXinWen = 1;

	public static final int ZongHe_GuoNeiXinWen = 2;

	public static final int ZongHe_ChanYeXinWen = 3;

	public static final int ZongHe_PinPaiZiXun = 4;

	public static final int ZongHe_GuoWaiQiuSheng = 5;

	public static final int ZongHe_guanZhuGuanZhu = 6;

	// INSERT INTO smallCategory values (7,2,'国际赛事',now());
	// INSERT INTO smallCategory values (8,2,'国内赛事',now());
	// INSERT INTO smallCategory values (9,2,'品牌赛事',now());
	// INSERT INTO smallCategory values (10,2,'赛事告之',now());
	// INSERT INTO smallCategory values (11,2,'赛事介绍',now());
	// INSERT INTO smallCategory values (12,2,'球员关注',now());
	public static final int SaiShi_GuoJiSaiShi = 7;

	public static final int SaiShi_GuoNeiSaiShi = 8;

	public static final int SaiShi_PinPaiSaiShi = 9;

	public static final int SaiShi_SaiShiGaoZhi = 10;

	public static final int SaiShi_SaiShiJieShao = 11;

	public static final int SaiShi_QiuYuanGuanZhu = 12;

	// INSERT INTO smallCategory values (13,3,'高球动态',now());
	// INSERT INTO smallCategory values (14,3,'球界故事',now());
	// INSERT INTO smallCategory values (15,3,'观点评论',now());
	// INSERT INTO smallCategory values (16,3,'高球人物',now());
	// INSERT INTO smallCategory values (17,3,'协会新闻',now());
	// INSERT INTO smallCategory values (18,3,'名人高球',now());
	public static final int RenWu_GaoQiuDongTai = 13;

	public static final int RenWu_QiuJieGuShi = 14;

	public static final int RenWu_GuanDianPingLun = 15;

	public static final int RenWu_GaoQiuRenWu = 16;

	public static final int RenWu_XieHuiXinWen = 17;

	public static final int RenWu_MingRenGaoQiu = 18;

	// INSERT INTO smallCategory values (19,4,'江浙沪',now());
	// INSERT INTO smallCategory values (20,4,'省市游',now());
	// INSERT INTO smallCategory values (21,4,'经典线路',now());
	// INSERT INTO smallCategory values (22,4,'旅行游记',now());
	// INSERT INTO smallCategory values (23,4,'优惠球场',now());
	// INSERT INTO smallCategory values (24,4,'风格球场',now());
	public static final int LvYou_JiangZheHu = 19;

	public static final int LvYou_ShengShiYou = 20;

	public static final int LvYou_JingDianXianLu = 21;

	public static final int LvYou_LvXingYouJi = 22;

	public static final int LvYou_YouHuiQiuChang = 23;

	public static final int LvYou_FengGeQiuChang = 24;

	// INSERT INTO smallCategory values (25,5,'礼仪知识',now());
	// INSERT INTO smallCategory values (26,5,'违规判罚',now());
	// INSERT INTO smallCategory values (27,5,'技术讲解',now());
	// INSERT INTO smallCategory values (28,5,'稳定挥杆',now());
	// INSERT INTO smallCategory values (29,5,'救球技巧',now());
	// INSERT INTO smallCategory values (30,5,'果岭推杆',now());

	public static final int XueYuan_LiYiZhiShi = 25;

	public static final int XueYuan_WeiGuiPanFa = 26;

	public static final int XueYuan_JiShuJiangJie = 27;

	public static final int XueYuan_WenDingHuiGan = 28;

	public static final int XueYuan_JiuQiuJiQiao = 29;

	public static final int XueYuan_GuoLinTuiGan = 30;

	// INSERT INTO smallCategory values (32,6,'活动资讯',now());
	// INSERT INTO smallCategory values (33,6,'优惠信息',now());
	// INSERT INTO smallCategory values (34,6,'人才供求',now());
	// INSERT INTO smallCategory values (35,6,'综合资讯',now());
	// INSERT INTO smallCategory values (36,6,'本地时尚',now());
	// INSERT INTO smallCategory values (37,6,'社会热点',now());
	// INSERT INTO smallCategory values (38,6,'球会资讯',now());
	// INSERT INTO smallCategory values (39,6,'会籍资讯',now());
	// INSERT INTO smallCategory values (40,6,'供求信息',now());
	// INSERT INTO smallCategory values (41,6,'练习场',now());
	public static final int ZiXun_HuoDongZiXun = 32;

	public static final int ZiXun_YouHuiXinXi = 33;

	public static final int ZiXun_RenCaiGongQiu = 34;

	public static final int ZiXun_ZongheZiXun = 35;

	public static final int ZiXun_BenDiShiShang = 36;

	public static final int ZiXun_SheHuiReDian = 37;

	public static final int ZiXun_QiuHuiZiXun = 38;

	public static final int ZiXun_HuiJiZiXun = 39;

	public static final int ZiXun_GongQiuXinXi = 39;

	public static final int ZiXun_LianXiChang = 40;

	public static final String Anonymous = "匿名";

	public static final String YouQingLianJie = "友情链接";

}
