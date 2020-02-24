import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

// TEsting Hyelin

// Testing Ilya

// Testing Elias
/**
 * The main GUI for the weather console.
 * 
 * @author Group 1, Ilya Bokov, Elias Salmo, Nicholas Babcock
 * @version 13 February, 2020
 */
public class WeatherGUI extends JFrame {
    /**
     * The unique ID for the Serializable interface
     */
    private static final long serialVersionUID = 562997229458227901L;

    /**
     * The title for the application window.
     */
    private static final String TITLE = "Weather Station";

    /**
     * The number of moon phase images there are, will be used to create the
     * ImageIcon array.
     */
    private static final int NUM_MOON_IMAGES = 8;

    /**
     * The number of weather icons there will be. Will be used to create an
     * ImageIcon array for weather icons.
     */
    private static final int NUM_WEATHER_ICONS = 8;

    /**
     * Shows the temperature
     */
    private JLabel tempReadout;
    /**
     * Shows the humidity
     */
    private JLabel humidReadout;
    /**
     * Shows the pressure
     */
    private JLabel pressureReadout;
    /**
     * Shows the graph
     */
    private GraphPanel graphPanel;
    /**
     * Shows the wind data
     */
    private WindPanel windPanel;
    /**
     * Shows the moon phase
     */
    private JLabel moonReadout;
    /**
     * Shows the moon phase text
     */
    private JLabel moonLabel;
    /**
     * holds the images for each moon phase
     */
    private ImageIcon[] moonImages = new ImageIcon[NUM_MOON_IMAGES];

    private ImageIcon[] weatherIcon = new ImageIcon[NUM_WEATHER_ICONS];

    /**
     * Shows the rainfall
     */
    private JLabel rainReadout;
    /**
     * Shows the date
     */
    private JLabel dateReadout;
    /**
     * Shows the time
     */
    private JLabel timeReadout;
    /**
     * Shows the time of sunrise
     */
    private JLabel sunriseReadout;
    /**
     * Shows the time of sunset
     */
    private JLabel sunsetReadout;

    /**
     * Shows the weatherIcon.
     */
    private JLabel weatherLabel;

    /**
     * The about window that provides information about the Weather Vantage Vue.
     */
    private About AboutInfo;

    /**
     * Instantiates the alert window in the GUI.
     */
    private Alerts alertAlarm;

    /**
     * Constructor for weather gui.
     * @param theAlert
     */
    public WeatherGUI(Alerts theAlert) {
        alertAlarm = theAlert;
        start();
    }

