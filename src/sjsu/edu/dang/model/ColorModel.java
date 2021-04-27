package sjsu.edu.dang.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class ColorModel{
	 	private int height; 
	    private int width;
	    private String color;
	    
	    public ColorModel(String color, int height) {
	    	this.color = color;
	    	this.height = height;
	    }
	    
	    public void setColor(String c) {
	    	color = c;
	    }
	    public String getColor() {
	    	return color;
	    }
	    public void setHeight(int height) {
	        if (height >= 0) {
	            this.height = height;
	        } else {
	            height = 0;
	        }
	    }
	    public int getHeight() {
	        return height;
	    }
	    
}
