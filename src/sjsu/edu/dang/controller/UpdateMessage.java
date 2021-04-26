package sjsu.edu.dang.controller;

public class UpdateMessage implements Message {
	
	String redValue;
	String blueValue;
	String greenValue;
	
    public UpdateMessage(String redValue, String blueValue, String greenValue) {
    	this.redValue = redValue;
    	this.blueValue = blueValue;
    	this.greenValue = greenValue;
    }
    
    public int getRedValue() {
    	return Integer.valueOf(redValue);
    }
    
    public int getBlueValue() {
    	return Integer.valueOf(blueValue);
    }
    
    public int getGreenValue() {
    	return Integer.valueOf(blueValue);
    }
}
