package com.hand.Exam2_ClientSocket;

import java.awt.EventQueue;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameWindow frame = new JFrameWindow();
					frame.setVisible(true);
					Action action=new Action();
					action.setWindow(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
    	});
    }
}
