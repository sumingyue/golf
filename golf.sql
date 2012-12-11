CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoryId` int(11) NOT NULL COMMENT '一级分类',
  `smallCategoryId` int(11) NOT NULL COMMENT '二级分类',
  `title` varchar(50) NOT NULL COMMENT '新闻标题',
  `imageId` int(11) NOT NULL COMMENT '新闻默认图片',
  `content` mediumtext NOT NULL COMMENT '新闻内容',
  `source` varchar(50)  COMMENT '新闻来源',
  `keyword` varchar(50)  COMMENT '文章关键字',
  `author` varchar(20)  COMMENT '新闻作者',
  `good` int(11) NOT NULL COMMENT '顶的次数',
  `bad` int(11) NOT NULL COMMENT '踩的次数',
  `viewNumber` int(11) NOT NULL COMMENT '浏览次数',
  `status` int(11) NOT NULL COMMENT '新闻状态，0表示未审核，1表示正常，2表示删除',
  `recommend` int(11) NOT NULL COMMENT '是否推荐，0表示是，1表示不',
  `priority` int(11) NOT NULL COMMENT '新闻优先级',
  `validateDate` datetime NOT NULL COMMENT '新闻发表时间',
  `creationDate` datetime NOT NULL COMMENT '新闻创建时间',
  `modifyDate` datetime NOT NULL COMMENT '新闻修改时间',
  PRIMARY KEY (`id`),
  KEY `title_author` (`title`,`author`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='新闻基本内容';

CREATE TABLE `specialNews` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL COMMENT '专题标题',
  `content` mediumtext NOT NULL COMMENT '专题内容',
  `viewNumber` int(11) NOT NULL COMMENT '浏览次数',
  `priority` int(11) NOT NULL COMMENT '专题优先级',
  `creationDate` datetime NOT NULL COMMENT '专题创建时间',
  `modifyDate` datetime NOT NULL COMMENT '专题修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='新闻专题内容';

CREATE TABLE  `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) NOT NULL COMMENT '分类的类型，0表示新闻分类，1表示图片分类',
  `name` varchar(50) NOT NULL COMMENT '分类标题',
  `creationDate` datetime NOT NULL COMMENT '分类创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='新闻一级分类';


CREATE TABLE  `smallCategory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoryId` int(11) NOT NULL COMMENT '所属的大分类',
  `name` varchar(50) NOT NULL COMMENT '二级分类名称',
  `creationDate` datetime NOT NULL COMMENT '二级分类创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='新闻二级分类';

CREATE TABLE  `newsComments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `newsId` int(11) NOT NULL COMMENT '新闻ID',
  `userName` varchar(50) NOT NULL COMMENT '用户昵称',
  `content` varchar(500) NOT NULL COMMENT '用户评论内容',
  `creationDate` datetime NOT NULL COMMENT '评论创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='新闻评论';

CREATE TABLE  `image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) NOT NULL COMMENT '1表示新闻首页图,2表示广告图,3表示新闻内容图,4球队的图片',
  `name` varchar(512) NOT NULL COMMENT '图片的真实名称',
  `path` varchar(512) NOT NULL COMMENT '图片相对路径',
  `smallPath` varchar(512) NOT NULL COMMENT '图片压缩后存储路径',
  `originalPath` varchar(512) NOT NULL COMMENT '原始图片存储路径  /data/appdatas/golf/',
  `netPath` varchar(512) NOT NULL COMMENT '图片服务器存储路径',
  `creationDate` datetime NOT NULL COMMENT '图片创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='图片基本信息';

