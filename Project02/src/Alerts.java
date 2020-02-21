import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import sun.jvm.hotspot.debugger.Page;
import sun.util.BuddhistCalendar;

/**
 * An alerts class that provides a GUI window for the user to set specific parameters on when they
 * wanted to be alerted. For example, if wind speed reaches 40+mph a window would pop up that mentions 
 * the alert. 
 * @author ilyabokov
 * @version 18 February, 2020
 */
public class Alerts extends JFrame {

	/**
	 * A generated serial ID.
	 */
	private static final long serialVersionUID = -1032035933702622023L;

	/**
	 * JButton for opening the alarm window.
	 */
	private JButton alarmButton;
	
	/**
	 * A storage of all the set alarms using a map, that contains all the thresholds.
	 */
	private Map<String, Integer> alertMap;
	
	public Alerts() {
		alarmButton = new JButton("Alerts");
		alertMap = new HashMap<>();
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setSize(new Dimension(300,400));
		this.setTitle("Alert and Alarms");
		
		this.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				alarmButton.setEnabled(false);
			}
			
			@Override
			public void windowClosing(WindowEvent arg0) {
				alarmButton.setEnabled(true);
			}
		});
		
		alarmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Alerts.this.setVisible(true);
			}
		});
		
		startUpInterface();
			
		
		
	}
	
	/**
	 * A method for initiallizing all the GUI components for the Alarms window.
	 */
	private void startUpInterface() {
		JButton addAlert = new JButton("Add Alert");
		JTextField textValue = new JTextField();
		ButtonGroup buttonGroup = new ButtonGroup(); 
		JRadioButton myTemp = new JRadioButton("Temperature (F)"), 
					 myWind = new JRadioButton("Wind Speed (mph)"),
					 myRain = new JRadioButton("Rainfall (in)"),
					 myPressure = new JRadioButton("Air Pressure (bar)");
		String[] sign = {">"};
		JComboBox<String> comboBox = new JComboBox<String>(sign);
		
		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		
		textValue.setPreferredSize(new Dimension(50,50));
		textValue.setVisible(true);
		textValue.setEnabled(true);
		
		leftPanel.setLayout(new GridLayout(2, 2));
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.PAGE_AXIS));
		
		//Adding the components together.
		buttonGroup.add(myTemp);
		buttonGroup.add(myWind);
		buttonGroup.add(myRain);
		buttonGroup.add(myPressure);
		
		myWind.setSelected(true);
		
		// Adding to left and right panels.
		leftPanel.add(myTemp);
		leftPanel.add(myWind);
		leftPanel.add(myRain);
		leftPanel.add(myPressure);
		
		rightPanel.add(textValue);
		rightPanel.add(comboBox);
		rightPanel.add(addAlert);
		
		this.add(leftPanel, BorderLayout.WEST);
		this.add(rightPanel, BorderLayout.EAST);
		
		addAlert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Integer temp = Integer.parseInt(textValue.getText());
					
					// check if a weather characateristic is selected and a value is entered.
					if (myTemp.isSelected() && !textValue.getText().isEmpty()) {
						alertMap.put("Temp", temp);
						
					}
				}
			}
		});
		
		
		
	}
	
	
	
	
}
