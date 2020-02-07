package weather;
import java.nio.ByteBuffer;
import java.util.Date;
import java.util.Random;

/**
 * Weather Controller class that extracts the data from the packets sent by WeatherStation.
 * Sends that data over to the WeatherGUI.
 * @author Group 6
 * Version January 26, 2020
 */
public class WeatherController implements Runnable {

	/**
	 * Maximum Number of moon phases.
	 */
	public static final int MAX_MOON_PHASE = 8;

	/**
	 * The byte offset to find where the temperature data is stored in the packet.
	 */
	private static final int TEMP_OFFSET = 12;

	/**
	 * The offset to find where the humidity data is stored in the packet.
	 */
	private static final int HUMID_OFFSET = 33;

	/**
	 * The offset to find where the pressure data is stored in the packet.
	 */
	private static final int PRESSURE_OFFSET = 7;

	/**
	 *  The offset to find where the wind speed data is stored in the packet.
	 */
	private static final int WINDSPD_OFFSET = 14;

	/**
	 * The offset to find where the wind direction data is stored in the packet.
	 */
	private static final int WINDDIR_OFFSET = 16;

	/**
	 * The offset to find in which byte stores the rain data in the packet.
	 */
	private static final int RAIN_OFFSET = 44;

	/**
	 * The offset to find in which byte stores the sunrise data in the packet.
	 */
	private static final int SUNRISE_OFFSET = 91;

	/**
	 * The offset to find in which byte stores the sunset data in the packet.
	 */
	private static final int SUNSET_OFFSET = 93;

	/**
	 * Random that will be used for moon phase.
	 */
	private Random random = new Random();

	/**
	 * An instance of WeatherStation.
	 */
	private WeatherStation station;

	/**
	 * An instantiation of the WeatherGUI.
	 */
	private WeatherGUI gui;

	/**
	 * The constructor for weather controller.
	 * @param station the instance of the weather station.
	 * @param gui the instance of the weather gui.
	 */
	public WeatherController(WeatherStation station, WeatherGUI gui) {
		this.station = station;
		this.gui = gui;
		random = new Random();
	}

	/**
	 * Run method extracts the data from the packets and passes the data into the WeatherGUI.
	 */
	@Override
	public void run() {
		while(!Thread.interrupted()) {
			byte[] packet = station.getNext();
			
			int temp = extractTemp(packet);
			int humid = extractHumid(packet);
			int pressure = extractPressure(packet);
			int windspd = extractWindSpd(packet);
			int winddir = extractWindDir(packet);
			int moon = extractMoonPhase();
			int rain = extractRain(packet);
			Date date = new Date();
			int sunrise = extractSunrise(packet);
			int sunset = extractSunset(packet);

			gui.setTemp(temp);
			gui.setHumid(humid);
			gui.setPressure(pressure);
			gui.setWind(windspd, winddir);
			gui.setMoonPhase(moon);
			gui.setRain(rain);
			gui.setDate(date);
			gui.setTime(date);
			gui.setSunrise(sunrise);
			gui.setSunset(sunset);
			gui.graphTick();
		}
	}

	/**
	 * Extracts temp data from byte packet.
	 * @param packet the byte array that stores data.
	 * @return and integer value of temperature.
	 */
	private int extractTemp(byte[] packet) {
		ByteBuffer buf = ByteBuffer.wrap(packet);
		return (int)buf.getChar(TEMP_OFFSET);
	}

	/**
	 * Extracts humidity data from byte packet.
	 * @param packet the byte array that stores data.
	 * @return and integer value of humidity.
	 */
	private int extractHumid(byte[] packet) {
		ByteBuffer buf = ByteBuffer.wrap(packet);
		return (int)buf.get(HUMID_OFFSET);
	}

	/**
	 * Extracts parametric pressure data from byte packet.
	 * @param packet the byte array that stores data.
	 * @return and integer value of pressure.
	 */
	private int extractPressure(byte[] packet) {
		ByteBuffer buf = ByteBuffer.wrap(packet);
		return (int)buf.getChar(PRESSURE_OFFSET);
	}

	/**
	 * Extracts Wind Speed data from byte packet.
	 * @param packet the byte array that stores data.
	 * @return and integer value of wind speed.
	 */
	private int extractWindSpd(byte[] packet) {
		ByteBuffer buf = ByteBuffer.wrap(packet);
		return (int)buf.get(WINDSPD_OFFSET);
	}

	/**
	 * Extracts wind direction data from byte packet.
	 * @param packet the byte array that stores data.
	 * @return and integer value of wind direction.
	 */
	private int extractWindDir(byte[] packet) {
		ByteBuffer buf = ByteBuffer.wrap(packet);
		return (int)buf.getChar(WINDDIR_OFFSET);
	}

	/**
	 * Generates random moon phase.
	 * @return and integer value of moon phase.
	 */
	private int extractMoonPhase() {
		return random.nextInt(MAX_MOON_PHASE);
	}

	/**
	 * Extracts rain fall from byte packet.
	 * @param packet the byte array that stores data.
	 * @return integer value of the rain fall.
	 */
	private int extractRain(byte[] packet) {
		ByteBuffer buf = ByteBuffer.wrap(packet);
		return (int) buf.get(RAIN_OFFSET);
	}

	/**
	 * Extracts Sunrise from byte packet.
	 * @param packet the byte array that stores Weather data.
	 * @return integer value of sunrise.
	 */
	private int extractSunrise(byte[] packet) {
		ByteBuffer buf = ByteBuffer.wrap(packet);
		return (int) (100*buf.get(SUNRISE_OFFSET)) + (int) buf.get(SUNRISE_OFFSET + 1);
	}

	/**
	 * Extracts sunset data from byte packet.
	 * @param packet the byte array that stores Weather data.
	 * @return and integer value of sunset.
	 */
	private int extractSunset(byte[] packet) {
		ByteBuffer buf = ByteBuffer.wrap(packet);
		return (int) (100*buf.get(SUNSET_OFFSET)) + (int) buf.get(SUNSET_OFFSET + 1);
	}
}
