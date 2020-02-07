package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import weather.WeatherStation;

/**
 * Tests the weather station simulator.
 * 
 * @author Group 6
 *
 */
class WeatherStationTest {

/**
 * The weather station on which the tests will be run
 */
private WeatherStation myWeatherStation;

	/**
	 * Initializes the weather station before each test
	 */
	@BeforeEach
	public void setup() {
	myWeatherStation = new WeatherStation();
	}
	
	/**
	 * Tests the humidity generation
	 */
	@Test
	public void testhumid() {
		assertEquals(60, myWeatherStation.getHumid(), 60);
	}
	
	/**
	 * Tests that the humidity generation won't be null
	 */
	@Test
	public void testhumidnotnull() {
		assertNotNull(myWeatherStation.getHumid());
	}
	
	/**
	 * Tests the temperature generation
	 */
	@Test
	public void testtemp() {
		
			assertEquals(1000, myWeatherStation.getTemp(), 1000);
		
	} 
	
	/**
	 * Tests that the temperature won't be null
	 */
	@Test
	public void testtempnotnull() {	
		assertNotNull(myWeatherStation.getTemp());
	}
	
	/**
	 * Tests the pressure generation
	 */
	@Test
	public void testpressure() {
			assertEquals(30000, myWeatherStation.getPressure(), 30000);
	}
	
	/**
	 * Tests the wind speed generation
	 */
	@Test
	public void testwindspd() {
	
			assertEquals(30, myWeatherStation.getWindspd(), 30);
		
	}
	
	/**
	 * Tests the wind direction generation
	 */
	@Test
	public void testwinddir() {

			assertEquals(60, myWeatherStation.getHumid(), 60);
		
	}
	
	/**
	 * Tests the rainfall generation
	 */
	@Test
	public void testrain() {
	
			assertEquals(60, myWeatherStation.getRain(), 60);
	
	}
	
	/**
	 * Tests the sunrise time generation
	 */
	@Test
	public void testsunrise() {
			assertEquals(10000, myWeatherStation.getSunrise(), 10000);
		
	}
	
	/**
	 * Tests the sunset time generation
	 */
	@Test
	public void testsunset() {
			assertEquals(1000, myWeatherStation.getSunset(), 1000);
	}
}