    /**
     * The method that will initialize the GUI to its default starting state.
     */
    public void start() {

        this.setTitle(TITLE);
        // this.setLayout(new FlowLayout());
        this.setLayout(new BorderLayout());

        // Sets the initial size and position of the application window
        setSize(1100, 530);
        setLocationRelativeTo(null);

        JPanel tempPanel = new JPanel();
        tempPanel.setBorder(BorderFactory.createLineBorder(Color.white));
        tempReadout = new JLabel("Temp: -- °F");
        tempPanel.add(tempReadout);

        JPanel humidPanel = new JPanel();
        humidPanel.setBorder(BorderFactory.createLineBorder(Color.white));
        humidReadout = new JLabel("Humid: -- %");
       
        humidPanel.add(humidReadout);

        JPanel pressurePanel = new JPanel();
        pressurePanel.setBorder(BorderFactory.createLineBorder(Color.white));
        pressureReadout = new JLabel("Pressure: -- in");
        pressurePanel.add(pressureReadout);

        graphPanel = new GraphPanel(getWidth() / 2, getHeight() / 2);
        windPanel = new WindPanel(getHeight() / 9);
        windPanel.setPreferredSize(new Dimension(150, 150));

        JPanel moonPanel = new JPanel();
        moonReadout = new JLabel();
        moonReadout.setPreferredSize(new Dimension(110, 25));
        moonLabel = new JLabel();
        moonPanel.add(moonLabel);
        moonPanel.add(moonReadout);
        moonPanel.setPreferredSize(new Dimension(190, 25));

        JPanel weatherPanel = new JPanel();
        weatherLabel = new JLabel();
        weatherPanel.add(weatherLabel);
        weatherPanel.setPreferredSize(new Dimension(50, 20));

        JPanel rainPanel = new JPanel();
        rainPanel.setBorder(BorderFactory.createLineBorder(Color.white));
        rainReadout = new JLabel("Rain: -- in./hr.");
        rainPanel.add(rainReadout);

        JPanel datePanel = new JPanel();
        datePanel.setBorder(BorderFactory.createLineBorder(Color.white));
        dateReadout = new JLabel("Date: ---, --- --, ----");
        datePanel.add(dateReadout);

        JPanel timePanel = new JPanel();
        timePanel.setBorder(BorderFactory.createLineBorder(Color.white));
        timeReadout = new JLabel("Time: --:--:-- a.m.");
        timePanel.add(timeReadout);

        JPanel sunrisePanel = new JPanel();
        sunrisePanel.setBorder(BorderFactory.createLineBorder(Color.white));
        sunriseReadout = new JLabel("Sunrise: --:-- a.m.");
        sunrisePanel.add(sunriseReadout);

        JPanel sunsetPanel = new JPanel();
        sunsetPanel.setBorder(BorderFactory.createLineBorder(Color.white));
        sunsetReadout = new JLabel("Sunset: --:-- p.m.");
        sunsetPanel.add(sunsetReadout);

        AboutInfo = new About();
        JButton aboutButton = new JButton("About Info");

        aboutButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                AboutInfo.setVisible(true);

            }
        });

        JPanel northLayoutPanel = new JPanel();
        northLayoutPanel.setLayout(new BorderLayout());

        JPanel eastLayoutPanel = new JPanel();
        eastLayoutPanel.setLayout(new BoxLayout(eastLayoutPanel, BoxLayout.Y_AXIS));

        JPanel southLayoutPanel = new JPanel();
        southLayoutPanel.setLayout(new GridLayout(2, 4, 40, 20));

        JPanel dataNorth = new JPanel();
        dataNorth.setLayout(new FlowLayout());

        JPanel buttonNorth = new JPanel();
        buttonNorth.setLayout(new FlowLayout());
        // Example Button addition into the South Panel Layout
        // ADD BUTTONS TO SOUTH PANEL.
        JButton tempButton = new JButton(new GraphButtonAction(GraphPanel.TEMP_SENSOR, "Graph Temperature"));
        JButton pressureButton = new JButton(new GraphButtonAction(GraphPanel.PRESSURE_SENSOR, "Graph Pressure"));
        JButton humidityButton = new JButton(new GraphButtonAction(GraphPanel.HUMIDITY_SENSOR, "Graph Humidity"));
        JButton rainfallButton = new JButton(new GraphButtonAction(GraphPanel.RAINFALL_SENSOR, "Graph Rainfall"));
        JButton windspeedButton = new JButton(new GraphButtonAction(GraphPanel.WIND_SENSOR, "Graph Wind Speed"));
	JButton close = new JButton("System shut down");
        close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					Storage.tempWriter.close();
					Storage.humWriter.close();
					Storage.presWriter.close();
					Storage.speedWriter.close();
					Storage.dirWriter.close();
					Storage.phaseWriter.close();
					Storage.rainWriter.close();
					Storage.sunRiseWriter.close();
					Storage.sunSetWriter.close();
					Storage.wIconWriter.close();
					System.exit(0);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	    
        
        JFrame frame = new JFrame();

        JLabel previousLabel = new JLabel("Please select one.");
        JPanel previousPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        previousPanel.setLayout(new BorderLayout());
        buttonPanel.setLayout(new FlowLayout());

        JButton hours = new JButton("Hours");
        JButton days = new JButton("Days");
        JButton months = new JButton("Months");

        // Button for previous data
        JButton previousDataButton = new JButton("Get Snapshot");
        previousDataButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                JDialog dis = new JDialog(frame, "Get Snapshot", true);
                
                hours.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TODO Auto-generated method stub
                        JDialog hourDialog = new JDialog(frame, "Previous Hours", true);
                        JPanel hourPanel = new JPanel();
                        hourDialog.add(hourPanel);
                        hourDialog.setSize(500, 300);
                        hourDialog.setResizable(false);
                        hourDialog.setLocationRelativeTo(frame);
                        hourDialog.setVisible(true);
                        dis.dispose();
                        hourDialog.setDefaultCloseOperation(EXIT_ON_CLOSE);
                        
                     
                    }
                });
               
                days.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TODO Auto-generated method stub
                        JDialog dayDialog = new JDialog(frame, "Previous Days", true);
                        JPanel dayPanel = new JPanel();
                        dayDialog.add(dayPanel);
                        dayDialog.setSize(500, 300);
                        dayDialog.setResizable(false);
                        dayDialog.setLocationRelativeTo(frame);
                        dayDialog.setVisible(true);
                        dis.dispose();
                        dayDialog.setDefaultCloseOperation(EXIT_ON_CLOSE);
                        
                    }
                });
                
                months.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TODO Auto-generated method stub
                        JDialog monthDialog = new JDialog(frame, "Previous Months", true);
                        JPanel monthPanel = new JPanel();
                        monthDialog.add(monthPanel);
                        monthDialog.setSize(500, 300);
                        monthDialog.setResizable(false);
                        monthDialog.setLocationRelativeTo(frame);
                        monthDialog.setVisible(true);
                        dis.dispose();
                        monthDialog.setDefaultCloseOperation(EXIT_ON_CLOSE);
                        
                    }
                    
                });
              
                buttonPanel.add(hours);
                buttonPanel.add(days);
                buttonPanel.add(months);

                previousPanel.add(previousLabel, BorderLayout.CENTER);
                previousPanel.add(buttonPanel, BorderLayout.SOUTH);
                dis.add(previousPanel);

                dis.setSize(500, 100);
                dis.setResizable(false);
                dis.setLocationRelativeTo(frame);
                dis.setVisible(true);
            }
        });

        // Button for alert

        //JButton alertButton = alertAlarm.getAlarmButton();
        
        // Button for about
        JButton aboutButtonTop = new JButton("About");
        aboutButtonTop.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                JTabbedPane aboutTab = new JTabbedPane();
                JTextArea about = new JTextArea();
                JTextArea getSanpshot = new JTextArea();
                JTextArea alert = new JTextArea();
                about.setEditable(false);
                getSanpshot.setEditable(false);
                alert.setEditable(false);
                about.append("Our weather stations help professionals and" + "\n"
                        + "hobbyists measure, monitor, and manage weather data. ");
                getSanpshot.append("about get snapshot");
                alert.append("about alert");
                aboutTab.addTab("About", about);
                aboutTab.addTab("About Get Snapshot", getSanpshot);
                aboutTab.addTab("About Alert", alert);
                JDialog dis = new JDialog(frame, "About", true);
                dis.add(aboutTab);
                dis.setSize(350, 350);
                dis.setResizable(false);
                dis.setLocationRelativeTo(frame);
                dis.setVisible(true);
            }
        });

        southLayoutPanel.add(tempButton);
        southLayoutPanel.add(pressureButton);
        southLayoutPanel.add(humidityButton);
        southLayoutPanel.add(rainfallButton);
        southLayoutPanel.add(windspeedButton);
        southLayoutPanel.add(aboutButton);

        buttonNorth.add(previousDataButton);
