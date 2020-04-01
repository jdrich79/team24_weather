import java.time.*;

/**
 * This class stores weather data
 * @author Bryan Rogers
 *
 */
public class Weather {
	
	int index;
	String day;
	String startTime;
	String endTime;
	boolean isDayTime;
	double highTemp;
	double lowTemp;
	String temperatureUnit;
	String windSpeed;
	String windDirection;
	String icon;
	String shortForecast;
	String longForecast;
	double probabilityOfPrecip;
	double amountOfPrecip;
	
	
	public Weather(int index, String day, String startTime,	String endTime,	boolean isDayTime,	double highTemp,	double lowTemp,	String windSpeed,
	String windDirection,	String icon,	String shortForecast,	String longForecast, double probPrecip, double amountPrecip) {
		this.index = index;
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
		this.isDayTime = isDayTime;
		this.highTemp = highTemp;
		this.lowTemp = lowTemp;
		//this.temperatureUnit = temperatureUnit;
		this.windSpeed = windSpeed;
		this.windDirection = windDirection;
		this.icon = icon;
		this.shortForecast = shortForecast;
		this.longForecast = longForecast;
		this.probabilityOfPrecip = probPrecip;
		this.amountOfPrecip = amountPrecip;
	}


	public int getIndex() {
		return index;
	}


	public String getDay() {
		return day;
	}


	public String getStartTime() {
		return startTime;
	}


	public String getEndTime() {
		return endTime;
	}


	public boolean isDayTime() {
		return isDayTime;
	}


	public String getTemperatureUnit() {
		return temperatureUnit;
	}


	public String getWindSpeed() {
		return windSpeed;
	}


	public String getWindDirection() {
		return windDirection;
	}


	public String getIcon() {
		return icon;
	}


	public String getShortForecast() {
		return shortForecast;
	}


	public String getLongForecast() {
		return longForecast;
	}


	public double getHighTemp() {
		return highTemp;
	}


	public double getLowTemp() {
		return lowTemp;
	}


	public double getProbabilityOfPrecip() {
		return probabilityOfPrecip;
	}
	
	

}
