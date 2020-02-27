package tests;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Weather.WeatherGUI;

/**
 * Tests the WeatherGUI class.
 * 
 * @author Group6
 *
 */
class WeatherGUITest {

	/**
	 * Holds the weather gui on which the tests will be run.
	 */
	private WeatherGUI gui;
	
	/**
	 * Called before each of the tests.
	 */
	@BeforeEach
	void setup() {
		gui = new WeatherGUI();
		gui.start();
	}

	/**
	 * Tests the setTemp method for errors.
	 */
	@Test
	void testSetTemp() {
		gui.setTemp(439);
	}

	/**
	 * Tests the setHumid method for errors.
	 */
	@Test
	void testSetHumid() {
		gui.setHumid(20);
	}

	/**
	 * Tests the setPressure method for errors.
	 */
	@Test
	void testSetPressure() {
		gui.setPressure(29435);
	}

	/**
	 * Tests the setWind method for errors.
	 */
	@Test
	void testSetWind() {
		gui.setWind(34, 357);
	}

	/**
	 * Tests the setMoonPhase method for errors.
	 */
	@Test
	void testSetMoonPhase() {
		gui.setMoonPhase(4);
	}

	/**
	 * Tests the setRain method for errors.
	 */
	@Test
	void testSetRain() {
		gui.setRain(86);
	}

	/**
	 * Tests the setDate method for errors.
	 */
	@Test
	void testSetDate() {
		gui.setDate(new Date());
	}

	/**
	 * Tests the setTime method for errors.
	 */
	@Test
	void testSetTime() {
		gui.setTime(new Date());
	}

	/**
	 * Tests the setSunrise method for errors.
	 */
	@Test
	void testSetSunrise() {
		gui.setSunrise(432);
	}

	/**
	 * Tests the setSunset method for errors.
	 */
	@Test
	void testSetSunset() {
		gui.setSunset(712);
	}
}