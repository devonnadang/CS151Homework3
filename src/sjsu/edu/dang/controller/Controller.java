package sjsu.edu.dang.controller;

import java.util.concurrent.BlockingQueue;

import sjsu.edu.dang.model.ColorModel;
import sjsu.edu.dang.view.View;

public class Controller {
    BlockingQueue<Message> queue;
    ColorModel redColorModel;
    ColorModel blueColorModel;
    ColorModel greenColorModel;
    View view;

    public Controller(BlockingQueue<Message> queue, ColorModel redColorModel, ColorModel blueColorModel, ColorModel greenColorModel, View view) {
        this.queue = queue;
        this.view = view;
        this.redColorModel = redColorModel;
        this.blueColorModel = blueColorModel;
        this.greenColorModel = greenColorModel;
    }
    
	public void mainLoop() {
    	while (view.isDisplayable()) {
    		Message message = null;
            try {
                message = queue.take(); // takes in which button was clicked
            } catch (InterruptedException exception) {
                // do nothing
            }

            if(message.getClass() == UpdateMessage.class) {
                // button updateStudentName was clicked
            	UpdateMessage update = (UpdateMessage) message; 
                redColorModel.setHeight(update.getRedValue()); // update model
                blueColorModel.setHeight(update.getBlueValue()); // update model
                greenColorModel.setHeight(update.getGreenValue()); // update model
                view.updateHeightInView(redColorModel.getHeight(), blueColorModel.getHeight(), greenColorModel.getHeight()); // update view
            } else if (message.getClass() == ResetMessage.class) {
            	//update models
            	ResetMessage reset = (ResetMessage) message;
            	 redColorModel.reset(); // update model
                 blueColorModel.reset(); // update model
                 greenColorModel.reset(); // update model
                 view.updateHeightInView(redColorModel.getHeight(), blueColorModel.getHeight(), greenColorModel.getHeight()); // update view
            }
    	}
    }
}
