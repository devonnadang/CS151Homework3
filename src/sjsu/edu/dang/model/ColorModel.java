package sjsu.edu.dang.model;


public class ColorModel{
	 	private int height; 
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
	            reset();
	        }
	    }
	    
	    public void reset() {
	    	height = 0;
	    }
	    
	    public int getHeight() {
	        return height;
	    }
	    
}
