package Weather;
import static org.junit.Assert.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import org.junit.Assert;
import org.junit.Test;

public class WeatherGUITest {
	private WeatherGUI guiTest;
	private JFrame frame;
	private String click;
	
	public void setUp() throws Exception{
		guiTest = new WeatherGUI();
		frame = new JFrame();
	}

	@Test
	public void testStart() {
		fail("Not yet implemented");
		ActionListener a1 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				click = e.getActionCommand();
			}
			
		};
		
		
	}

	@Test
	public void testSetResizable() {
//		fail("Not yet implemented");
		WeatherGUI frame = new WeatherGUI();
		JFrame testFrame = new JFrame();
		frame.setVisible(true);
		
		
		
	}

}
