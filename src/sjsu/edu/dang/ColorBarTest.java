package sjsu.edu.dang;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.junit.jupiter.api.Test;
import sjsu.edu.dang.controller.Message;
import sjsu.edu.dang.model.ColorModel;
import sjsu.edu.dang.view.View;

class ColorBarTest {

	@Test
	void updateTest() {
		
		ColorModel red = new ColorModel("Red", 0);
		ColorModel blue = new ColorModel("Blue", 0);
		ColorModel green = new ColorModel("Green", 0);
	    
	    red.setHeight(7); // update model
        blue.setHeight(-6); // update model
        green.setHeight(4); // update model
       
        int redActual = red.getHeight();
        int blueActual = blue.getHeight();
        int greenActual = green.getHeight();
        
        int redExpected = 7;
        int blueExpected = 0;
        int greenExpected = 4;
		
		assertEquals(redExpected, redActual);
		assertEquals(blueExpected, blueActual);
		assertEquals(greenExpected, greenActual);
	}

}
