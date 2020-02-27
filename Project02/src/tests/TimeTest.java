package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.awt.EventQueue;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Weather.Alerts;
import Weather.Storage;
import Weather.WeatherController;
import Weather.WeatherGUI;
import Weather.WeatherStation;

/***
 * Test class for Time.
 * @author  Group 1
 * @version February 22, 2020
 */
public class TimeTest {
	WeatherGUI gui;
	WeatherStation station;
	WeatherController controller;
	Storage storage;
	Alerts alert;
	
	/**
	 * Set up for the Time testing.
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
        controller = new WeatherController(station, gui, storage, alert);
        
        Thread thread = new Thread(controller);
        thread.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test to check the time values are valid.
	 */
	@Test
	public void testTime() {
		String time = gui.getTime().substring(6);
		Date currentTime = new Date();
		
		SimpleDateFormat format = new SimpleDateFormat("h:mm:ss a");		
		try {
			Date testTime = format.parse(time);
			currentTime = format.parse(format.format(currentTime));
			System.out.println(Math.abs(currentTime.getTime() - testTime.getTime()));
			assertTrue(Math.abs(currentTime.getTime() - testTime.getTime()) < 5000L,
					"Failed: "+currentTime+" vs. "+testTime);
		} catch (ParseException e) {
			fail("failed to parse time");
		}
	}
}