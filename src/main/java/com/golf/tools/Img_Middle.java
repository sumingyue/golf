package com.golf.tools;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 
 * @author Jiangpin
 */
public class Img_Middle {
	public void img_change(String url, String name) {
		Tosmallerpic(url, new File(url + name), "_middle", name, 188, 165, (float) 0.7);
		Tosmallerpic(url, new File(url + name), "_small", name, 45, 45, (float) 0.7);
		Tosmallerpic(url, new File(url + name), "_smaller", name, 116, 100, (float) 0.7);
	}

	/**
	 * 
	 * @param f
	 *           图片所在的文件夹路径
	 * @param filelist
	 *           图片路径
	 * @param ext
	 *           扩展名
	 * @param n
	 *           图片名
	 * @param w
	 *           目标宽
	 * @param h
	 *           目标高
	 * @param per
	 *           百分比
	 */
	public static boolean compress(File image, String path, String pattern, int w, int h) {
		Image src;
		try {
			src = javax.imageio.ImageIO.read(image); // 构造Image对象

			String img_midname = path;
			int old_w = src.getWidth(null); // 得到源图宽
			int old_h = src.getHeight(null);
			int new_w = 0;
			int new_h = 0; // 得到源图长

			double w2 = (old_w * 1.00) / (w * 1.00);
			double h2 = (old_h * 1.00) / (h * 1.00);

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
			if (old_w > w)
				new_w = (int) Math.round(old_w / w2);
			else
				new_w = old_w;
			if (old_h > h)
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
			Logger.getLogger(Img_Middle.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}

	private static void Tosmallerpic(String f, File filelist, String ext, String n, int w, int h, float per) {
		Image src;
		try {
			src = javax.imageio.ImageIO.read(filelist); // 构造Image对象

			String img_midname = f + n.substring(0, n.indexOf(".")) + ext + n.substring(n.indexOf("."));
			int old_w = src.getWidth(null); // 得到源图宽
			int old_h = src.getHeight(null);
			int new_w = 0;
			int new_h = 0; // 得到源图长

			double w2 = (old_w * 1.00) / (w * 1.00);
			double h2 = (old_h * 1.00) / (h * 1.00);

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
			if (old_w > w)
				new_w = (int) Math.round(old_w / w2);
			else
				new_w = old_w;
			if (old_h > h)
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
			jep.setQuality(per, true);
			encoder.encode(tag, jep);
			// encoder.encode(tag); //近JPEG编码
			newimage.close();
		} catch (IOException ex) {
			Logger.getLogger(Img_Middle.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void main(String args[]) {
		// String n="0e5465fc-025a-458d-8383-e9ced0c1e728.jpg";
		//String f = "/Users/youyong/Desktop/pic/DSC_0903.JPG";
		//File file = new File(f);
		//Tosmallerpic("/Users/youyong/Desktop/pic/", file, "_middle", ".png", 100, 100, (float) 0.7);

		Img_Middle.zipImageFile("/Users/youyong/Desktop/pic/DSC_0903.JPG", 90, 128, 1f, "x2.");   
	}
	
	 /**  
    * 压缩图片文件<br>  
    * 先保存原文件，再压缩、上传  
    *   
    * @param oldFile  
    *            要进行压缩的文件全路径  
    * @param width  
    *            宽度  
    * @param height  
    *            高度  
    * @param quality  
    *            质量  
    * @param smallIcon  
    *            小图片的后缀  
    * @return 返回压缩后的文件的全路径  
    */  
   public static String zipImageFile(String oldFile, int width, int height,   
           float quality, String smallIcon) {   
       if (oldFile == null) {   
           return null;   
       }   
       String newImage = null;   
       try {   
           /** 对服务器上的临时文件进行处理 */  
           Image srcFile = ImageIO.read(new File(oldFile));
           int w = srcFile.getWidth(null);
           System.out.println(w);
           int h = srcFile.getHeight(null);
           System.out.println(h);
           //width = w/4;
           //height = h/4;
           
           /** 宽,高设定 */  
           BufferedImage tag = new BufferedImage(width, height,   
                   BufferedImage.TYPE_INT_RGB);   
           tag.getGraphics().drawImage(srcFile, 0, 0, width, height, null);   
           String filePrex = oldFile.substring(0, oldFile.indexOf('.'));   
           /** 压缩后的文件名 */  
           newImage = filePrex + smallIcon   
                   + oldFile.substring(filePrex.length());   
 
           /** 压缩之后临时存放位置 */  
           FileOutputStream out = new FileOutputStream(newImage);   
 
           JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);   
           JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(tag);   
           /** 压缩质量 */  
           jep.setQuality(quality, true);   
           encoder.encode(tag, jep);   
           out.close();   
 
       } catch (FileNotFoundException e) {   
           e.printStackTrace();   
       } catch (IOException e) {   
           e.printStackTrace();   
       }   
       return newImage;   
   }   
 
   /**  
    * 保存文件到服务器临时路径  
    *   
    * @param fileName  
    * @param is  
    * @return 文件全路径  
    */  
   public static String writeFile(String fileName, InputStream is) {   
       if (fileName == null || fileName.trim().length() == 0) {   
           return null;   
       }   
       try {   
           /** 首先保存到临时文件 */  
           FileOutputStream fos = new FileOutputStream(fileName);   
           byte[] readBytes = new byte[512];// 缓冲大小   
           int readed = 0;   
           while ((readed = is.read(readBytes)) > 0) {   
               fos.write(readBytes, 0, readed);   
           }   
           fos.close();   
           is.close();   
       } catch (FileNotFoundException e) {   
           e.printStackTrace();   
       } catch (IOException e) {   
           e.printStackTrace();   
       }   
       return fileName;   
   }   
}