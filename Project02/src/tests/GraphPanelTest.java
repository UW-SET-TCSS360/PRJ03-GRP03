package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import Weather.GraphPanel;

/**
 * The JUnit tests for the GraphPanel class.
 * @author Group 6
 *
 */
class GraphPanelTest {

	/**
	 * Tests the GraphPanel constructor.
	 */
	@Test
	void testGraphPanel() {
		// only should fail if an error occurs
		@SuppressWarnings("unused")
		GraphPanel panel = new GraphPanel(500, 650);
	}

	/**
	 * Tests the GraphPanel update sensor value method.
	 */
	@Test
	void testUpdateSensorValue() {
		GraphPanel panel = new GraphPanel(500, 650);
		int value = 50;
		for (int i=0; i<GraphPanel.NUM_SENSORS; i++) {
			panel.setSensorType(i);
			panel.updateSensorValue(i, value);
			assertEquals(value, panel.getCurrentSensorValue());
		}
	}

	/**
	 * Tests the paintComponentGraphics method, passes if no error occurs
	 */
	@Test
	void testPaintComponentGraphics() {
		GraphPanel panel = new GraphPanel(500, 650);
		panel.repaint(); // should only fail if this causes an error
	}

	/**
	 * Tests the getting and setting of the sensor type
	 */
	@Test
	void testGetSetSensorType() {
		GraphPanel panel = new GraphPanel(500, 650);
		for (int i=0; i<GraphPanel.NUM_SENSORS; i++) {
			panel.setSensorType(i);
			assertEquals(i, panel.getSensorType());
		}
	}
}
