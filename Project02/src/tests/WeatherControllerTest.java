package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Date;

import org.junit.jupiter.api.Test;

import Weather.WeatherController;
import Weather.WeatherGUI;
import Weather.WeatherStation;
import Weather.Alerts;
import Weather.Storage;

/**
 * The tests for the WeatherController class.
 * 
 * @author Group 6
 *
 */
class WeatherControllerTest {
	
	/**
	 * Tests the weather controller constructor.
	 */
	@Test
	void testWeatherController() {
		WeatherController wc = new WeatherController(new WeatherStation(), new WeatherGUI(), new Storage(), new Alerts());
	}

	/**
	 * Tests the run of the weather controller by overriding methods from WeatherStation and WeatherGUI.
	 */
	@Test
	void testRun() {
		WeatherController wc = new WeatherController(new WeatherStation() {public byte[] getNext() {
				byte[] out = {0, 0, 0, 0, 0, 0, 0, 120, -105, 0, 0, 0, 0, 100, 13, 0, 0, 126, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 86, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 11, 7, 15, 0, 0, 0, 0};
				return out;
			}},
			new WeatherGUI() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public void setTemp(int temp) {
					assertEquals(100, temp);
				}
				
				public void setWind(int windspd, int winddir) {
					assertEquals(13, windspd);
					assertEquals(126, winddir);
				}
				
				public void setSunrise(int time) {
					assertEquals(511, time);
				}
				
				public void setSunset(int time) {
					assertEquals(715, time);
				}
				
				public void setRain(int rain) {
					assertEquals(86, rain);
				}
				
				public void setPressure(int pressure) {
					assertEquals(30871, pressure);
				}
				
				public void setHumid(int humid) {
					assertEquals(11, humid);
				}
				
				public void setMoonPhase(int moon) {
					assertTrue(0 <= moon && moon < WeatherController.MAX_MOON_PHASE);
				}
				
				public void setDate(Date date) {
					assertNotNull(date);
				}
				
				public void setTime(Date date) {
					assertNotNull(date);
				}
			}, null, null
		);
		
		// Interrupt after 3 seconds to stop it from continuously generating data
		Thread curThread = Thread.currentThread();
		Thread interruptThread = new Thread(() -> {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				fail("Error: interrupt thread interrupted");
			}
			curThread.interrupt();
		});
		interruptThread.start();
		wc.run();
	}
}
