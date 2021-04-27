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
		BlockingQueue<Message> queue = new LinkedBlockingQueue<>();
		
		ColorModel red = new ColorModel("Red", 0);
		ColorModel blue = new ColorModel("Blue", 0);
		ColorModel green = new ColorModel("Green", 0);
		
		View view = new View(queue, red.getColor(), blue.getColor(), green.getColor());
	    
	    red.setHeight(7); // update model
        blue.setHeight(-6); // update model
        green.setHeight(4); // update model
        view.updateHeightInView(red.getHeight(), blue.getHeight(), green.getHeight()); // update view
        
        String redActual = view.redResultLabel.getText();        
        String blueActual = view.blueResultLabel.getText();
        String greenActual = view.greenResultLabel.getText();
	    
		String redExpected = "red height: 7";
		String blueExpected = "blue height: 0";;
		String greenExpected = "green height: 4";;
		
		assertEquals(redExpected, redActual);
		assertEquals(blueExpected, blueActual);
		assertEquals(greenExpected, greenActual);
	}

}