//        buttonNorth.add(alertButton);
        buttonNorth.add(aboutButtonTop);
        buttonNorth.add(close);
	    
        dataNorth.add(tempPanel);
        dataNorth.add(humidPanel);
        dataNorth.add(pressurePanel);
        dataNorth.add(rainPanel);
        dataNorth.add(datePanel);
        dataNorth.add(timePanel);
        dataNorth.add(sunrisePanel);
        dataNorth.add(sunsetPanel);

        northLayoutPanel.add(buttonNorth, BorderLayout.WEST);
        northLayoutPanel.add(alertAlarm.getAlarmButton(), BorderLayout.CENTER);
        northLayoutPanel.add(dataNorth, BorderLayout.SOUTH);

        eastLayoutPanel.add(windPanel);
        eastLayoutPanel.add(moonPanel);
        eastLayoutPanel.add(weatherPanel);
        
        add(northLayoutPanel, BorderLayout.NORTH);
        add(eastLayoutPanel, BorderLayout.EAST);
        add(southLayoutPanel, BorderLayout.SOUTH);
        add(graphPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Sets the temperature
     * 
     * @param temp the temperature to set
     */
    public void setTemp(int temp) {
        String raw = Integer.toString(temp);
        tempReadout
                .setText("Temp: " + raw.substring(0, raw.length() - 1) + "." + raw.substring(raw.length() - 1) + " °F");
        if (graphPanel != null) {
            graphPanel.updateSensorValue(GraphPanel.TEMP_SENSOR, temp);
        }
    }

    /**
     * Sets the humidity
     * 
     * @param humid the humidity to set
     */
    public void setHumid(int humid) {
        humidReadout.setText("Humid: " + Integer.toString(humid) + " %");
        if (graphPanel != null) {
            graphPanel.updateSensorValue(GraphPanel.HUMIDITY_SENSOR, humid);
        }
    }

    /**
     * Sets the pressure
     * 
     * @param pressure to set
     */
    public void setPressure(int pressure) {
        String raw = Integer.toString(pressure);
        pressureReadout.setText(
                "Pressure:" + raw.substring(0, raw.length() - 3) + "." + raw.substring(raw.length() - 3) + " in.");
        if (graphPanel != null) {
            graphPanel.updateSensorValue(GraphPanel.PRESSURE_SENSOR, pressure);
        }
    }

    /**
     * Sets the wind velocity
     * 
     * @param windspd the speed of the wind
     * @param winddir the direction of the wind
     */
    public void setWind(int windspd, int winddir) {
        windPanel.updateWind(windspd, winddir);
        if (graphPanel != null) {
            graphPanel.updateSensorValue(GraphPanel.WIND_SENSOR, windspd);
        }
    }

    /**
     * Method creates the 8 moon phase icons and all the moon phase names.
     * 
     * @param moon the integer value indicating which moon to show. Comes from
     *             WeatherController.java
     */
    public void setMoonPhase(int moon) {
        // Create array of lunar choices lunar phase choices.
        String[] phases = { "New", "Waxing Crescent", "First Quarter", "Waxing Gibbous", "Full", "Waning Gibbous",
                "Third Quarter", "Waning Crescent" };

        // Retrieves the images and places them into an ImageIcon array.
        for (int i = 0; i < NUM_MOON_IMAGES; i++) {
            String imageName = "image" + i + ".png";
            URL url = getClass().getResource(String.format("/Lunar_Phases/%s", imageName));

            ImageIcon icon = new ImageIcon(url);
            Image image = icon.getImage();
            Image newImg = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(newImg);
            moonImages[i] = resizedIcon;
        }

        moonReadout.setText(phases[moon]);
        moonLabel.setIcon(moonImages[moon]);
    }

    /**
     * Based on the weather data received from the weather controller, the
     * setWeatherIcon will assign a weather icon. Example: Rain is high and its 32
     * degrees outside. The weather Icon will be snowing.
     * 
     * @param weatherData -> an integer value that will tell us which weather icon
     *                    to use.
     */
    public void setWeatherIcon(int weatherData) {

        // Retrieves the weather images and places them into an ImageIcon array.
        for (int i = 0; i < NUM_WEATHER_ICONS; i++) {
            String imageName = "image" + i + ".png";
            URL url = getClass().getResource(String.format("/Weather_Icons/%s", imageName));

            ImageIcon icon = new ImageIcon(url);
            Image image = icon.getImage();
            Image newImg = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(newImg);
            weatherIcon[i] = resizedIcon;
        }
        weatherLabel.setIcon(weatherIcon[weatherData]);
    }

    /**
     * Set the current rainfall rate
     * 
     * @param rain rainfall to set
     */
    public void setRain(int rain) {
        String raw = Integer.toString(rain);
        rainReadout.setText(
                "Rain: " + raw.substring(0, raw.length() - 1) + "." + raw.substring(raw.length() - 1) + " in./hr.");
        if (graphPanel != null) {
            graphPanel.updateSensorValue(GraphPanel.RAINFALL_SENSOR, rain);
        }
    }

    /**
     * Set the current date
     * 
     * @param date The current date
     */
    public void setDate(Date date) {
        String raw = date.toString();
        dateReadout.setText("Date: " + raw.substring(0, 3) + ", " + raw.substring(4, 7) + " " + raw.substring(8, 10)
                + ", " + raw.substring(raw.length() - 4));

    }

    /**
     * Set the current time
     * 
     * @param time The current time of day
     */
    public void setTime(Date time) {
        String raw = time.toString();
        int timePeriod = Integer.valueOf(raw.substring(11, 13));
        if (timePeriod < 12) {
            if (timePeriod == 0) {
                timeReadout.setText("Time: 12" + raw.substring(13, 19) + " AM");
            } else {
                timeReadout.setText("Time: " + raw.substring(11, 19) + " AM");
            }
        } else {
            if (timePeriod == 12) {
                timeReadout.setText("Time: 12" + raw.substring(13, 19) + " PM");
            } else {
                timeReadout.setText("Time: " + Integer.toString((timePeriod - 12)) + raw.substring(13, 19) + " PM");
            }
        }
    }

    /**
     * Sets the time of sunrise
     * 
     * @param sunrise the time of sunrise to set
     */
    public void setSunrise(int sunrise) {
        sunriseReadout.setText(
                "Sunrise: 0" + Integer.toString(sunrise / 100) + ":" + String.format("%02d", sunrise % 100) + " AM");
    }

    /**
     * Sets the time of sunset
     * 
     * @param sunset the time of sunset to set
     */
    public void setSunset(int sunset) {
        sunsetReadout.setText(
                "Sunset: 0" + Integer.toString(sunset / 100) + ":" + String.format("%02d", sunset % 100) + " PM");
    }

    /**
     * Return the current date
     * 
     * @return current date
     */
    public String getDate() {
        return dateReadout.getText();
    }

    /**
     * Return the current time
     * 
     * @return current time
     */
    public String getTime() {
        return timeReadout.getText();
    }

    /**
     * Return the estimated time of sunrise
     * 
     * @return sunrise time
     */
    public String getSunrise() {
        return sunriseReadout.getText();
    }

    /**
     * Return the estimate time of sunset
     * 
     * @return sunset time
     */
    public String getSunset() {
        return sunsetReadout.getText();
    }

    public void graphTick() {
        if (graphPanel != null) {
            graphPanel.updateDisplay();
        }
    }

    /**
     * The action for each of the graph buttons that will change what the graph
     * graphs.
     * 
     * @author Group 6
     */
    private class GraphButtonAction extends AbstractAction {
        /**
         * The ID for the Serializable interface
         */
        private static final long serialVersionUID = 3612147189752191515L;
        /**
         * The sensor type to have the graph start showing
         */
        private int type;

        /**
         * The constructor for the Action
         * 
         * @param type       the sensor type that the button will cause the graph to
         *                   start showing
         * @param buttonName the name of the button
         */
        public GraphButtonAction(int type, String buttonName) {
            super(buttonName);
            this.type = type;
        }

        /**
         * Performs the actual setting of the graph sensor type
         * 
         * @param e the action event for the button pressed, will be not be used
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            graphPanel.setSensorType(type);
        }
    }
}
