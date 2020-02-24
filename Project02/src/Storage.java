import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 */

/**
 * @author Elias Salmo
 *
 */
public class Storage {
	
	/**
	 * map that stores all of the data while the program is running
	 */
	Map<String, List<Integer>> infoMap;
	/**
	 * A list to store all of the temp data 
	 */
	List<Integer> tempList;
	/**
	 * A list to store all of the Humidity data 
	 */
	List<Integer> humList;
	/**
	 * A list to store all of the Pressure data 
	 */
	List<Integer> presList;
	/**
	 * A list to store all of the Wind Speed data 
	 */
	List<Integer> speedList;
	/**
	 * A list to store all of the Wind Dir data 
	 */
	List<Integer> dirList;
	/**
	 * A list to store all of the Phase data 
	 */
	List<Integer> phaseList;
	/**
	 * A list to store all of the Rain data 
	 */
	List<Integer> rainList;
	/**
	 * A list to store all of the Sun rise data 
	 */
	List<Integer> riseList;
	/**
	 * A list to store all of the Sun set data 
	 */
	List<Integer> setList;
	/**
	 * A list to store all of the Weather Icon data 
	 */
	List<Integer> wIconList;
	
	/**
	 * file to store temperature 
	 */
	File tempFile; 
	
	/**
	 * file to store humidity 
	 */
	File humFile; 
	
	/**
	 * file to store pressure 
	 */
	File presFile; 
	
	/**
	 * file to store wind speed 
	 */
	File speedFile; 
	
	/**
	 * file to store direction speed 
	 */
	File dirFile; 
	
	/**
	 * file to store moon phase 
	 */
	File phaseFile; 
	
	/**
	 * file to store rain 
	 */
	File rainFile; 
	
	/**
	 * file to store sun rise 
	 */
	File sunRiseFile; 
	
	/**
	 * file to store sun set 
	 */
	File sunSetFile; 
	
	/**
	 * file to store weather icon 
	 */
	File wIconFile; 
	
	/**
	 * File to write to temperature 
	 */
	static BufferedWriter tempWriter;
	
	/**
	 * File to write to humidity 
	 */
	static BufferedWriter humWriter;
	
	/**
	 * File to write to pressure 
	 */
	static BufferedWriter presWriter;
	
	/**
	 * File to write to wind speed 
	 */
	static BufferedWriter speedWriter;
	
	/**
	 * File to write to wind direction 
	 */
	static BufferedWriter dirWriter;
	
	/**
	 * File to write to moon phase 
	 */
	static BufferedWriter phaseWriter;
	
	/**
	 * File to write to rain 
	 */
	static BufferedWriter rainWriter;
	
	/**
	 * File to write to sun rise 
	 */
	static BufferedWriter sunRiseWriter;
	
	/**
	 * File to write to sun set 
	 */
	static BufferedWriter sunSetWriter;
	