CREATE TABLE `adwords`(
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `position` varchar(100) NOT NULL  COMMENT '广告位置',
  `name` varchar(100) NOT NULL  COMMENT'广告名称',
  `width` int(11) NOT NULL  COMMENT '广告宽度',
  `height` int(11) NOT NULL  COMMENT '广告高度',
  `url` varchar(512) NOT NULL COMMENT '广告的链接',
  `imageId` int(11) NOT NULL COMMENT '广告图片的ID',
  `creationDate` datetime NOT NULL COMMENT '广告创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='广告基本信息';

CREATE TABLE  `player` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL  COMMENT '球员名字',
  `score` double NOT NULL  COMMENT '球员积分',
  `bonus` double NOT NULL  COMMENT '球员奖金',
  `creationDate` datetime NOT NULL COMMENT '创建时间',
  `modifyDate` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='球员基本信息';

CREATE TABLE  `media` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(50) NOT NULL COMMENT '合作媒体，友情链接',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `url` varchar(512) NOT NULL COMMENT '媒体的超链接',
  `creationDate` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='媒体链接基本信息';

CREATE TABLE  `productCategory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) NOT NULL COMMENT '大分类类别，1表示球具，2表示服饰，3表示用品，4表示附件',
  `name` varchar(50) NOT NULL COMMENT '小分类的具体名称',
  `creationDate` datetime NOT NULL COMMENT '分类创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='高尔夫商城具体的价格表';

CREATE TABLE  `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productCategoryId` int(11) NOT NULL COMMENT '产品具体分类',
  `name` varchar(200) NOT NULL COMMENT '产品具体名称',
  `unit` varchar(50) NOT NULL COMMENT '产品单位',
  `brand` varchar(100) NOT NULL COMMENT '产品品牌',
  `crowd` varchar(100) NOT NULL COMMENT '产品适合人群',
  `material` varchar(100) NOT NULL COMMENT '产品材质',
  `introduction` mediumtext NOT NULL COMMENT '产品介绍',
  `price` double NOT NULL COMMENT '产品价格',
  `memberPrice` double NOT NULL COMMENT '产品会员价格',
  `creationDate` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商城产品具体信息';

CREATE TABLE   `productImage` ( 
  `productId` int(11) NOT NULL COMMENT '产品的ID',
  `imageId` int(11) NOT NULL COMMENT '图片的ID',
  `creationDate` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`productId`,`imageId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品图片信息';

CREATE TABLE   `productOrder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productId` int(11) NOT NULL COMMENT '产品的ID',
  `orderNumber`  int(11)  NOT NULL COMMENT '订单数量',
  `userName`  varchar(100)  NOT NULL COMMENT '用户姓名',
  `userPhone`  varchar(100)  NOT NULL COMMENT '电话号码',
  `userAddress`  varchar(200)   COMMENT '用户地址',
  `status`  int(11) NOT NULL COMMENT '订单状态，0表示未处理，1表示待定，2表示已处理',
  `note`  varchar(2000)   COMMENT '备注信息',
  `creationDate` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户订单信息';

CREATE TABLE   `courtOrder` ( 
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `type` int(11) NOT NULL COMMENT '类型，1球场，2练习场',
    `courtName`  varchar(100)  NOT NULL COMMENT '球场名字',
    `date`  datetime  NOT NULL COMMENT '时间',
    `number` int(11) NOT NULL COMMENT '定的人数',
    `userName`  varchar(100)  NOT NULL COMMENT '用户姓名',
    `userPhone`  varchar(100)  NOT NULL COMMENT '电话号码',
    `status`  int(11) NOT NULL COMMENT '订单状态，0表示未处理，1表示待定，2表示已处理',
    `note`  varchar(2000)  NOT NULL COMMENT '备注信息',
    `creationDate` datetime NOT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户定球场信息';

CREATE TABLE  `team` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL COMMENT '球队名称',
  `imageId` int(11) NOT NULL  COMMENT '球队图片',
  `announcement` text  COMMENT '球队公告',
  `introduction` text  COMMENT '球队介绍',
  `setUpTime` varchar(100) NOT NULL COMMENT '建队时间',
  `founder` varchar(50) NOT NULL COMMENT '首任会长',
  `captain` varchar(50) NOT NULL COMMENT '现任会长',
  `members` varchar(1000)  COMMENT '成员组成',
  `slogan` varchar(1000)  COMMENT '球队口号',
  `achievement` varchar(1000)  COMMENT '球队成绩',
  `creationDate` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='球队基本信息';

CREATE TABLE  `teamMemberImage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teamId` int(11) NOT NULL  COMMENT '球队ID',
  `imageId` int(11) NOT NULL  COMMENT '球员图片ID',
  `memberName` varchar(50)  COMMENT '球员姓名',
  `imageDes` varchar(200)  COMMENT '图片介绍',
  `creationDate` datetime NOT NULL COMMENT '创建时间',
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='球队球员图片基本信息';


CREATE TABLE `teamNews` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teamId` int(11) NOT NULL COMMENT '球队ID',
  `type` int(11) NOT NULL COMMENT '1表示球队新闻，2表示活动报道，3表示月历成绩，4表示精彩图文',
  `title` varchar(50) NOT NULL COMMENT '新闻标题',
  `content` mediumtext NOT NULL COMMENT '新闻内容',
  `creationDate` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='球队新闻';

CREATE TABLE `userMessage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL COMMENT '用户留言内容',
  `reply` text  COMMENT '管理员回复内容',
  `creationDate` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户留言';

CREATE TABLE  `court` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '球场名称',
  `address` varchar(100) NOT NULL COMMENT '地址',
  `phone` varchar(100) NOT NULL COMMENT '联系方式',
  `introduction` text  COMMENT '球场介绍',
  `customIntro` text  COMMENT '自定义介绍',
  `awards` text  COMMENT '奖项介绍',
  `mapImageId` int(11) NOT NULL  COMMENT '地图图片ID',
  `mapIntroduction` varchar(500) NOT NULL COMMENT '位置介绍信息',
  `creationDate` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='球场信息';

CREATE TABLE  `courtImage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courtId` int(11) NOT NULL  COMMENT '球场ID',
  `imageId` int(11) NOT NULL  COMMENT '球场图片ID',
  `imageDes` varchar(200)  COMMENT '图片介绍',
  `creationDate` datetime NOT NULL COMMENT '创建时间',
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='球场图片基本信息';


CREATE TABLE  `courtRaider` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courtId` int(11) NOT NULL  COMMENT '球场ID',
  `name` varchar(200) NOT NULL COMMENT '球道名称',
  `imageId` int(11) NOT NULL  COMMENT '球道图片ID',
  `indexName` varchar(200) NOT NULL COMMENT '球洞名称',
  `des` varchar(500)  COMMENT '图片介绍',
  `creationDate` datetime NOT NULL COMMENT '创建时间',
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='球洞基本信息';

CREATE TABLE  `courtComments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courtId` int(11) NOT NULL COMMENT '球场ID',
  `userName` varchar(50) NOT NULL COMMENT '用户昵称',
  `content` varchar(500) NOT NULL COMMENT '用户评论内容',
  `creationDate` datetime NOT NULL COMMENT '评论创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='新闻评论';

CREATE TABLE  `newsComments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `newsId` int(11) NOT NULL COMMENT '新闻ID',
  `userName` varchar(50) NOT NULL COMMENT '用户昵称',
  `content` varchar(500) NOT NULL COMMENT '用户评论内容',
  `creationDate` datetime NOT NULL COMMENT '评论创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='新闻评论';

CREATE TABLE  `imageSpecial` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoryId` int(11) NOT NULL COMMENT '一级分类',
  `smallCategoryId` int(11) NOT NULL COMMENT '二级分类',
  `name` varchar(200) NOT NULL COMMENT '专题名称',
  `content` varchar(500) NOT NULL COMMENT '专题内容介绍',
  `imageId` int(11) NOT NULL  COMMENT '图片专题封面',
  `creationDate` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='图片专题信息';

CREATE TABLE  `imageSpecialDetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `imageSpecialId` int(11) NOT NULL  COMMENT '图片专题ID',
  `imageId` int(11) NOT NULL  COMMENT '图片ID',
  `imageDes` varchar(200)  COMMENT '图片介绍',
  `creationDate` datetime NOT NULL COMMENT '创建时间',
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='图片专题图片基本信息';


CREATE TABLE  `matchService` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` int(11) NOT NULL COMMENT '打球人数',
  `date` datetime NOT NULL COMMENT '打球时间',
  `userName` varchar(100) NOT NULL COMMENT '客户姓名',
  `userPhone`  varchar(100)  NOT NULL COMMENT '电话号码',
  `content` varchar(2000) NOT NULL COMMENT '自定义内容',
   `status`  int(11) NOT NULL COMMENT '订单状态，0表示未处理，1表示待定，2表示已处理',
  `creationDate` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='赛事服务基本信息';


INSERT INTO category values (1,1,'高球新闻',now());
INSERT INTO category values (2,1,'高球赛事',now());
INSERT INTO category values (3,1,'人物评论',now());
INSERT INTO category values (4,1,'高球旅游',now());
INSERT INTO category values (5,1,'高球学院',now());
INSERT INTO category values (6,1,'综合资讯',now());


INSERT INTO smallCategory values (1,1,'国际新闻',now());
INSERT INTO smallCategory values (2,1,'国内新闻',now());
INSERT INTO smallCategory values (3,1,'产业新闻',now());
INSERT INTO smallCategory values (4,1,'品牌资讯',now());
INSERT INTO smallCategory values (5,1,'国外球声',now());
INSERT INTO smallCategory values (6,1,'综合关注',now());

INSERT INTO smallCategory values (7,2,'国际赛事',now());
INSERT INTO smallCategory values (8,2,'国内赛事',now());
INSERT INTO smallCategory values (9,2,'品牌赛事',now());
INSERT INTO smallCategory values (10,2,'赛事告之',now());
INSERT INTO smallCategory values (11,2,'赛事介绍',now());
INSERT INTO smallCategory values (12,2,'球员关注',now());

INSERT INTO smallCategory values (13,3,'高球动态',now());
INSERT INTO smallCategory values (14,3,'球界故事',now());
INSERT INTO smallCategory values (15,3,'观点评论',now());
INSERT INTO smallCategory values (16,3,'高球人物',now());
INSERT INTO smallCategory values (17,3,'协会新闻',now());
INSERT INTO smallCategory values (18,3,'名人高球',now());


INSERT INTO smallCategory values (19,4,'江浙沪',now());
INSERT INTO smallCategory values (20,4,'省市游',now());
INSERT INTO smallCategory values (21,4,'经典线路',now());
INSERT INTO smallCategory values (22,4,'旅行游记',now());
INSERT INTO smallCategory values (23,4,'优惠球场',now());
INSERT INTO smallCategory values (24,4,'风格球场',now());


INSERT INTO smallCategory values (25,5,'礼仪知识',now());
INSERT INTO smallCategory values (26,5,'违规判罚',now());
INSERT INTO smallCategory values (27,5,'技术讲解',now());
INSERT INTO smallCategory values (28,5,'稳定挥杆',now());
INSERT INTO smallCategory values (29,5,'救球技巧',now());
INSERT INTO smallCategory values (30,5,'果岭推杆',now());


INSERT INTO smallCategory values (32,6,'活动资讯',now());
INSERT INTO smallCategory values (33,6,'优惠信息',now());
INSERT INTO smallCategory values (34,6,'人才供求',now());
INSERT INTO smallCategory values (35,6,'综合新闻',now());
INSERT INTO smallCategory values (36,6,'本地时尚',now());
INSERT INTO smallCategory values (37,6,'社会热点',now());
INSERT INTO smallCategory values (38,6,'球会资讯',now());
INSERT INTO smallCategory values (39,6,'会籍资讯',now());
INSERT INTO smallCategory values (40,6,'供求信息',now());
INSERT INTO smallCategory values (41,6,'练习场',now());
INSERT INTO smallCategory values (42,6,'学球资讯',now());

insert into adwords values(1,'首页','首页横幅广告',950,90,'http://szgolfer.com',0,now());
insert into adwords values(2,'首页','首页菜单下广告01',150,150,'http://szgolfer.com',0,now());
insert into adwords values(3,'首页','首页菜单下广告02',150,150,'http://szgolfer.com',0,now());
insert into adwords values(4,'首页','首页菜单下广告03',150,150,'http://szgolfer.com',0,now());
insert into adwords values(5,'首页','首页菜单下广告04',150,150,'http://szgolfer.com',0,now());
insert into adwords values(6,'首页','中间广告01',470,90,'http://szgolfer.com',0,now());
insert into adwords values(7,'首页','中间广告02',470,90,'http://szgolfer.com',0,now());
insert into adwords values(8,'首页','下部小广告01',150,90,'http://szgolfer.com',0,now());
insert into adwords values(9,'首页','下部小广告02',150,90,'http://szgolfer.com',0,now());
insert into adwords values(10,'首页','下部小广告03',150,90,'http://szgolfer.com',0,now());
insert into adwords values(11,'首页','下部小广告04',150,90,'http://szgolfer.com',0,now());
insert into adwords values(12,'首页','下部小广告05',150,90,'http://szgolfer.com',0,now());
insert into adwords values(13,'首页','下部小广告06',150,90,'http://szgolfer.com',0,now());
insert into adwords values(14,'首页','贵宾通道01',258,58,'http://szgolfer.com',0,now());
insert into adwords values(15,'首页','贵宾通道02',258,58,'http://szgolfer.com',0,now());
insert into adwords values(16,'首页','贵宾通道03',258,58,'http://szgolfer.com',0,now());
insert into adwords values(17,'首页','贵宾通道04',258,58,'http://szgolfer.com',0,now());
insert into adwords values(18,'首页','贵宾通道05',258,58,'http://szgolfer.com',0,now());
insert into adwords values(19,'首页','贵宾通道06',258,58,'http://szgolfer.com',0,now());
insert into adwords values(20,'首页','下部通栏广告',950,90,'http://szgolfer.com',0,now());
insert into adwords values(21,'新闻大类','新闻大类页面通栏广告',950,90,'http://szgolfer.com',0,now());
insert into adwords values(22,'新闻小类','新闻小类右边广告01',270,200,'http://szgolfer.com',0,now());
insert into adwords values(23,'新闻小类','新闻小类右边广告02',270,200,'http://szgolfer.com',0,now());
insert into adwords values(24,'商城页面','商城广告01',650,300,'http://szgolfer.com',0,now());
insert into adwords values(25,'商城页面','商城广告02',650,300,'http://szgolfer.com',0,now());
insert into adwords values(26,'商城页面','商城广告03',650,300,'http://szgolfer.com',0,now());
insert into adwords values(27,'商城页面','商城广告04',650,300,'http://szgolfer.com',0,now());
insert into adwords values(28,'商城页面','商城左侧广告01',190,300,'http://szgolfer.com',0,now());
insert into adwords values(29,'商城页面','商城左侧广告02',190,300,'http://szgolfer.com',0,now());
