
/**
 * This class is responsible for knowing activities and knowing parameters
 * It does not collaborate with any other classes
 * @author Cayde.Roothoff
 *
 */
public class Activity {
    private Integer bestTemperatureMax;
    private Integer bestTemperatureMin;
    
    // day part
    private Integer bestPrecipChance;
    private Integer bestCloudCover;
    private Double bestQpf;
    private Double bestQpfSnow;
    private Integer bestTemperatureHeatIndex;
    private Integer bestTemperatureWindChill;
    private String bestWindPhrase;
	
	public void sailing() {
	   this.bestTemperatureMax = 75;
	   this.bestTemperatureMin = 65;
	    
	    // day part
	    this.bestPrecipChance = 0;
	    this.bestCloudCover = 3;
	    this.bestQpf = 0.0;
	    this.bestQpfSnow = 0.0;
	    this.bestTemperatureHeatIndex = 78;
	    this.bestTemperatureWindChill = 77;
	    this.bestWindPhrase = "";
	}
	
	public void hiking() {
		   this.bestTemperatureMax = 68;
		   this.bestTemperatureMin = 60;
		    
		    // day part
		    this.bestPrecipChance = 0;
		    this.bestCloudCover = 4;
		    this.bestQpf = 0.0;
		    this.bestQpfSnow = 0.0;
		    this.bestTemperatureHeatIndex = 70;
		    this.bestTemperatureWindChill = 70;
		    this.bestWindPhrase = "";
	}
	
	public void climbing() {
		   this.bestTemperatureMax = 72;
		   this.bestTemperatureMin = 65;
		    
		    // day part
		    this.bestPrecipChance = 0;
		    this.bestCloudCover = 1;
		    this.bestQpf = 0.0;
		    this.bestQpfSnow = 0.0;
		    this.bestTemperatureHeatIndex = 74;
		    this.bestTemperatureWindChill = 73;
		    this.bestWindPhrase = "";
	}
	
	public void skiing() {
		   this.bestTemperatureMax = 25;
		   this.bestTemperatureMin = 20;
		    
		    // day part
		    this.bestPrecipChance = 0;
		    this.bestCloudCover = 3;
		    this.bestQpf = 0.0;
		    this.bestQpfSnow = 0.25;
		    this.bestTemperatureHeatIndex = 25;
		    this.bestTemperatureWindChill = 25;
		    this.bestWindPhrase = "";
	}
	
	public void biking() {
		   this.bestTemperatureMax = 72;
		   this.bestTemperatureMin = 65;
		    
		    // day part
		    this.bestPrecipChance = 0;
		    this.bestCloudCover = 3;
		    this.bestQpf = 0.0;
		    this.bestQpfSnow = 0.0;
		    this.bestTemperatureHeatIndex = 74;
		    this.bestTemperatureWindChill = 72;
		    this.bestWindPhrase = "";
	}
	
}
