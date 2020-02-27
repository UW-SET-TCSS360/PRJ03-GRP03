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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



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
	private Map<String, Double> alertMap;
	
	/**
	 * A integer value of temperature passed from weather controller.
	 */
	private Double myTemperature;
	
	/**
	 * A integer value of wind speed passed from weather controller.
	 */
	private Double myWindSpeed;
	
	/**
	 * A integer value of rain fall  passed from weather controller.
	 */
	private Double myRainFall;

	/**
	 * A integer value of air pressure passed from weather controller.
	 */
	private Double myAirPressure;

	/**
	 * A boolean flag that checks if an alert has been set or not.
	 */
	private boolean myFlag;
	
	public Alerts() {
		alarmButton = new JButton("Alerts");
		alertMap = new HashMap<>();
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setSize(new Dimension(450,500));
		this.setTitle("Alert and Alarms");
		this.setResizable(false);
		this.setLocationRelativeTo(this);
		
		
		myFlag = false;
		
//		setResizable(false);
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
				Alerts.this.setResizable(false);
			}
		});
		
		startUpInterface();

			

		
	}
	
	/**
	 * A method for initializing all the GUI components for the Alarms window.
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
		
		textValue.setPreferredSize(new Dimension(30,80));
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
					Double tempValue = Double.parseDouble(textValue.getText());
					
					// check if a weather characateristic is selected and a value is entered.
					if (myTemp.isSelected() && !textValue.getText().isEmpty()) {
						alertMap.put("Temp", tempValue);
						myFlag = true;
					} else if (myWind.isSelected() && !textValue.getText().isEmpty()) {
						alertMap.put("Wind Speed",  tempValue);

						myFlag = true;
						System.out.println(alertMap.get("Wind Speed"));
						System.out.println("MAP SIZE: " + alertMap.size());
					} else if (myRain.isSelected() && !textValue.getText().isEmpty()) {
						alertMap.put("Rain",  tempValue);
						myFlag = true;
					} else if (myPressure.isSelected() && !textValue.getText().isEmpty()) {
						alertMap.put("Pressure",  tempValue);
						myFlag = true;
					} 
					
				}
				catch (NumberFormatException excp1) {
					JOptionPane.showMessageDialog(new JFrame(),  "Please enter a valid value. (an integer value).");;
				}
			}
		});
		
			
	}
	
	/**
	 * A class that checks the values coming in from the weather Station byte packet
	 * and compares them to the set alerts in the HashMap. If no alerts match or no alerts were 
	 * set then no alerts window will show up. If there is a match then a new window will open up 
	 * with a warning.
	 * 
	 * @param theValues the HashMap of the weather alerts. 
	 */
	public void checkAlert() {
		// check temperature against stored temp alert in map.
		System.out.println("ANOTHER" + getAlertMap().size());
		System.out.println("HELLO");
		System.out.println("ALERTM MAP SIZE " + alertMap.size());
			if (alertMap.containsKey("Temp") && (myTemperature > alertMap.get("Temp"))) {
				JOptionPane.showMessageDialog(new JFrame(),
						"WARNING \n The Current temperature (fahrenheit) is greater than " + alertMap.get("Temp"));
			} else if (alertMap.containsKey("Pressure") && (myAirPressure > alertMap.get("Pressure"))) {
				JOptionPane.showMessageDialog(new JFrame(),
						"WARNING \n The Current air pressure (bar) is greater than " + alertMap.get("Pressure"));
			} else if (alertMap.containsKey("Rain") && (myRainFall > alertMap.get("Rain"))) {
				JOptionPane.showMessageDialog(new JFrame(),
						"WARNING \n The Current rainfall (in/h) is greater than " + alertMap.get("Rain"));
			} else if (alertMap.containsKey("Wind Speed") && (myWindSpeed > alertMap.get("Wind Speed"))) {
				System.out.println("HELLO");
				JOptionPane.showMessageDialog(new JFrame(),
						"WARNING \n The Current wind speed (mph) is greater than " + alertMap.get("Wind Speed"));
			}



	}
	
	/**
	 * Set method to pass through the temperature from WeatherController.
	 * @param theTemperature integer value of temperature.
	 */
	public void setTemp(int theTemperature) {

		myTemperature = theTemperature / 10.0;

	}
	
	/**
	 * Set method to pass through the wind speed from WeatherController.
	 * @param theWind integer value of wind speed (mph).
	 */
	public void setWindSpeed(int theWind) {
		myWindSpeed = theWind / 1.0;
		System.out.println(myWindSpeed);
	}
	
	/**
	 * Set method to pass through the rain fall from WeatherController.
	 * @param theRain integer value of rain fall 
	 */
	public void setRain(int theRain) {
		myRainFall = theRain / 10.0;
	}
	
	/**
	 * Set method to pass through the air pressure from WeatherController.
	 * @param thePressure integer value of air pressure.
	 */
	public void setPressure(int thePressure) {
		myAirPressure = thePressure / 10.0;
	}

	/**
	 * Returns the button for alarm that will launch the whole alarm window.
	 * @return the alarm button.
	 */
	public JButton getAlarmButton() {
		return alarmButton;
	}

	/**
	 * Returns the hashmap for different alerts.
	 * @return hashmap of alerts.
	 */
	public Map<String, Double> getAlertMap() {
		return alertMap;
	}
}
