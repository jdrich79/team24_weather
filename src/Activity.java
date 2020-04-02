
/**
 * This class is responsible for knowing activities and knowing parameters
 * It does not collaborate with any other classes
 * @author Cayde.Roothoff
 *
 */
public class Activity {

    private Double bestqpf;
    private Double bestqpfSnow;
    private Integer bestTemperatureMax;
    private Integer bestTemperatureMin;
    //day and night
    private Integer bestPrecipChanceD;
    private Integer bestPrecipChanceN;
    private Integer bestCloudCoverD;
    private Integer bestCloudCoverN;
    private String bestPrecipTypeD;
    private String bestPrecipTypeN;
    private Double bestqpfD;
    private Double bestqpfN;
    private Double bestqpfSnowD;
    private Double bestqpfSnowN;
    private String bestSnowRangeD;
    private String bestSnowRangeN;
    private Integer bestTemperatureHeatIndexD;
    private Integer bestTemperatureHeatIndexN;
    private Integer bestTemperatureWindChillD;
    private Integer bestTemperatureWindChillN;
    private String bestWindPhraseD;
    private String bestWindPhraseN;
	
    

	public Double getBestqpf() {
		return bestqpf;
	}

	public Double getBestqpfSnow() {
		return bestqpfSnow;
	}

	public Integer getBestTemperatureMax() {
		return bestTemperatureMax;
	}

	public Integer getBestTemperatureMin() {
		return bestTemperatureMin;
	}

	public Integer getBestPrecipChanceD() {
		return bestPrecipChanceD;
	}

	public Integer getBestPrecipChanceN() {
		return bestPrecipChanceN;
	}

	public Integer getBestCloudCoverD() {
		return bestCloudCoverD;
	}

	public Integer getBestCloudCoverN() {
		return bestCloudCoverN;
	}

	public String getBestPrecipTypeD() {
		return bestPrecipTypeD;
	}

	public String getBestPrecipTypeN() {
		return bestPrecipTypeN;
	}

	public Double getBestqpfD() {
		return bestqpfD;
	}

	public Double getBestqpfN() {
		return bestqpfN;
	}

	public Double getBestqpfSnowD() {
		return bestqpfSnowD;
	}

	public Double getBestqpfSnowN() {
		return bestqpfSnowN;
	}

	public String getBestSnowRangeD() {
		return bestSnowRangeD;
	}

	public String getBestSnowRangeN() {
		return bestSnowRangeN;
	}

	public Integer getBestTemperatureHeatIndexD() {
		return bestTemperatureHeatIndexD;
	}

	public Integer getBestTemperatureHeatIndexN() {
		return bestTemperatureHeatIndexN;
	}

	public Integer getBestTemperatureWindChillD() {
		return bestTemperatureWindChillD;
	}

	public Integer getBestTemperatureWindChillN() {
		return bestTemperatureWindChillN;
	}

	public String getBestWindPhraseD() {
		return bestWindPhraseD;
	}

	public String getBestWindPhraseN() {
		return bestWindPhraseN;
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