	/**
	 * File to write to weather icon 
	 */
	static BufferedWriter wIconWriter;
	
 	
	public Storage() {
		/**
		 * creates new files if they don't already exist
		 */
		try {
			tempFile = new File("tempFile.txt");
			tempFile.createNewFile();
			humFile = new File("humFile.txt");
			humFile.createNewFile();
			presFile = new File("presFile.txt");
			presFile.createNewFile();
			speedFile = new File("speedFile.txt");
			speedFile.createNewFile();
			dirFile = new File("dirFile.txt");
			dirFile.createNewFile();
			phaseFile = new File("phaseFile.txt");
			phaseFile.createNewFile();
			rainFile = new File("rainFile.txt");
			rainFile.createNewFile();
			sunRiseFile = new File("sunRiseFile.txt");
			sunRiseFile.createNewFile();
			sunSetFile = new File("sunSetFile.txt");
			sunSetFile.createNewFile();
			wIconFile = new File("wIconFile.txt");
			wIconFile.createNewFile();
		} catch (Exception e) { 
            System.err.println(e); 
        } 
		
		/**
		 * writes to a file output
		 */
		try {
		    tempWriter = new BufferedWriter(new FileWriter("tempFile.txt", true));
		    humWriter = new BufferedWriter(new FileWriter("humFile.txt", true));
		    presWriter = new BufferedWriter(new FileWriter("presFile.txt", true));
		    speedWriter = new BufferedWriter(new FileWriter("speedFile.txt", true));
		    dirWriter = new BufferedWriter(new FileWriter("dirFile.txt", true));
		    phaseWriter = new BufferedWriter(new FileWriter("phaseFile.txt", true));
		    rainWriter = new BufferedWriter(new FileWriter("rainFile.txt", true));
		    sunSetWriter = new BufferedWriter(new FileWriter("sunRiseFile.txt", true));
		    sunRiseWriter = new BufferedWriter(new FileWriter("sunSetFile.txt", true));
		    wIconWriter = new BufferedWriter(new FileWriter("wIconFile.txt", true));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/**
		 * Initializes a Map
		 */
		infoMap = new HashMap<String, List<Integer>>();
		/**
		 * Initializes a the temp list
		 */
		tempList = new ArrayList<Integer>();
		/**
		 * Initializes a the Humidity list
		 */
		humList = new ArrayList<Integer>();
		/**
		 * Initializes a the Pressure list
		 */
		presList = new ArrayList<Integer>();
		/**
		 * Initializes a the Wind speed list
		 */
		speedList = new ArrayList<Integer>();
		/**
		 * Initializes a the wind dir list
		 */
		dirList = new ArrayList<Integer>();
		/**
		 * Initializes a the phase list
		 */
		phaseList = new ArrayList<Integer>();
		/**
		 * Initializes a the rain list
		 */
		rainList = new ArrayList<Integer>();
		/**
		 * Initializes a the sun rise list
		 */
		riseList = new ArrayList<Integer>();
		/**
		 * Initializes a the sun set list
		 */
		setList = new ArrayList<Integer>();
		/**
		 * Initializes a the weather Icon list
		 */
		wIconList = new ArrayList<Integer>();
	}
	
	/**
	 * Method to add the temperature data and stores it into a map
	 * @param temp the temperature
	 */
	public void addTemp(int temp) {
		tempList.add(temp);
		
		try {    
			tempWriter.write("" + temp);
			tempWriter.write("\n");
			    
		} catch (IOException e) {
			e.printStackTrace();
		}
		infoMap.put("Temp", tempList);
	}
	
	/**
	 * Method to add the Humidity data and stores it into a map
	 * @param hum the humidity
	 */
	public void addHum(int hum) {
		humList.add(hum);
		try {    
			humWriter.write("" + hum);
			humWriter.write("\n");
			    
		} catch (IOException e) {
			e.printStackTrace();
		}
		infoMap.put("Humidity", humList);
	}
	
	/**
	 * Adds the pressure data and stores it into a map
	 * @param pressure
	 */
	public void addPres(int pressure) {
		presList.add(pressure);
		try {    
			presWriter.write("" + pressure);
			presWriter.write("\n");
			    
		} catch (IOException e) {
			e.printStackTrace();
		}
		infoMap.put("Pressure", presList);
	}
	
	/**
	 * Adds the wind speed data and stores into a map
	 * @param speed
	 */
	public void addWindSpeed(int speed) {
		speedList.add(speed);
		try {    
			speedWriter.write("" + speed);
			speedWriter.write("\n");
			    
		} catch (IOException e) {
			e.printStackTrace();
		}
		infoMap.put("WindSpeed", speedList);
	}
	
	/**
	 * Adds the wind direction data into a map
	 * @param dir
	 */
	public void addWindDir(int dir) {
		dirList.add(dir);
		try {    
			dirWriter.write("" + dir);
			dirWriter.write("\n");
			    
		} catch (IOException e) {
			e.printStackTrace();
		}
		infoMap.put("WindDir", dirList);
	}
	
	/**
	 * Adds the moon phase data into a map
	 * @param phase
	 */
	public void addMoonPhase(int phase) {
		phaseList.add(phase);
		try {    
			phaseWriter.write("" + phase);
			phaseWriter.write("\n");
			    
		} catch (IOException e) {
			e.printStackTrace();
		}
		infoMap.put("MoonPhase", phaseList);
	}
	
	/**
	 * Adds the rain data and stores it into a map
	 * @param rain
	 */
	public void addRain(int rain) {
		rainList.add(rain);
		try {    
			rainWriter.write("" + rain);
			rainWriter.write("\n");
			    
		} catch (IOException e) {
			e.printStackTrace();
		}
		infoMap.put("Rain", rainList);
	}
	
	/**
	 * Adds the sun rise data and stores into a map
	 * @param sunRise
	 */
	public void addSunRise(int sunRise) {
		riseList.add(sunRise);
		try {    
			sunRiseWriter.write("" + sunRise);
			sunRiseWriter.write("\n");
			    
		} catch (IOException e) {
			e.printStackTrace();
		}
		infoMap.put("SunRise", riseList);
	}
	
	/**
	 * Adds the sunset data and stores into a map
	 * @param sunSet
	 */
	public void addSunSet(int sunSet) {
		setList.add(sunSet);
		try {    
			sunSetWriter.write("" + sunSet);
			sunSetWriter.write("\n");
			    
		} catch (IOException e) {
			e.printStackTrace();
		}
		infoMap.put("SunSet", setList);
	}
	
	/**
	 * Adds the weather Icon data and stores it into a map
	 * @param WIcon
	 */
	public void addWIcon(int wIcon) {
		wIconList.add(wIcon);
		try {    
			wIconWriter.write("" + wIcon);
			wIconWriter.write("\n");
			    
		} catch (IOException e) {
			e.printStackTrace();
		}
		infoMap.put("WeatherIcon", wIconList);
	}
	
	/**
	 * returns the temp list
	 * @param temp
	 * @return
	 */
	public List<Integer> getTemp(int temp) {
		return tempList;
	}
	
	/**
	 * returns the humidity list
	 * @param hum
	 * @return
	 */
	public List<Integer> getHum(int hum) {
		return humList;
	}
	
	/**
	 * returns the pressire list
	 * @param pressure
	 * @return
	 */
	public List<Integer> getPres(int pressure) {
		return presList;
	}
	
	/**
	 * returns the wind speed list
	 * @param speed
	 * @return
	 */
	public List<Integer> getWindSpeed(int speed) {
		return speedList;
	}
	
	/**
	 * returns the wind direction list
	 * @param dir
	 * @return
	 */
	public List<Integer> getWindDir(int dir) {
		return dirList;
	}
	
	/**
	 * returns the moon phase list
	 * @param phase
	 * @return
	 */
	public List<Integer> getMoonPhase(int phase) {
		return phaseList;
	}
	
	/**
	 * returns the rain list
	 * @param rain
	 * @return
	 */
	public List<Integer> getRain(int rain) {
		return rainList;
	}
	
	/**
	 * returns the sun rise list
	 * @param sunRise
	 * @return
	 */
	public List<Integer> getSunRise(int sunRise) {
		return rainList;
	}
	
	/**
	 * returns the sunset list
	 * @param sunSet
	 * @return
	 */
	public List<Integer> getSunSet(int sunSet) {
		return setList;
	}
	
	/**
	 * returns the weather icon list
	 * @param WIcon
	 * @return
	 */
	public List<Integer> getWIcon(int WIcon) {
		return wIconList;
	}
}
