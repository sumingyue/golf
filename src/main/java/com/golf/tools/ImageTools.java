package com.golf.tools;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ImageTools {

	private static Logger s_logger = Logger.getLogger(ImageTools.class);

	private static String getImagePattern(String fileName) {
		int index = fileName.lastIndexOf('.');

		if (index > 0) {
			return fileName.substring(index);
		}
		return ".png";
	}

	public static String getOriginalPath(String fileName, int type) {
		String path = new SimpleDateFormat("yyyyMMdd/").format(new Date()) + fileName;
		String base = "/data/appdatas/golf/image" + getImageType(type);
		return base + path;
	}

	public static String getImageStorePath(String fileName, int type) {
		String typeName = getImageType(type);
		String day = new SimpleDateFormat("yyyyMMdd/").format(new Date());
		String path = typeName + day + System.currentTimeMillis() + getImagePattern(fileName);
		return path;
	}

	public static String getImageStorePath(String fileName, String flag, int type) {
		String typeName = getImageType(type);
		String day = new SimpleDateFormat("yyyyMMdd/").format(new Date());
		String path = typeName + day + System.currentTimeMillis() + flag + getImagePattern(fileName);
		return path;
	}

	private static String getImageType(int type) {
		String typeName = "/news/";
		if (type == 1) {
			typeName = "/news/";
		} else if (type == 2) {
			typeName = "/adwords/";
		} else if (type == 3) {
			typeName = "/product/";
		} else if (type == 4) {
			typeName = "/team/";
		} else if (type == 5) {
			typeName = "/court/";
		} else if (type == 6) {
			typeName = "/pic/";
		} else {
			typeName = "/other/";
		}
		return typeName;
	}

	/**
	 * 压缩图片文件<br>
	 * 先保存原文件，再压缩、上传
	 * 
	 * @param oldFile
	 *           要进行压缩的文件全路径
	 * @param width
	 *           宽度
	 * @param height
	 *           高度
	 * @param quality
	 *           质量
	 * @param smallIcon
	 *           小图片的后缀
	 * @return 返回压缩后的文件的全路径
	 */
	// public static String zipImageFile(String oldFile, int width, int height, float quality, String smallIcon) {
	public static boolean compress(File image, String newImage, String pattern, int width, int height) {
		try {
			Image srcFile = ImageIO.read(image);
			int w = srcFile.getWidth(null);
			int h = srcFile.getHeight(null);

			double bili1 = w * 1.0 / width;
			double bili2 = h * 1.0 / height;

			if (bili1 > 1 && bili2 > 1) {
				if (bili1 > bili2) {
					width = (int) (w / (bili2));
				} else {
					height = (int) (h / bili1);
				}
			}
			s_logger.info("Compress Image " + image.getName() + " " + w + " " + h + " To " + width + " " + height);
			
			/** 宽,高设定 */
			BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			tag.getGraphics().drawImage(srcFile.getScaledInstance(w, h, Image.SCALE_SMOOTH), 0, 0, width, height, null);

			/** 压缩之后临时存放位置 */
			FileOutputStream out = new FileOutputStream(newImage);

			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(tag);
			/** 压缩质量 */
			jep.setQuality(1, true);
			encoder.encode(tag, jep);
			out.close();
			return true;
		} catch (FileNotFoundException e) {
			s_logger.error(e);
		} catch (IOException e) {
			s_logger.error(e);
		}
		return false;
	}

	 /**
	 *
	 * @param f
	 * 图片所在的文件夹路径
	 * @param filelist
	 * 图片路径
	 * @param ext
	 * 扩展名
	 * @param n
	 * 图片名
	 * @param width
	 * 目标宽
	 * @param height
	 * 目标高
	 * @param per
	 * 百分比
	 */
	 public static boolean compress1(File image, String path, String pattern, int width, int height) {
	 Image src;
	 try {
	 src = javax.imageio.ImageIO.read(image); // 构造Image对象
	
	 String img_midname = path;
	 int old_w = src.getWidth(null); // 得到源图宽
	 int old_h = src.getHeight(null);
	 int new_w = 0;
	 int new_h = 0; // 得到源图长
	
	 double w2 = (old_w * 1.00) / (width * 1.00);
	 double h2 = (old_h * 1.00) / (height * 1.00);
	
	 // 图片跟据长宽留白，成一个正方形图。
	 BufferedImage oldpic;
	 if (old_w > old_h) {
	 oldpic = new BufferedImage(old_w, old_w, BufferedImage.TYPE_INT_RGB);
	 } else {
	 if (old_w < old_h) {
	 oldpic = new BufferedImage(old_h, old_h, BufferedImage.TYPE_INT_RGB);
	 } else {
	 oldpic = new BufferedImage(old_w, old_h, BufferedImage.TYPE_INT_RGB);
	 }
	 }
	 Graphics2D g = oldpic.createGraphics();
	 g.setColor(Color.white);
	 if (old_w > old_h) {
	 g.fillRect(0, 0, old_w, old_w);
	 g.drawImage(src, 0, (old_w - old_h) / 2, old_w, old_h, Color.white, null);
	 } else {
	 if (old_w < old_h) {
	 g.fillRect(0, 0, old_h, old_h);
	 g.drawImage(src, (old_h - old_w) / 2, 0, old_w, old_h, Color.white, null);
	 } else {
	 // g.fillRect(0,0,old_h,old_h);
	 g.drawImage(src.getScaledInstance(old_w, old_h, Image.SCALE_SMOOTH), 0, 0, null);
	 }
	 }
	 g.dispose();
	 src = oldpic;
	 // 图片调整为方形结束
	 if (old_w > width)
	 new_w = (int) Math.round(old_w / w2);
	 else
	 new_w = old_w;
	 if (old_h > height)
	 new_h = (int) Math.round(old_h / h2);// 计算新图长宽
	 else
	 new_h = old_h;
	 BufferedImage tag = new BufferedImage(new_w, new_h, BufferedImage.TYPE_INT_RGB);
	 // tag.getGraphics().drawImage(src,0,0,new_w,new_h,null); //绘制缩小后的图
	 tag.getGraphics().drawImage(src.getScaledInstance(new_w, new_h, Image.SCALE_SMOOTH), 0, 0, null);
	 FileOutputStream newimage = new FileOutputStream(img_midname); // 输出到文件流
	 JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(newimage);
	 JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(tag);
	 /* 压缩质量 */
	 jep.setQuality(1, true);
	 encoder.encode(tag, jep);
	 // encoder.encode(tag); //近JPEG编码
	 newimage.close();
	 return true;
	 } catch (IOException ex) {
		 s_logger.error(ex);
	 }
	 return false;
	 }
}
