package sjsu.edu.dang.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.util.concurrent.BlockingQueue;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import sjsu.edu.dang.controller.Message;
import sjsu.edu.dang.controller.ResetMessage;
import sjsu.edu.dang.controller.UpdateMessage;

public class View extends JFrame{
    BlockingQueue<Message> queue;
    JTextField redTextField;
    JTextField blueTextField;
    JTextField greenTextField;
    JLabel redLabel;
    JLabel blueLabel;
    JLabel greenLabel;
    
    
    public JLabel redResultLabel;
    public JLabel blueResultLabel;
    public JLabel greenResultLabel;
    
    
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
            int redValue = Integer.parseInt(redTextField.getText());
            int blueValue = Integer.parseInt(blueTextField.getText());
            int greenValue = Integer.parseInt(greenTextField.getText());
            try {
            	Message msg = new UpdateMessage(redValue, blueValue, greenValue);
                queue.put(msg);
            } catch (InterruptedException exception) {
                // do nothing
            }
        });

        resetButton.addActionListener(e -> {
            try {
                queue.put(new ResetMessage());
            } catch (InterruptedException exception) {
                // do nothing
            }
        });
        
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
        
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public void updateHeightInView(int updateRed, int updateBlue, int updateGreen) {
    	this.redResultLabel.setText(String.valueOf("red height: " + updateRed));
    	this.blueResultLabel.setText(String.valueOf("blue height: " +updateBlue));
    	this.greenResultLabel.setText(String.valueOf("green height: " +updateGreen));
    }

    public void resetHeightInView() {
    	String resetNum = "0";
    	this.redResultLabel.setText(String.valueOf("red height: " + resetNum));
    	this.blueResultLabel.setText(String.valueOf("blue height: " +resetNum));
    	this.greenResultLabel.setText(String.valueOf("green height: " +resetNum));
    }
    
}
