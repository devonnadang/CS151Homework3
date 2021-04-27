package sjsu.edu.dang.controller;

public class ResetMessage implements Message {
	
    	int redValue;
    	int blueValue;
    	int greenValue;
    	
        public ResetMessage() {
        	redValue = 0;
        	blueValue = 0;
        	greenValue = 0;
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
