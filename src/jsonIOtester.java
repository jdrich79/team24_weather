import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class jsonIOtester {

	@Test
	void fileReadWriteTest() {
		jsonIO jio = new jsonIO();
		ArrayList<location> writeLocations = new ArrayList<location>();
		ArrayList<location> readLocations = new ArrayList<location>();
		String testFile = "testfile.json";
		
		for (int i = 0; i < 10; i++) {
			writeLocations.add(new location());
			writeLocations.get(i).setDisplayName("Display Name " + i);
			writeLocations.get(i).setLatitude(Integer.toString(i));
			writeLocations.get(i).setLongitude(Integer.toString(i));
			
		}
		
		jio.fileWriter(writeLocations, testFile);
		readLocations = jio.fileReader(testFile);
		
		for (int j = 0; j < 10; j++) {
			
			assertEquals(writeLocations.get(j).getDisplayName(), readLocations.get(j).getDisplayName());
			assertEquals(writeLocations.get(j).getLatitude(), readLocations.get(j).getLatitude());
			assertEquals(writeLocations.get(j).getLongitude(), readLocations.get(j).getLongitude());
		}
		
	}
	
	@Test
	void parseGPSTest() {
		
		String responseBody = "{\r\n" + 
				"    \"@context\": [\r\n" + 
				"        \"https://raw.githubusercontent.com/geojson/geojson-ld/master/contexts/geojson-base.jsonld\",\r\n" + 
				"        {\r\n" + 
				"            \"wx\": \"https://api.weather.gov/ontology#\",\r\n" + 
				"            \"s\": \"https://schema.org/\",\r\n" + 
				"            \"geo\": \"http://www.opengis.net/ont/geosparql#\",\r\n" + 
				"            \"unit\": \"http://codes.wmo.int/common/unit/\",\r\n" + 
				"            \"@vocab\": \"https://api.weather.gov/ontology#\",\r\n" + 
				"            \"geometry\": {\r\n" + 
				"                \"@id\": \"s:GeoCoordinates\",\r\n" + 
				"                \"@type\": \"geo:wktLiteral\"\r\n" + 
				"            },\r\n" + 
				"            \"city\": \"s:addressLocality\",\r\n" + 
				"            \"state\": \"s:addressRegion\",\r\n" + 
				"            \"distance\": {\r\n" + 
				"                \"@id\": \"s:Distance\",\r\n" + 
				"                \"@type\": \"s:QuantitativeValue\"\r\n" + 
				"            },\r\n" + 
				"            \"bearing\": {\r\n" + 
				"                \"@type\": \"s:QuantitativeValue\"\r\n" + 
				"            },\r\n" + 
				"            \"value\": {\r\n" + 
				"                \"@id\": \"s:value\"\r\n" + 
				"            },\r\n" + 
				"            \"unitCode\": {\r\n" + 
				"                \"@id\": \"s:unitCode\",\r\n" + 
				"                \"@type\": \"@id\"\r\n" + 
				"            },\r\n" + 
				"            \"forecastOffice\": {\r\n" + 
				"                \"@type\": \"@id\"\r\n" + 
				"            },\r\n" + 
				"            \"forecastGridData\": {\r\n" + 
				"                \"@type\": \"@id\"\r\n" + 
				"            },\r\n" + 
				"            \"publicZone\": {\r\n" + 
				"                \"@type\": \"@id\"\r\n" + 
				"            },\r\n" + 
				"            \"county\": {\r\n" + 
				"                \"@type\": \"@id\"\r\n" + 
				"            }\r\n" + 
				"        }\r\n" + 
				"    ],\r\n" + 
				"    \"id\": \"https://api.weather.gov/points/39.7456,-97.0892\",\r\n" + 
				"    \"type\": \"Feature\",\r\n" + 
				"    \"geometry\": {\r\n" + 
				"        \"type\": \"Point\",\r\n" + 
				"        \"coordinates\": [\r\n" + 
				"            -97.089200000000005,\r\n" + 
				"            39.745600000000003\r\n" + 
				"        ]\r\n" + 
				"    },\r\n" + 
				"    \"properties\": {\r\n" + 
				"        \"@id\": \"https://api.weather.gov/points/39.7456,-97.0892\",\r\n" + 
				"        \"@type\": \"wx:Point\",\r\n" + 
				"        \"cwa\": \"TOP\",\r\n" + 
				"        \"forecastOffice\": \"https://api.weather.gov/offices/TOP\",\r\n" + 
				"        \"gridX\": 31,\r\n" + 
				"        \"gridY\": 80,\r\n" + 
				"        \"forecast\": \"https://api.weather.gov/gridpoints/TOP/31,80/forecast\",\r\n" + 
				"        \"forecastHourly\": \"https://api.weather.gov/gridpoints/TOP/31,80/forecast/hourly\",\r\n" + 
				"        \"forecastGridData\": \"https://api.weather.gov/gridpoints/TOP/31,80\",\r\n" + 
				"        \"observationStations\": \"https://api.weather.gov/gridpoints/TOP/31,80/stations\",\r\n" + 
				"        \"relativeLocation\": {\r\n" + 
				"            \"type\": \"Feature\",\r\n" + 
				"            \"geometry\": {\r\n" + 
				"                \"type\": \"Point\",\r\n" + 
				"                \"coordinates\": [\r\n" + 
				"                    -97.086661000000007,\r\n" + 
				"                    39.679375999999998\r\n" + 
				"                ]\r\n" + 
				"            },\r\n" + 
				"            \"properties\": {\r\n" + 
				"                \"city\": \"Linn\",\r\n" + 
				"                \"state\": \"KS\",\r\n" + 
				"                \"distance\": {\r\n" + 
				"                    \"value\": 7366.9851976443715,\r\n" + 
				"                    \"unitCode\": \"unit:m\"\r\n" + 
				"                },\r\n" + 
				"                \"bearing\": {\r\n" + 
				"                    \"value\": 358,\r\n" + 
				"                    \"unitCode\": \"unit:degrees_true\"\r\n" + 
				"                }\r\n" + 
				"            }\r\n" + 
				"        },\r\n" + 
				"        \"forecastZone\": \"https://api.weather.gov/zones/forecast/KSZ009\",\r\n" + 
				"        \"county\": \"https://api.weather.gov/zones/county/KSC201\",\r\n" + 
				"        \"fireWeatherZone\": \"https://api.weather.gov/zones/fire/KSZ009\",\r\n" + 
				"        \"timeZone\": \"America/Chicago\",\r\n" + 
				"        \"radarStation\": \"KTWX\"\r\n" + 
				"    }\r\n" + 
				"}";
		
		String responseBody2 = "{\r\n" + 
				"    \"@context\": [\r\n" + 
				"        \"https://raw.githubusercontent.com/geojson/geojson-ld/master/contexts/geojson-base.jsonld\",\r\n" + 
				"        {\r\n" + 
				"            \"wx\": \"https://api.weather.gov/ontology#\",\r\n" + 
				"            \"s\": \"https://schema.org/\",\r\n" + 
				"            \"geo\": \"http://www.opengis.net/ont/geosparql#\",\r\n" + 
				"            \"unit\": \"http://codes.wmo.int/common/unit/\",\r\n" + 
				"            \"@vocab\": \"https://api.weather.gov/ontology#\",\r\n" + 
				"            \"geometry\": {\r\n" + 
				"                \"@id\": \"s:GeoCoordinates\",\r\n" + 
				"                \"@type\": \"geo:wktLiteral\"\r\n" + 
				"            },\r\n" + 
				"            \"city\": \"s:addressLocality\",\r\n" + 
				"            \"state\": \"s:addressRegion\",\r\n" + 
				"            \"distance\": {\r\n" + 
				"                \"@id\": \"s:Distance\",\r\n" + 
				"                \"@type\": \"s:QuantitativeValue\"\r\n" + 
				"            },\r\n" + 
				"            \"bearing\": {\r\n" + 
				"                \"@type\": \"s:QuantitativeValue\"\r\n" + 
				"            },\r\n" + 
				"            \"value\": {\r\n" + 
				"                \"@id\": \"s:value\"\r\n" + 
				"            },\r\n" + 
				"            \"unitCode\": {\r\n" + 
				"                \"@id\": \"s:unitCode\",\r\n" + 
				"                \"@type\": \"@id\"\r\n" + 
				"            },\r\n" + 
				"            \"forecastOffice\": {\r\n" + 
				"                \"@type\": \"@id\"\r\n" + 
				"            },\r\n" + 
				"            \"forecastGridData\": {\r\n" + 
				"                \"@type\": \"@id\"\r\n" + 
				"            },\r\n" + 
				"            \"publicZone\": {\r\n" + 
				"                \"@type\": \"@id\"\r\n" + 
				"            },\r\n" + 
				"            \"county\": {\r\n" + 
				"                \"@type\": \"@id\"\r\n" + 
				"            }\r\n" + 
				"        }\r\n" + 
				"    ],\r\n" + 
				"    \"id\": \"https://api.weather.gov/points/39.7391999,-104\",\r\n" + 
				"    \"type\": \"Feature\",\r\n" + 
				"    \"geometry\": {\r\n" + 
				"        \"type\": \"Point\",\r\n" + 
				"        \"coordinates\": [\r\n" + 
				"            -104,\r\n" + 
				"            39.739199900000003\r\n" + 
				"        ]\r\n" + 
				"    },\r\n" + 
				"    \"properties\": {\r\n" + 
				"        \"@id\": \"https://api.weather.gov/points/39.7391999,-104\",\r\n" + 
				"        \"@type\": \"wx:Point\",\r\n" + 
				"        \"cwa\": \"BOU\",\r\n" + 
				"        \"forecastOffice\": \"https://api.weather.gov/offices/BOU\",\r\n" + 
				"        \"gridX\": 96,\r\n" + 
				"        \"gridY\": 58,\r\n" + 
				"        \"forecast\": \"https://api.weather.gov/gridpoints/BOU/96,58/forecast\",\r\n" + 
				"        \"forecastHourly\": \"https://api.weather.gov/gridpoints/BOU/96,58/forecast/hourly\",\r\n" + 
				"        \"forecastGridData\": \"https://api.weather.gov/gridpoints/BOU/96,58\",\r\n" + 
				"        \"observationStations\": \"https://api.weather.gov/gridpoints/BOU/96,58/stations\",\r\n" + 
				"        \"relativeLocation\": {\r\n" + 
				"            \"type\": \"Feature\",\r\n" + 
				"            \"geometry\": {\r\n" + 
				"                \"type\": \"Point\",\r\n" + 
				"                \"coordinates\": [\r\n" + 
				"                    -104.043065,\r\n" + 
				"                    39.615811999999998\r\n" + 
				"                ]\r\n" + 
				"            },\r\n" + 
				"            \"properties\": {\r\n" + 
				"                \"city\": \"Deer Trail\",\r\n" + 
				"                \"state\": \"CO\",\r\n" + 
				"                \"distance\": {\r\n" + 
				"                    \"value\": 14206.521167808369,\r\n" + 
				"                    \"unitCode\": \"unit:m\"\r\n" + 
				"                },\r\n" + 
				"                \"bearing\": {\r\n" + 
				"                    \"value\": 15,\r\n" + 
				"                    \"unitCode\": \"unit:degrees_true\"\r\n" + 
				"                }\r\n" + 
				"            }\r\n" + 
				"        },\r\n" + 
				"        \"forecastZone\": \"https://api.weather.gov/zones/forecast/COZ045\",\r\n" + 
				"        \"county\": \"https://api.weather.gov/zones/county/COC005\",\r\n" + 
				"        \"fireWeatherZone\": \"https://api.weather.gov/zones/fire/COZ245\",\r\n" + 
				"        \"timeZone\": \"America/Denver\",\r\n" + 
				"        \"radarStation\": \"KFTG\"\r\n" + 
				"    }\r\n" + 
				"}";
		jsonIO jio = new jsonIO();
		ArrayList<String> urls = jio.parseGPS(responseBody);
		ArrayList<String> urls2 = jio.parseGPS(responseBody2);
		
		assertEquals("https://api.weather.gov/gridpoints/TOP/31,80/forecast", urls.get(0));
		assertEquals("https://api.weather.gov/gridpoints/TOP/31,80", urls.get(1));
		assertEquals("https://api.weather.gov/gridpoints/BOU/96,58/forecast", urls2.get(0));
		assertEquals("https://api.weather.gov/gridpoints/BOU/96,58", urls2.get(1));
	}

}
