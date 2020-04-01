
/**
 * This class is responsible for knowing activities and knowing parameters
 * It does not collaborate with any other classes
 * @author Cayde.Roothoff
 *
 */
public class Activity {
	private int bestTemp;
	private int bestPrecip;
	private int bestWindSpeed;
	
	public int getBestTemp() {
		return bestTemp;
	}

	public int getBestPrecip() {
		return bestPrecip;
	}

	public int getBestWindSpeed() {
		return bestWindSpeed;
	}

	public void sailing() {
		this.bestTemp = 0;
		this.bestPrecip = 0;
		this.bestWindSpeed= 0;
	}
	
	public void hiking() {
		this.bestTemp = 0;
		this.bestPrecip = 0;
		this.bestWindSpeed= 0;
	}
	
	public void climbing() {
		this.bestTemp = 0;
		this.bestPrecip = 0;
		this.bestWindSpeed= 0;
	}
	
	public void skiing() {
		this.bestTemp = 0;
		this.bestPrecip = 0;
		this.bestWindSpeed= 0;
	}
	
	public void biking() {
		this.bestTemp = 0;
		this.bestPrecip = 0;
		this.bestWindSpeed= 0;
	}
	
}
