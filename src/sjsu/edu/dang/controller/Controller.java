package sjsu.edu.dang.controller;

import java.util.concurrent.BlockingQueue;

import sjsu.edu.dang.model.BlueColorModel;
import sjsu.edu.dang.model.GreenColorModel;
import sjsu.edu.dang.model.RedColorModel;
import sjsu.edu.dang.view.View;

public class Controller {
    BlockingQueue<Message> queue;
    RedColorModel redColorModel;
    BlueColorModel blueColorModel;
    GreenColorModel greenColorModel;
    View view;

    public Controller(BlockingQueue<Message> queue, RedColorModel redColorModel, BlueColorModel blueColorModel, GreenColorModel greenColorModel, View view) {
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
            	UpdateMessage update = (UpdateMessage) message; // (String redValue, String blueValue, String greenValue)
                redColorModel.setHeight(update.getRedValue()); // update model
                blueColorModel.setHeight(update.getBlueValue()); // update model
                greenColorModel.setHeight(update.getGreenValue()); // update model
                view.updateHeightInView(redColorModel.getHeight(), blueColorModel.getHeight(), greenColorModel.getHeight()); // update view
            } else if (message.getClass() == ResetMessage.class) {
            	//update models
            	 redColorModel.setHeight(0); // update model
                 blueColorModel.setHeight(0); // update model
                 greenColorModel.setHeight(0); // update model
                 view.updateHeightInView(redColorModel.getHeight(), blueColorModel.getHeight(), greenColorModel.getHeight()); // update view
            }
    	}
    }
}
