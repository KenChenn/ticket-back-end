package com.example.ticketbackend.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.Random;

public class VerityUtil {
	
	//�]�w���ҽX�r��
	private static final char[] chars = {
			  '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
	            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
	            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
	            };
	
	//�r���ƶq
	private final int size;
	//�z�Z�u�ƶq
	private final int lines;
	//�e��
	private final int width;
	//����
	private final int height;
	//�r��j�p
	private final int fontSize;
	//�r��O�_�ɱ�
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
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); //�ЫتťչϤ�
		Graphics2D graphic = image.createGraphics(); //�Ыؤ@�ӯ�b�Ϥ��Wø�e����H
		graphic.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON); //�]�m�ܿ���
		graphic.setColor(backgroundColor);
		graphic.fillRect(0, 0, width, height);
		Random ran = new Random(); //��l���H����class
		int codeWidth = width / (size + 1); //�p��C�Ӧr�����e�סA�ùw�d�@�Ӧr�����e�׷�@���k��Z
		int y = height * 3 / 4; //�r���ҳB��Y�b�y��
		for(int i=0; i<size; i++) {
			graphic.setColor(getRandomColor());
			Font font = new Font(null,Font.BOLD + Font.ITALIC, fontSize); //��l�Ʀr��
			
			if(tilt) {
				int theta = ran.nextInt(45); //�H���@�Ӷɱת����� -45~45�פ���
				//�H���@�Ӷɱפ�V�A����Υk��
				theta = (ran.nextBoolean()==true) ? theta : -theta; 
				AffineTransform affineTransform = new AffineTransform();
				affineTransform.rotate(Math.toRadians(theta),0,0);
				font = font.deriveFont(affineTransform);
			}
			graphic.setFont(font); //�]�m�ϥΦr���e���W
			int x = (i*codeWidth) + (codeWidth/2); //�p���e�r��ø�s��X�b�y��
			
			int n = ran.nextInt(chars.length); //���H���r������
			String code =String.valueOf(chars[n]); //�o��r���奻
			graphic.drawString(code,x,y);
			
			sb.append(code);
		}
		for(int i =0; i<lines;i++) {
			graphic.setColor(getRandomColor());
			graphic.drawLine(ran.nextInt(width), ran.nextInt(height),ran.nextInt(width), ran.nextInt(height));
		}

		return new Object[]{sb.toString(),image};
	};
	
	
	//�H�������k
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
