package sjsu.edu.dang;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import sjsu.edu.dang.controller.Controller;
import sjsu.edu.dang.controller.Message;
import sjsu.edu.dang.model.BlueColorModel;
import sjsu.edu.dang.model.GreenColorModel;
import sjsu.edu.dang.model.RedColorModel;
import sjsu.edu.dang.view.View;

public class App {
	public static void main(String [] args) {
		BlockingQueue<Message> queue = new LinkedBlockingQueue<>();
		RedColorModel red = new RedColorModel();
		BlueColorModel blue = new BlueColorModel();
		GreenColorModel green = new GreenColorModel();
		View view = new View(queue, red.getColor(), blue.getColor(), green.getColor());
		Controller controller = new Controller(queue, red, blue, green, view);
	    controller.mainLoop();
	}
}
