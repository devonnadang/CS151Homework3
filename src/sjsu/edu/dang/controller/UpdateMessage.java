package sjsu.edu.dang.controller;

public class UpdateMessage implements Message {
	
	int redValue;
	int blueValue;
	int greenValue;
	
    public UpdateMessage(int redValue, int blueValue, int greenValue) {
    	this.redValue = redValue;
    	this.blueValue = blueValue;
    	this.greenValue = greenValue;
    }
    
    public int getRedValue() {
    	return redValue;
    }
    
    public int getBlueValue() {
    	return blueValue;
    }
    
    public int getGreenValue() {
    	return greenValue;
    }
}
