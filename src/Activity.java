
/**
 * This class is responsible for knowing activities and knowing parameters
 * It does not collaborate with any other classes
 * @author Cayde.Roothoff
 *
 */
public class Activity {
	private int bestIndex;
	private double bestHighTemp;
	private double bestLowTemp;
	private String temperatureUnit;
	private String bestWindSpeed;
	private String windDirection;
	private String icon;
	private String shortForecast;
	private String longForecast;
	private double bestProbabilityOfPrecip;
	private double bestAmountOfPrecip;
	
	public void sailing() {
		this.bestHighTemp = 75;
		this.bestLowTemp = 65;
		//knots? mph?
		this.bestWindSpeed = 13;
		this.bestProbabilityOfPrecip = 0;
		this.bestAmountOfPrecip = 0;
	}
	
	public void hiking() {
		this.bestHighTemp = 75;
		this.bestLowTemp = 65;
		//knots? mph?
		this.bestWindSpeed = 13;
		this.bestProbabilityOfPrecip = 0;
		this.bestAmountOfPrecip = 0;
	}
	
	public void climbing() {
		this.bestHighTemp = 75;
		this.bestLowTemp = 65;
		//knots? mph?
		this.bestWindSpeed = 13;
		this.bestProbabilityOfPrecip = 0;
		this.bestAmountOfPrecip = 0;
	}
	
	public void skiing() {
		this.bestHighTemp = 75;
		this.bestLowTemp = 65;
		//knots? mph?
		this.bestWindSpeed = 13;
		this.bestProbabilityOfPrecip = 0;
		this.bestAmountOfPrecip = 0;
	}
	
	public void biking() {
		this.bestHighTemp = 75;
		this.bestLowTemp = 65;
		//knots? mph?
		this.bestWindSpeed = 13;
		this.bestProbabilityOfPrecip = 0;
		this.bestAmountOfPrecip = 0;
	}
	
}
