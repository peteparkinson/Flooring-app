/**************************************************** 
Program Name: OpenGUI.java 
Programmer's Name: Peter Parkinson 
Program Description: This file instantiates the GUI for the
Flooring app
***********************************************************/


import javax.swing.JFrame;

public class OpenGUI {

	public static void main(String[] args) {		
		
		//opens GUI
		GUI openGUI = new GUI();
		openGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		openGUI.setSize(450, 250);
		openGUI.setVisible(true);

	}

}
