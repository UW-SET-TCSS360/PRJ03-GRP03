package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import weather.WindPanel;

/**
 * Tests the WindPanel class.
 * 
 * @author Group 6
 *
 */
class WindPanelTest {
	/**
	 * Tests the WindPanel constructor.
	 */
	@Test
	void testWindPanel() {
		// should only fail if an error occurs
		@SuppressWarnings("unused")
		WindPanel panel = new WindPanel(500);
	}

	/**
	 * Tests the updateWind method.
	 */
	@Test
	void testUpdateWind() {
		WindPanel panel = new WindPanel(500);
		panel.updateWind(32, 76);
		assertEquals(32, panel.getSpeed());
		assertEquals(76, panel.getDir());
	}

	/**
	 * Tests the paintComponentGraphics method, passes if no error occurs.
	 */
	@Test
	void testPaintComponentGraphics() {
		WindPanel panel = new WindPanel(500);
		panel.repaint();
	}
}
