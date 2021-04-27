package sjsu.edu.dang;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import sjsu.edu.dang.controller.Controller;
import sjsu.edu.dang.controller.Message;
import sjsu.edu.dang.model.ColorModel;
import sjsu.edu.dang.view.View;

public class App {
	public static void main(String [] args) {
		BlockingQueue<Message> queue = new LinkedBlockingQueue<>();
		
		ColorModel red = new ColorModel("Red", 0);
		ColorModel blue = new ColorModel("Blue", 0);
		ColorModel green = new ColorModel("Green", 0);
		
		View view = new View(queue, red.getColor(), blue.getColor(), green.getColor());
		Controller controller = new Controller(queue, red, blue, green, view);
	    controller.mainLoop();
	}
}
