  
import java.util.ArrayList;
/**
 * This class is responsible for knowing forecasts, knowing activities, and ranking days/times by chosen activities
 * It collaborates with the Activity, WeatherUndergroundAPI, and NWSAPI class
 * @author Cayde.Roothoff
 *
 */
public class RankForecast {
	private ArrayList<String> rankedList = new ArrayList<String>();
	private Activity activity = new Activity();
	
	public ArrayList<String> getRankedList() {
		return rankedList;
	}
	
	public RankForecast(ArrayList<String> weatherList, Activity activity) {
		this.rankedList = weatherList;
		this.activity = activity;
	}
	
}
