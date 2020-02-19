import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

/**
 * A class about the relevent information for the Weather Vantage Vue system. 
 * A simple description of all the components. 
 * @author Ilya Bokov
 * @version February 14, 2020
 *
 */
public class About extends JFrame {

	/**
	 * A generated serial ID.
	 */
	private static final long serialVersionUID = -173859703961811969L;
	
	/**
	 * Displays an about window that provides information about the weather vantage vue. 
	 */
	public About() {
		super("About and help window");
		JTabbedPane tabs = new JTabbedPane();
		this.add(tabs);
		tabs.add(graphInfo(), "Graph Info");
		tabs.add(windInfo(), "Wind Panel Info");
		tabs.add(weatherIconInfo(), "Weather Icon Info");
		this.pack();
		
	}
	
	/**
	 * A text window that provides a small description about the visual graph.
	 * @return a text field about the graph.
	 */
	private Component graphInfo() {
		JTextArea graphAbout = new JTextArea();
		graphAbout.setEditable(false);
		graphAbout.append("The graph below shows a visual representaion\n "
				+ "of the data gathered by the Weather Station. ");
		
		return graphAbout;
	}
	
	/**
	 * A text window that provides a small description about the wind panel.
	 * @return A text area that provides a description  about the wind panel.
	 */
	private Component windInfo() {
		JTextArea windAbout = new JTextArea();
		windAbout.setEditable(false);
		windAbout.append("The circle with the arrow represents a direction\n"
				+ "with the arrow moving in a 360 degree pattern. In the  \n "
				+ "middle there is a reading of the wind speed in miles per hour." );
		
		return windAbout;
	}
	
	
	/**]
	 * A text window that provides a small description about the weather icons panel.
	 * @return A text area about weather icons.
	 */
    private Component weatherIconInfo() {
    	JTextArea wIconAbout = new JTextArea();
    	wIconAbout.setEditable(false);
    	wIconAbout.append("The weather icon shows eight different icons that are dependent \n"
    			+ "on the temperature, wind speed, and the rain fall measurements. As those \n"
    			+ "parameters change the weather icons change with it." );
    	
    	return wIconAbout;
    }
		
	
	
	
}
