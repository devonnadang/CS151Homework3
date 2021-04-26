package sjsu.edu.dang.model;

public class BlueColorModel {
	private int height; 
    private int MULTIPLIER = 6;
    private final String COLOR = "Blue";
    
    public String getColor() {
    	return COLOR;
    }    
    public void setHeight(int height) {
        if (height >= 0) {
            this.height = height * MULTIPLIER;
        } else {
            height = 0;
        }
    }
    public int getHeight() {
        return height;
    }
}
