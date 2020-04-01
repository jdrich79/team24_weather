
public class FiveDayForecast {
    private String date;
    private String dayOfWeek;
    private String narrative;
    private Double qpf;
    private Double qpfSnow;
    private Integer temperatureMax;
    private Integer temperatureMin;
    
    // daypart
    private String daypartNameD;
    private String daypartNameN;
    private String narrativeD;
    private String narrativeN;
    private Integer precipChanceD;
    private Integer precipChanceN;
    private Integer cloudCoverD;
    private Integer cloudCoverN;
    private String precipTypeD;
    private String precipTypeN;
    private Double qpfD;
    private Double qpfN;
    private Double qpfSnowD;
    private Double qpfSnowN;
    private String snowRangeD;
    private String snowRangeN;
    private Integer temperatureHeatIndexD;
    private Integer temperatureHeatIndexN;
    private Integer temperatureWindChillD;
    private Integer temperatureWindChillN;
    private String windPhraseD;
    private String windPhraseN;
    
    

    public FiveDayForecast() {
        
    }
    
    public FiveDayForecast(String date, String dayOfWeek, String narrative, Double qpf, Double qpfSnow, 
            Integer temperatureMax, Integer temperatureMin, String daypartNameD, String daypartNameN, 
            String narrativeD, String narrativeN, Integer precipChanceD, Integer precipChanceN,
            Integer cloudCoverD, Integer cloudCoverN, String precipTypeD, String precipTypeN, 
            Double qpfD, Double qpfN, Double qpfSnowD, Double qpfSnowN, String snowRangeD, String snowRangeN,
            Integer temperatureHeatIndexD, Integer temperatureHeatIndexN, Integer temperatureWindChillD, Integer temperatureWindChillN,
            String windPhraseD, String windPhraseN) {
        
        
        this.date = date;
        this.dayOfWeek = dayOfWeek;
        this.narrative = narrative;
        this.qpf = qpf;
        this.qpfSnow = qpfSnow;
        this.temperatureMax = temperatureMax;
        this.temperatureMin = temperatureMin;

        this.daypartNameD = daypartNameD;
        this.daypartNameN = daypartNameN;
        this.narrativeD = narrativeD;
        this.narrativeN = narrativeN;
        this.precipChanceD = precipChanceD;
        this.precipChanceN = precipChanceN;
        this.cloudCoverD = cloudCoverD;
        this.cloudCoverN = cloudCoverN;
        this.precipTypeD = precipTypeD;
        this.precipTypeN = precipTypeN;
        this.qpfD = qpfD;
        this.qpfN = qpfN;
        this.qpfSnowD = qpfSnowD;
        this.qpfSnowN = qpfSnowN;
        this.snowRangeD = snowRangeD;
        this.snowRangeN = snowRangeN;
        this.temperatureHeatIndexD = temperatureHeatIndexD;
        this.temperatureHeatIndexN = temperatureHeatIndexN;
        this.temperatureWindChillD = temperatureWindChillD;
        this.temperatureWindChillN = temperatureWindChillN;
        this.windPhraseD = windPhraseD;
        this.windPhraseN = windPhraseN;
    }





    public String getDate() {
        return date;
    }





    public String getDayOfWeek() {
        return dayOfWeek;
    }





    public String getNarrative() {
        return narrative;
    }





    public Double getQpf() {
        return qpf;
    }





    public Double getQpfSnow() {
        return qpfSnow;
    }





    public Integer getTemperatureMax() {
        return temperatureMax;
    }





    public Integer getTemperatureMin() {
        return temperatureMin;
    }





    public String getDaypartNameD() {
        return daypartNameD;
    }





    public String getDaypartNameN() {
        return daypartNameN;
    }





    public String getNarrativeD() {
        return narrativeD;
    }





    public String getNarrativeN() {
        return narrativeN;
    }





    public Integer getPrecipChanceD() {
        return precipChanceD;
    }





    public Integer getPrecipChanceN() {
        return precipChanceN;
    }





    public Integer getCloudCoverD() {
        return cloudCoverD;
    }





    public Integer getCloudCoverN() {
        return cloudCoverN;
    }





    public String getPrecipTypeD() {
        return precipTypeD;
    }





    public String getPrecipTypeN() {
        return precipTypeN;
    }





    public Double getQpfD() {
        return qpfD;
    }





    public Double getQpfN() {
        return qpfN;
    }





    public Double getQpfSnowD() {
        return qpfSnowD;
    }





    public Double getQpfSnowN() {
        return qpfSnowN;
    }





    public String getSnowRangeD() {
        return snowRangeD;
    }





    public String getSnowRangeN() {
        return snowRangeN;
    }





    public Integer getTemperatureHeatIndexD() {
        return temperatureHeatIndexD;
    }





    public Integer getTemperatureHeatIndexN() {
        return temperatureHeatIndexN;
    }





    public Integer getTemperatureWindChillD() {
        return temperatureWindChillD;
    }





    public Integer getTemperatureWindChillN() {
        return temperatureWindChillN;
    }





    public String getWindPhraseD() {
        return windPhraseD;
    }





    public String getWindPhraseN() {
        return windPhraseN;
    }




 
}

