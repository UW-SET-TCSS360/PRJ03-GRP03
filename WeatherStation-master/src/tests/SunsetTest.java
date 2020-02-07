package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.EventQueue;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import weather.WeatherController;
import weather.WeatherGUI;
import weather.WeatherStation;

/**
 * Runs tests for the sunset prediction sensor
 */
public class SunsetTest {

	WeatherGUI gui;
	WeatherStation station;
	WeatherController controller;
	
	/**
	 * Set up program for sunset tests
	 */
	@BeforeEach
	public void setUp() {
		gui = new WeatherGUI();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                gui.start();
            }
        });
        station = new WeatherStation();
        controller = new WeatherController(station, gui);
        
        Thread thread = new Thread(controller);
        thread.start();
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Test the hour of the sunset
	 */
	@Test
	public void testHour() {
		String sunset = gui.getSunset();
		int hour = Integer.parseInt(sunset.substring(9, 10));
		boolean pmHour;
		if (hour >= 5 && hour <= 8) {
			pmHour = true;
		} else {
			pmHour = false;
		}
		assertTrue(pmHour, "P.M. hour isn't within 05:-- to 08:--");
	}
	
	/**
	 * Test the minute of the sunset
	 */
	@Test
	public void testMinute() {
		String sunset = gui.getSunset();
		int minute = Integer.parseInt(sunset.substring(11, 12));
		boolean pmMinute;
		if (minute >= 0 && minute <= 59) {
			pmMinute = true;
		} else {
			pmMinute = false;
		}
		assertTrue(pmMinute, "P.M. minute isn't within --:00 to --:59 ");
	}
	
	/**
	 * Test the period of when sunset occurs
	 */
	@Test
	public void testMorning() {
		String sunset = gui.getSunset();
		String period =  sunset.substring(sunset.length()-2, sunset.length());
		boolean morning;
		if (period.equals("PM")) {
			morning = true;
		} else {
			morning = false;
		}
		assertTrue(morning, "Doesn't read as \"p.m.\", either because it is misspelled or it is a.m.");
	}
	
}
