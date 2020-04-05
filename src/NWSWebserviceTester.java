

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
		
		String[] coordinates = {"39.734,-104.904561045", "40.748,-73.98", "40.843,-73.20", ""};
		
		
		ArrayList<FiveDayForecast> forecast1 = nws.getNWSForecast(coordinates[0]);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<FiveDayForecast> forecast2 = nws.getNWSForecast(coordinates[1]);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<FiveDayForecast> forecast3 = nws.getNWSForecast(coordinates[2]);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<FiveDayForecast> forecast4 = nws.getNWSForecast(coordinates[3]);
		
		assertEquals(today.toString(), forecast1.get(0).getDate());
		assertEquals(today.toString(), forecast2.get(0).getDate());
		assertEquals(today.toString(), forecast3.get(0).getDate());
		
		assertEquals(today.plusDays(1).toString(), forecast1.get(1).getDate());
		assertEquals(today.plusDays(1).toString(), forecast2.get(1).getDate());
		assertEquals(today.plusDays(1).toString(), forecast3.get(1).getDate());
		
		assertEquals(null, forecast4);
		
	}

}