/**************************************************** 
Program Name: GUI.java 
Programmer's Name: Peter Parkinson 
Program Description: This file defines the GUI for the
Flooring app
***********************************************************/


import java.awt.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GUI extends JFrame{
	
	static JButton calculateAreaButton = new JButton("Calculate Area");
	static JButton calculateCostButton = new JButton("Calculate Cost");
	static JButton submitOrderButton   = new JButton("Submit");
	static JButton showSummaryButton   = new JButton("Next");
	static JButton nextButton          = new JButton("Next");
	static JButton showOrdersButton    = new JButton("Show Orders");
	static JButton clearButton         = new JButton("Clear");

	static JTextField nameField   = new JTextField(15);
	static JTextField streetField = new JTextField(15);
	static JTextField cityField   = new JTextField(15);
	static JTextField stateField  = new JTextField(15);
	static JTextField zipField    = new JTextField(15);
	static JTextField lengthField = new JTextField(15);
	static JTextField widthField  = new JTextField(15);

	static JLabel areaLabel    = new JLabel("");
	static JLabel costLabel    = new JLabel("");

	JLabel nameLabel    = new JLabel("Name");
	JLabel nameLabel1   = new JLabel("Name:");
	JLabel streetLabel  = new JLabel("Street");
	JLabel cityLabel    = new JLabel("City");
	JLabel stateLabel   = new JLabel("State");
	JLabel zipLabel     = new JLabel("Zip");
	JLabel addressLabel = new JLabel("Address:");
	JLabel lengthLabel  = new JLabel("Length of Room");
	JLabel widthLabel   = new JLabel("Width of Room");
	JLabel areaLabel1   = new JLabel("Area: sq ft:");
	JLabel areaLabel2   = new JLabel("Area: sq ft:");
	JLabel floorLabel1   = new JLabel("Type:");
	JLabel floorLabel2   = new JLabel("Type:");
	JLabel costLabel1   = new JLabel("Cost: $");
	JLabel costLabel2   = new JLabel("Cost: $");
	JLabel customerLabel= new JLabel("Customer");
	JLabel orderLabel   = new JLabel("Order");
	JLabel placeHolder1 = new JLabel("");
	JLabel placeHolder2 = new JLabel("");
	JLabel placeHolder3 = new JLabel("");
	JLabel placeHolder4 = new JLabel("");
	JLabel placeHolder5 = new JLabel("");
	JLabel placeHolder6 = new JLabel("");
	
	//to be verified by user then submitted to DB
	static JLabel finalNameLabel   = new JLabel("");
	static JLabel finalStreetLabel = new JLabel("");
	static JLabel finalCityLabel   = new JLabel("");
	static JLabel finalStateLabel  = new JLabel("");
	static JLabel finalZipLabel    = new JLabel("");
	static JLabel finalFloorLabel  = new JLabel("");
	static JLabel finalAreaLabel   = new JLabel("");
	static JLabel finalCostLabel   = new JLabel("");

	static JLabel viewNameLabel    = new JLabel("");
	static JLabel viewAddressLabel = new JLabel("");
	static JLabel viewFloorLabel   = new JLabel("");
	static JLabel viewAreaLabel    = new JLabel("");
	static JLabel viewCostLabel    = new JLabel("");
	
	static JRadioButton carpetRadioButton = new JRadioButton("Carpet");
	static JRadioButton woodRadioButton   = new JRadioButton("Wood");
	
	static ButtonGroup floorGroup = new ButtonGroup();
	
	static JTabbedPane jtp = new JTabbedPane();
	JScrollPane jsp = new JScrollPane();

	JPanel customerInfoTab  = new JPanel();
	JPanel newOrderTab      = new JPanel();
	JPanel viewOrdersTab    = new JPanel();
	JPanel finalizeOrderTab = new JPanel();
	JPanel viewOrderPanel   = new JPanel();
	
	static JList<Customer> ordersList = new JList<>();
	static DefaultListModel<Customer> orderModel = new DefaultListModel<Customer>();
	
	Font font1 = new Font("",Font.BOLD,16);
	
	public GUI() {
		super("Flooring Order Manager");
		//setLayout(new GridLayout(0,2,5,5));
		viewOrdersTab.setLayout   (new GridLayout(0,2,5,5));
		newOrderTab.setLayout     (new GridLayout(0,2,5,5));
		customerInfoTab.setLayout (new GridLayout(0,2,5,5));
		finalizeOrderTab.setLayout(new GridLayout(0,3));
		viewOrderPanel.setLayout  (new GridLayout(0,2));
		

        customerLabel.setFont(font1);
        orderLabel.setFont(font1);
        
		carpetRadioButton  .setVisible(false);
		woodRadioButton    .setVisible(false);
		calculateCostButton.setVisible(false);
		showSummaryButton  .setVisible(false);
		submitOrderButton  .setVisible(false);
		
		ordersList.setPreferredSize(new Dimension(150,140));

		ordersList.setModel(orderModel);
		ordersList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				
		//test data for JList
		orderModel.addElement(new Customer("Pete", "addy goes here", "floor type", 20, 20));
		
		floorGroup.add(carpetRadioButton);	
		floorGroup.add(woodRadioButton);

		customerInfoTab.add(nameLabel);
		customerInfoTab.add(nameField);
		customerInfoTab.add(streetLabel);
		customerInfoTab.add(streetField);
		customerInfoTab.add(cityLabel);
		customerInfoTab.add(cityField);
		customerInfoTab.add(stateLabel);
		customerInfoTab.add(stateField);
		customerInfoTab.add(zipLabel);
		customerInfoTab.add(zipField);
		customerInfoTab.add(placeHolder1);
		customerInfoTab.add(nextButton);

		newOrderTab.add(widthLabel);
		newOrderTab.add(widthField);
		newOrderTab.add(lengthLabel);
		newOrderTab.add(lengthField);
		newOrderTab.add(calculateAreaButton);
		newOrderTab.add(areaLabel);
		newOrderTab.add(woodRadioButton);
		newOrderTab.add(carpetRadioButton);
		newOrderTab.add(calculateCostButton);
		newOrderTab.add(costLabel);
		newOrderTab.add(clearButton);
		newOrderTab.add(showSummaryButton);

		finalizeOrderTab.add(customerLabel);
		finalizeOrderTab.add(placeHolder2);
		finalizeOrderTab.add(orderLabel);
		finalizeOrderTab.add(finalNameLabel);
		finalizeOrderTab.add(floorLabel1);
		finalizeOrderTab.add(finalFloorLabel);
		finalizeOrderTab.add(finalStreetLabel);
		finalizeOrderTab.add(areaLabel1);
		finalizeOrderTab.add(finalAreaLabel);
		finalizeOrderTab.add(finalCityLabel);
		finalizeOrderTab.add(costLabel1);
		finalizeOrderTab.add(finalCostLabel);	
		finalizeOrderTab.add(finalStateLabel);
		finalizeOrderTab.add(placeHolder4);
		finalizeOrderTab.add(placeHolder5);
		finalizeOrderTab.add(finalZipLabel);
		finalizeOrderTab.add(placeHolder6);
		finalizeOrderTab.add(submitOrderButton);

		

		viewOrderPanel.add(nameLabel1);
		viewOrderPanel.add(viewNameLabel);
		viewOrderPanel.add(addressLabel);
		viewOrderPanel.add(viewAddressLabel);
		viewOrderPanel.add(floorLabel2);
		viewOrderPanel.add(viewFloorLabel);
		viewOrderPanel.add(areaLabel2);
		viewOrderPanel.add(viewAreaLabel);
		viewOrderPanel.add(costLabel2);
		viewOrderPanel.add(viewCostLabel);
		
		viewOrdersTab.add(new JScrollPane(ordersList));
		viewOrdersTab.add(viewOrderPanel);
		
		jtp.addTab("Customer Info", customerInfoTab);
		jtp.addTab("New Order", newOrderTab);
		jtp.addTab("Finalize Order", finalizeOrderTab);
		jtp.addTab("View Orders", viewOrdersTab);
		
		add(jtp);

		calculateAreaButton.addActionListener(new Action());
		calculateCostButton.addActionListener(new Action());
		submitOrderButton  .addActionListener(new Action());
		showSummaryButton  .addActionListener(new Action());
		nextButton         .addActionListener(new Action());
		showOrdersButton   .addActionListener(new Action());
		clearButton		   .addActionListener(new Action());
		woodRadioButton	   .addActionListener(new Action());
		carpetRadioButton  .addActionListener(new Action());

		widthField .addKeyListener(new Action());
		lengthField.addKeyListener(new Action());
	
		ordersList .addListSelectionListener(
	        new ListSelectionListener()
	        {
	            public void valueChanged(ListSelectionEvent event){
					if (ordersList.getSelectedIndex() != -1){
						Customer e = ordersList.getSelectedValue();

		        		viewNameLabel.setText(e.getName());
		        		viewAddressLabel.setText(e.getAddress());
		        		viewFloorLabel.setText(e.getFloorType());
		        		viewAreaLabel.setText(String.valueOf(e.getArea()));
		        		viewCostLabel.setText(String.valueOf(e.getCost()));

					}
	
	            }
	        });
	}
}
