import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.ArrayList;


public class NWSWeatherWebservice {

	
	/**
	 * takes in the GPS location for a place and gets the URLs for calling
	 * the getForecast method as an Array.
	 * @param coordinates
	 * @return
	 */
	private ArrayList<String> getNWSGridLocation(String coordinates) {
		
		//setup the url to get the gridpoints from the request and return them for the next call
		String url = "https://api.weather.gov/points/" + coordinates;
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).timeout(Duration.ofSeconds(5)).build();
		ArrayList<String> gridLocation = new ArrayList<String>();
		jsonIO parser = new jsonIO();
		
		try {
			System.out.println("Making a call to " + url);
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			if (response.statusCode() > 200) {
				
				System.out.println("Help, I'm trapped in a computer!");
			}
			else {
				gridLocation = parser.parseGPS(response.body());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return gridLocation;
	}
	
	/**
	 * takes in GPS coordiates as a string latitude,longitude and returns the forecast for that location
	 * throttle this call at 2 per second
	 * @param location
	 * @return
	 */
	
	public ArrayList<Weather> getNWSForecast(String coordinates){
		//make call to prescribed URL location
		ArrayList<String> url = getNWSGridLocation(coordinates);
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest requestForecast = HttpRequest.newBuilder().uri(URI.create(url.get(0))).timeout(Duration.ofSeconds(5)).build();
		HttpRequest requestForecastGridData = HttpRequest.newBuilder().uri(URI.create(url.get(1))).timeout(Duration.ofSeconds(5)).build();
		ArrayList<Weather> weatherData = new ArrayList<Weather>();
		jsonIO parseWeather = new jsonIO();
		
		try {
			//try to get the weather from the API, if status code says server is unavailable indicate that and return null
			HttpResponse<String> forecastResponse = client.send(requestForecast, BodyHandlers.ofString());
			HttpResponse<String> forecastGridDataResponse = client.send(requestForecastGridData, BodyHandlers.ofString());
			if (forecastResponse.statusCode() > 200 || forecastGridDataResponse.statusCode() > 200) {
				
				System.out.println("NWS Webservice is unavailable");
				return null;
			}
			
			//get the array of forecasts from the parser
			weatherData = parseWeather.parseNWSForecast(forecastResponse.body(), forecastGridDataResponse.body());
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return weatherData;
	}
	
	
	

}
