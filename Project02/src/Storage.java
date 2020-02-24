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
	
	Map<String, List<Integer>> infoMap;
	List<Integer> tempList;
	List<Integer> humList;
	List<Integer> presList;
	List<Integer> speedList;
	List<Integer> dirList;
	List<Integer> phaseList;
	List<Integer> rainList;
	List<Integer> riseList;
	List<Integer> setList;
	List<Integer> wIconList;
 	
	public Storage() {
		infoMap = new HashMap<String, List<Integer>>();
		tempList = new ArrayList<Integer>();
		humList = new ArrayList<Integer>();
		presList = new ArrayList<Integer>();
		speedList = new ArrayList<Integer>();
		dirList = new ArrayList<Integer>();
		phaseList = new ArrayList<Integer>();
		rainList = new ArrayList<Integer>();
		riseList = new ArrayList<Integer>();
		setList = new ArrayList<Integer>();
		wIconList = new ArrayList<Integer>();
	}
	public void addTemp(int temp) {
		tempList.add(temp);
		infoMap.put("Temp", tempList);
		//System.out.println(infoMap);
	}
	
	public void addHum(int hum) {
		humList.add(hum);
		infoMap.put("Humidity", humList);
	}
	
	public void addPres(int pressure) {
		presList.add(pressure);
		infoMap.put("Pressure", presList);
	}
	
	public void addWindSpeed(int speed) {
		speedList.add(speed);
		infoMap.put("WindSpeed", speedList);
	}
	
	public void addWindDir(int dir) {
		dirList.add(dir);
		infoMap.put("WindDir", dirList);
	}
	
	public void addMoonPhase(int phase) {
		phaseList.add(phase);
		infoMap.put("MoonPhase", phaseList);
	}
	
	public void addRain(int rain) {
		rainList.add(rain);
		infoMap.put("Rain", rainList);
	}
	
	public void addSunRise(int sunRise) {
		riseList.add(sunRise);
		infoMap.put("SunRise", riseList);
	}
	
	public void addSunSet(int sunSet) {
		setList.add(sunSet);
		infoMap.put("SunSet", setList);
	}
	
	public void addWIcon(int WIcon) {
		wIconList.add(WIcon);
		infoMap.put("WeatherIcon", wIconList);
	}
	
	public List<Integer> getTemp(int temp) {
		return tempList;
	}
	
	public List<Integer> getHum(int hum) {
		return humList;
	}
	
	public List<Integer> getPres(int pressure) {
		return presList;
	}
	
	public List<Integer> getWindSpeed(int speed) {
		return speedList;
	}
	
	public List<Integer>  getWindDir(int dir) {
		return dirList;
	}
	
	public List<Integer> getMoonPhase(int phase) {
		return phaseList;
	}
	
	public List<Integer> getRain(int rain) {
		return rainList;
	}
	
	public List<Integer> getSunRise(int sunRise) {
		return rainList;
	}
	
	public List<Integer> getSunSet(int sunSet) {
		return setList;
	}
	
	public List<Integer> getWIcon(int WIcon) {
		return wIconList;
	}
	

}
