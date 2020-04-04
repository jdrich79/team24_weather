

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class NWSWebserviceTester {

	@Test
	void NWSCalltest() {
		NWSWeatherWebservice nws = new NWSWeatherWebservice();
		LocalDate today = LocalDate.now();
		
		String[] coordinates = {"39.734,-104.9", "40.74,8-73.98", "40.843,-73.20", ""};
		
		
		ArrayList<FiveDayForecast> forecast1 = nws.getNWSForecast(coordinates[0]);
		ArrayList<FiveDayForecast> forecast2 = nws.getNWSForecast(coordinates[1]);
		ArrayList<FiveDayForecast> forecast3 = nws.getNWSForecast(coordinates[2]);
		ArrayList<FiveDayForecast> forecast4 = nws.getNWSForecast(coordinates[3]);
		
		assertEquals(today.toString(), forecast1.get(0).getDate());
		
		
	}

}
