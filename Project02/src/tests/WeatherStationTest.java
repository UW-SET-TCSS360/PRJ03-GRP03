package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Weather.WeatherStation;

class WeatherStationTest {

@BeforeAll
static void setUpBeforeClass() throws Exception {
}

private WeatherStation myWeatherStation;

	@BeforeEach
	public void setup() {
	myWeatherStation = new WeatherStation();
	}

	@Test
	public void testhumid() {
		
			assertEquals(60, myWeatherStation.getHumid(), 60);
		
	}
	@Test
	public void testhumidnotnull() {
		
		assertNotNull(myWeatherStation.getHumid());
	
}
	@Test
	public void testtemp() {
		
			assertEquals(1000, myWeatherStation.getTemp(), 1000);
		
	} 
	@Test
	public void testtempnotnull() {
		
		assertNotNull(myWeatherStation.getTemp());
	
}
	@Test
	public void testpressure() {
		
			assertEquals(30000, myWeatherStation.getPressure(), 30000);
		
	}
	@Test
	public void testwindspd() {
	
			assertEquals(30, myWeatherStation.getWindspd(), 30);
		
	} @Test
	public void testwinddir() {

			assertEquals(60, myWeatherStation.getHumid(), 60);
		
	} @Test
	public void testrain() {
	
			assertEquals(60, myWeatherStation.getRain(), 60);
	
	} @Test
	public void testsunrise() {
		
			assertEquals(10000, myWeatherStation.getSunrise(), 10000);
		
	} @Test
	public void testsunset() {
		
			assertEquals(1000, myWeatherStation.getSunset(), 1000);
		
	}
}