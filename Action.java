/**************************************************** 
Program Name: Action.java 
Programmer's Name: Peter Parkinson 
Program Description: This file contains the behavior 
definitions for all buttons.
***********************************************************/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

public class Action implements ActionListener, KeyListener{
	
	//summary button
	//only if all fields are complete, will the program continue.
	//the program also hides and clears key fields, forcing the user
	//to fill all fields and submit valid data
    public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == GUI.showSummaryButton) {
    		if (!GUI.nameField  .getText().isEmpty() &&
				!GUI.streetField.getText().isEmpty() &&
				!GUI.cityField  .getText().isEmpty() &&
				!GUI.stateField .getText().isEmpty() &&
				!GUI.zipField   .getText().isEmpty() &&
				!GUI.areaLabel  .getText().isEmpty() &&
				!GUI.costLabel  .getText().isEmpty()) {
    			
	    		GUI.finalNameLabel.setText  (GUI.nameField  .getText());
	    		GUI.finalStreetLabel.setText(GUI.streetField.getText());
	    		GUI.finalCityLabel.setText  (GUI.cityField  .getText());
	    		GUI.finalStateLabel.setText (GUI.stateField .getText());
	    		GUI.finalZipLabel.setText   (GUI.zipField   .getText());
	    		GUI.finalAreaLabel.setText  (GUI.areaLabel  .getText());
	    		GUI.finalCostLabel.setText  (GUI.costLabel  .getText());
	    		if (GUI.woodRadioButton.isSelected()) {
	    			GUI.finalFloorLabel.setText("Wood");
	    		}
	    		else {GUI.finalFloorLabel.setText("Carpet"); }

	    		GUI.submitOrderButton.setVisible(true);
	    		GUI.jtp.setSelectedIndex(2);
    		}
    		else { JOptionPane.showMessageDialog(null, "Please complete all fields");
    			
    		}
    	}
    	
    	//calculate area button
    	if (e.getSource() == GUI.calculateAreaButton) {
    		//the next if validates digits, and presence of data
    		if (GUI.widthField.getText().trim().matches("^\\d*$") &&
    			GUI.lengthField.getText().trim().matches("^\\d*$")	&&
    			!GUI.widthField.getText().isEmpty() &&
    			!GUI.lengthField.getText().isEmpty()) {
    			
	    		GUI.areaLabel.setText(String.valueOf(
	    				Integer.parseInt(GUI.widthField.getText()) *
	    				Integer.parseInt(GUI.lengthField.getText())
	    		));
	
	    		GUI.carpetRadioButton.setVisible(true);
	    		GUI.woodRadioButton.setVisible(true);
	    		GUI.calculateCostButton.setVisible(true);
    		}
    		else { JOptionPane.showMessageDialog(null, "Invalid entry");
    		}
    	}
    	
    	//calculate cost button
    	if (e.getSource() == GUI.calculateCostButton) {
    		if(GUI.woodRadioButton.isSelected()){
    			GUI.costLabel.setText(String.valueOf(
    				Integer.parseInt(GUI.areaLabel.getText()) * 20));
    		}
    		
    		if(GUI.carpetRadioButton.isSelected()){
    			GUI.costLabel.setText(String.valueOf(
    				Integer.parseInt(GUI.areaLabel.getText()) * 10));
    		}
    		
    		GUI.showSummaryButton.setVisible(true);
    	}
    	
    	//submit order button
    	if (e.getSource() == GUI.submitOrderButton) {

    		String name   = GUI.finalNameLabel  .getText();
    		String street = GUI.finalStreetLabel.getText();
    		String city   = GUI.finalCityLabel  .getText();
    		String state  = GUI.finalStateLabel .getText();
    		String zip    = GUI.finalZipLabel   .getText();
    		String floor  = GUI.finalFloorLabel .getText();
    		
    		int area = Integer.parseInt(GUI.finalAreaLabel.getText());
    		int cost = Integer.parseInt(GUI.finalCostLabel.getText());
    		
    		//build address
    		StringBuilder address = new StringBuilder();
    		address.append(street + ",");
    		address.append(city   + ",");
    		address.append(state  + ",");
    		address.append(zip);
    		
    		//send to DB
    		GUI.orderModel.addElement(new Customer(name, String.valueOf(address), floor, area, cost));
    		try{
    			Customer newCustomer = new Customer(name, String.valueOf(address), floor, area, cost);
    			CustomerDB.AddNewCustomer(newCustomer);
    		}
    		catch(Exception ex){
                System.out.println("Database error");
    		}
    		
    		//clear all fields
    		clearFields();
    		GUI.nameField  .setText("");
    		GUI.streetField.setText("");
    		GUI.cityField  .setText("");
    		GUI.stateField .setText("");
    		GUI.zipField   .setText("");
    		GUI.costLabel  .setText("");
    	}
    	
    	//not sure what this was for
    	if (e.getSource() == GUI.showOrdersButton) {

    	}
    	
    	//goto next tab
    	if (e.getSource() == GUI.nextButton) {
    		GUI.jtp.setSelectedIndex(1);
    	}

    	//clears certain fields
    	if (e.getSource() == GUI.clearButton) {
    		clearFields();
    	}
    	
    	//these clear the "cost label" to create a choke point for the user
    	if (e.getSource() == GUI.carpetRadioButton) {
    		GUI.costLabel.setText("");
    	}
    	
    	if (e.getSource() == GUI.woodRadioButton) {
    		GUI.costLabel.setText("");
    	}
    }

    public void clearFields() {
    	
    	GUI.floorGroup.clearSelection();
    	
		GUI.widthField .setText("");
		GUI.lengthField.setText("");
		GUI.areaLabel  .setText("");
		GUI.costLabel  .setText("");

		GUI.finalNameLabel  .setText("");
		GUI.finalStreetLabel.setText("");
		GUI.finalCityLabel  .setText("");
		GUI.finalStateLabel .setText("");
		GUI.finalZipLabel   .setText("");
		GUI.finalFloorLabel .setText("");
		GUI.finalAreaLabel  .setText("");
		GUI.finalCostLabel  .setText("");
		
		GUI.carpetRadioButton  .setVisible(false);
		GUI.woodRadioButton    .setVisible(false);
		GUI.calculateCostButton.setVisible(false);
		GUI.showSummaryButton  .setVisible(false);
		GUI.submitOrderButton  .setVisible(false);
    }
    
    //declaration of unimplemented methods 
    public void keyTyped(KeyEvent e) {
    	//limit 3 character in width and length fields
    	if (e.getSource() == GUI.widthField &&
    		GUI.widthField.getText().length()>=3	) { 
	    	   e.consume();
    	}
    	if (e.getSource() == GUI.lengthField &&
        		GUI.lengthField.getText().length()>=3	) { 
    	    	   e.consume();
        	}
    	
    }

	public void keyPressed(KeyEvent e) {
		
	}

	public void keyReleased(KeyEvent e) {
		
	}
    
}



