package sjsu.edu.dang.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import sjsu.edu.dang.controller.Message;
import sjsu.edu.dang.controller.ResetMessage;
import sjsu.edu.dang.controller.UpdateMessage;
import sjsu.edu.dang.model.BlueColorModel;
import sjsu.edu.dang.model.GreenColorModel;
import sjsu.edu.dang.model.RedColorModel;


public class View extends JFrame{
    BlockingQueue<Message> queue;
    JTextField redTextField;
    JTextField blueTextField;
    JTextField greenTextField;
    JLabel redLabel;
    JLabel blueLabel;
    JLabel greenLabel;
    
    
    JLabel redResultLabel;
    JLabel blueResultLabel;
    JLabel greenResultLabel;
    
    
    JButton updateButton;
    JButton resetButton;
    
    public View(BlockingQueue<Message> queue, String redColor, String blueColor, String greenColor) {
        this.queue = queue;

        this.redLabel = new JLabel(redColor);
        this.blueLabel = new JLabel(blueColor);
        this.greenLabel = new JLabel(greenColor);
        
        this.redResultLabel = new JLabel(" ");
        this.blueResultLabel = new JLabel(" ");
        this.greenResultLabel = new JLabel(" ");

        this.redTextField = new JTextField(10);
        this.blueTextField = new JTextField(10);
        this.greenTextField = new JTextField(10);
        
        this.updateButton = new JButton("update");
        this.resetButton = new JButton("reset");


        updateButton.addActionListener(e -> {
            String redValue = redTextField.getText();
            String blueValue = blueTextField.getText();
            String greenValue = greenTextField.getText();
            try {
            	Message msg = new UpdateMessage(redValue, blueValue, greenValue);
                queue.put(msg);
            } catch (InterruptedException exception) {
                // do nothing
            }
        });

        resetButton.addActionListener(e -> {
            //String value = textField.getText();
            try {
                queue.put(new ResetMessage());
            } catch (InterruptedException exception) {
                // do nothing
            }
        });
        
        /*

        this.add(redLabel);
        this.add(redTextField);
        
        this.add(blueLabel);
        this.add(blueTextField);
        
        this.add(greenLabel);
        this.add(greenTextField);
        
        this.add(updateButton);
        this.add(resetButton);
        
*/
        
        this.setSize(500, 500);
        this.setLayout(new FlowLayout());
        
       
        Container pane = this.getContentPane();
        this.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        
        updateButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        resetButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        redTextField.setAlignmentX(Component.LEFT_ALIGNMENT);
        blueTextField.setAlignmentX(Component.LEFT_ALIGNMENT);
        greenTextField.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        this.add(redLabel);
        this.add(redTextField);
        
        this.add(blueLabel);
        this.add(blueTextField);
        
        this.add(greenLabel);
        this.add(greenTextField);
        
        this.add(updateButton);
        this.add(resetButton);
        
        this.add(redResultLabel);
        this.add(blueResultLabel);
        this.add(greenResultLabel);
        
        //this.paint(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /*
    public void paint(Graphics g) {
    	g.setColor(Color.RED);
    	g.drawOval(480, 480, 200, 200);
    }
 */

    public void updateHeightInView(int updateRed, int updateBlue, int updateGreen) {
        //this.studentNameLabel.setText(value); //updating LABEL 
    	
    	this.redResultLabel.setText(String.valueOf("red height: " + updateRed));
    	this.blueResultLabel.setText(String.valueOf("blue height: " +updateBlue));
    	this.greenResultLabel.setText(String.valueOf("green height: " +updateGreen));
    }

    public void resetHeightInView() {
        //this.allClassesLabel.setText(classes.toString()); //updating LABEL 
    	String resetNum = "0";
    	this.redResultLabel.setText(String.valueOf("red height: " + resetNum));
    	this.blueResultLabel.setText(String.valueOf("blue height: " +resetNum));
    	this.greenResultLabel.setText(String.valueOf("green height: " +resetNum));
    }
    
}
