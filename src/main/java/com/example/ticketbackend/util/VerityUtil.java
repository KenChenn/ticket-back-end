package com.example.ticketbackend.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.Random;

public class VerityUtil {
	
	//設定驗證碼字母
	private static final char[] chars = {
			  '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
	            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
	            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
	            };
	
	//字元數量
	private final int size;
	//干擾線數量
	private final int lines;
	//寬度
	private final int width;
	//高度
	private final int height;
	//字體大小
	private final int fontSize;
	//字體是否傾斜
	private final boolean tilt;
	
	private final Color backgroundColor;
	
	private VerityUtil(Builder builder) {
		size = builder.size;
		lines = builder.lines;
		width = builder.width;
		height = builder.height;
		fontSize = builder.fontSize;
		tilt = builder.tilt;
		backgroundColor = builder.backgroundColor;
    }
	
	public Object[] createImage() {
		StringBuffer sb = new StringBuffer(); 
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); //創建空白圖片
		Graphics2D graphic = image.createGraphics(); //創建一個能在圖片上繪畫的對象
		graphic.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON); //設置抗鋸齒
		graphic.setColor(backgroundColor);
		graphic.fillRect(0, 0, width, height);
		Random ran = new Random(); //初始化隨機的class
		int codeWidth = width / (size + 1); //計算每個字元的寬度，並預留一個字元的寬度當作左右邊距
		int y = height * 3 / 4; //字元所處的Y軸座標
		for(int i=0; i<size; i++) {
			graphic.setColor(getRandomColor());
			Font font = new Font(null,Font.BOLD + Font.ITALIC, fontSize); //初始化字體
			
			if(tilt) {
				int theta = ran.nextInt(45); //隨機一個傾斜的角度 -45~45度之間
				//隨機一個傾斜方向，左邊或右邊
				theta = (ran.nextBoolean()==true) ? theta : -theta; 
				AffineTransform affineTransform = new AffineTransform();
				affineTransform.rotate(Math.toRadians(theta),0,0);
				font = font.deriveFont(affineTransform);
			}
			graphic.setFont(font); //設置使用字體到畫筆上
			int x = (i*codeWidth) + (codeWidth/2); //計算當前字元繪製的X軸座標
			
			int n = ran.nextInt(chars.length); //取隨機字元索引
			String code =String.valueOf(chars[n]); //得到字元文本
			graphic.drawString(code,x,y);
			
			sb.append(code);
		}
		for(int i =0; i<lines;i++) {
			graphic.setColor(getRandomColor());
			graphic.drawLine(ran.nextInt(width), ran.nextInt(height),ran.nextInt(width), ran.nextInt(height));
		}

		return new Object[]{sb.toString(),image};
	};
	
	
	//隨機取色方法
	private Color getRandomColor() {
		Random ran = new Random();
		Color color = new Color(ran.nextInt(256),ran.nextInt(256),ran.nextInt(256));
		return color;
	}
	
	
	
	
    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder{
    	private int size = 4;
    	private int lines = 10;
    	private int width = 80;
    	private int height=35;
    	private int fontSize=25;
    	private boolean tilt =true;
    	private Color backgroundColor = Color.LIGHT_GRAY;
		public int getSize() {
			return size;
		}
		public void setSize(int size) {
			this.size = size;
		}
		public int getLines() {
			return lines;
		}
		public void setLines(int lines) {
			this.lines = lines;
		}
		public int getWidth() {
			return width;
		}
		public void setWidth(int width) {
			this.width = width;
		}
		public int getHeight() {
			return height;
		}
		public void setHeight(int height) {
			this.height = height;
		}
		public int getFontSize() {
			return fontSize;
		}
		public void setFontSize(int fontSize) {
			this.fontSize = fontSize;
		}
		public boolean isTilt() {
			return tilt;
		}
		public void setTilt(boolean tile) {
			this.tilt = tile;
		}
		public Color getBackgroundColor() {
			return backgroundColor;
		}
		public void setBackgroundColor(Color backgroundColor) {
			this.backgroundColor = backgroundColor;
		}
    	
    	
    }

	

}
