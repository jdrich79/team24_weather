import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.*;

/**
 * Class for importing/exporting JSON files
 * @author Bryan Rogers
 *
 */

public class jsonIO {
	
	private JSONArray savedSearch = new JSONArray();
	
	/**
	 * The fileWriter method takes in an arraylist of locations
	 * and a filename and saves these files in a directory called
	 * "SavedSearches" in the current file path where this program is executing from
	 * @param locations
	 * @param filename
	 */
	public void fileWriter(ArrayList<location> locations, String filename) {
		
		//Setup a directory called SavedSearches in the current directory if it doesn't exist
		String directoryPath = System.getProperty("user.dir") + "/SavedSearches/";
		File directory = new File(directoryPath);
		if (!directory.exists()) {
			directory.mkdir();
		}
		
		//For the locations input, put them into a JSON object and then put that JSON object into a json array
		int i = 0;
		for (location address : locations) {
			JSONObject jobj = new JSONObject();
			jobj.put("lat", address.getLatitude());
			jobj.put("longitude", address.getLongitude());
			jobj.put("locationName", address.getDisplayName());
			savedSearch.put(i, jobj);
			i++;
		}
		//write the JSON to the file specified
		File f = new File(directoryPath + filename);
		
		try {
			FileWriter fw = new FileWriter(f);
			fw.write(savedSearch.toString());
			fw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * The fileReader method takes in a fileName and returns
	 * an ArrayList of locations stored in the JSON file.
	 * The file imported must be in the "SavedSearches" directory
	 * in the current filepath
	 * @param filename
	 * @return
	 */
	public ArrayList<location> fileReader(String filename){
		//Get the current directory and make a "SavedSearches" folder if it doesn't exist
		String directoryPath = System.getProperty("user.dir") + "/SavedSearches/";
		File directory = new File(directoryPath);
		if (!directory.exists()) {
			directory.mkdir();
		}
		
		//Read in the specified file
		File f = new File(directoryPath + filename);
		String jsonText = "";
		ArrayList<location> locations = new ArrayList<location>();
		
		try {
			Scanner fileReader = new Scanner(f);
			while(fileReader.hasNext()) {
				jsonText += fileReader.nextLine();
			}
			
			//intake the file contents as a JSONArray and then create a location and add them to array list of locations
			JSONArray array = new JSONArray(jsonText);
			for (int i = 0; i < array.length(); i++) {
				JSONObject b = array.getJSONObject(i);
				location l = new location();
				l.setDisplayName(b.getString("locationName"));
				l.setLatitude(b.getString("lat"));
				l.setLongitude(b.getString("longitude"));
				
				locations.add(l);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return locations;
	}
	
	/**
	 * This returns an ArrayList of files from the
	 * "SavedSearches" directory in the current filepath.
	 * Logs a warning to the console if the current directory is empty and returns
	 * a blank arraylist in that case
	 * @return
	 */
	public ArrayList<String> getFiles(){
		
		//Create the savedSearches directory if it doesn't exist
		ArrayList<String> jsonFiles = new ArrayList<String>();
		String directoryPath = System.getProperty("user.dir") + "/SavedSearches/";
		File directory = new File(directoryPath);
		if (!directory.exists()) {
			directory.mkdir();
		}
		
		//Read in all the files in the list and filter for .json files
		File f = new File(directoryPath);
		
		String[] listOfFiles = f.list();
		if (listOfFiles.length != 0) {
			for (String file : listOfFiles) {
				if (file.endsWith(".json")){
					jsonFiles.add(file);
				}
			}
		}
		if(jsonFiles.size() == 0) {
			System.out.println("Warning, no valid files in this directory!");
		}
		
		return jsonFiles;
	}
	
	/**
	 * A public class that parses the forecast for the NWS API taking in the responses of the 
	 * two pieces of forecast data APIs
	 * @param forecastResponseBody
	 * @param forecastGridDataResponseBody
	 * @return
	 */
	public ArrayList<Weather> parseNWSForecast(String forecastResponseBody, String forecastGridDataResponseBody){
		
		JSONObject forecastObject = new JSONObject(forecastResponseBody);
		JSONObject forecastGridDataObject = new JSONObject(forecastGridDataResponseBody);
		ArrayList<Weather> weatherData = new ArrayList<Weather>();
		JSONArray array = forecastObject.getJSONObject("properties").getJSONArray("periods");
		
	
		//gets forecast for each entry in the array
		for (int i = 0; i < array.length(); i++) {
			JSONObject b = array.getJSONObject(i);
			CharSequence startTime = b.getString("startTime").subSequence(0, 19);
			CharSequence endTime = b.getString("endTime").subSequence(0, 19);

			//parses out the values needed from the gridData API
			double precipProb = parseForecastGridData(forecastGridDataObject, startTime, endTime, "probabilityOfPrecipitation");
			double precipAmount = parseForecastGridData(forecastGridDataObject, startTime, endTime, "quantitativePrecipitation");
			double highTemp = parseForecastGridData(forecastGridDataObject, startTime, endTime, "maxTemperature");
			double lowTemp = parseForecastGridData(forecastGridDataObject, startTime, endTime, "minTemperature");
			
			Weather tempWeather = new Weather(b.getInt("number"), b.getString("name"), (b.getString("startTime")), (b.getString("endTime")),
				b.getBoolean("isDaytime"), highTemp, lowTemp, b.getString("windSpeed"), b.getString("windDirection"), b.getString("icon"),
				b.getString("shortForecast"), b.getString("detailedForecast"), precipProb, precipAmount);
			weatherData.add(tempWeather);
		}
		return weatherData;
	}
	
	/**
	 * Method to parse the GPS data to return the 2 URLs at NWS
	 * meant to get the 2 full URLs for getting the complete forecast data
	 * @param responseBody
	 * @return
	 */
	public ArrayList<String> parseGPS(String responseBody) {
		
		//sets up a list of urls as strings, and then gets those urls from the json response of the first API
		ArrayList<String> locationUrl = new ArrayList<String>();

		JSONObject object = new JSONObject(responseBody);
		locationUrl.add(object.getJSONObject("properties").getString("forecast"));
		locationUrl.add(object.getJSONObject("properties").getString("forecastGridData"));
		
		return locationUrl;
	}
	
	/**
	 * parsing function for various "keys" from the forecastDataPoints webservice
	 * this is used to get a few extra values not in the regular forecast call and 
	 * put them into a format usable in the weather object
	 * @param object
	 * @param startTime
	 * @param endTime
	 * @param key
	 * @return
	 */
	private double parseForecastGridData(JSONObject object, CharSequence startTime, CharSequence endTime, String key) {
		//parses out the array of values for the specified key from the input object
		JSONArray keyData = object.getJSONObject("properties").getJSONObject(key).getJSONArray("values");
		double counter = 0;
		double values = 0;
		
		//gets the dateTime of start/finish
		LocalDateTime startDatetime = LocalDateTime.parse(startTime);
		LocalDateTime endDatetime = LocalDateTime.parse(endTime);
		
		//for all the entries in the array, gets the values within the start/end time and adds them up
		for (int i = 0; i < keyData.length(); i++) {
			
			JSONObject o = keyData.getJSONObject(i);
			
			LocalDateTime t = LocalDateTime.parse(o.getString("validTime").subSequence(0, 16));
			if ((t.isBefore(endDatetime)) && (t.isAfter(startDatetime) || t.isEqual(startDatetime))) {
				
				values += o.getDouble("value");
				counter++;
			}
		}

		//gets and returns the average
		double avg = values / counter;
		
		return avg;
		
	}

}