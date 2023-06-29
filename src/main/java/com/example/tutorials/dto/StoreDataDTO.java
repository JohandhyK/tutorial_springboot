package com.example.tutorials.dto;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "saved")
public class StoreDataDTO {

	    private Location location;
	    private CurrentWeather current;

	@Data
	public static class Location {
	    private String name;
	    private String region;
	    private String country;
	    private double lat;
	    private double lon;
	    private String tz_id;
	    private long localtime_epoch;
	    private String localtime;
	}

	@Data
	public static class CurrentWeather {
	    private long last_updated_epoch;
	    private String last_updated;
	    private double temp_c;
	    private double temp_f;
	    private int is_day;
	    private Condition condition;
	    private double wind_mph;
	    private double wind_kph;
	    private int wind_degree;
	    private String wind_dir;
	    private double pressure_mb;
	    private double pressure_in;
	    private double precip_mm;
	    private double precip_in;
	    private int humidity;
	    private int cloud;
	    private double feelslike_c;
	    private double feelslike_f;
	    private double vis_km;
	    private double vis_miles;
	    private double uv;
	    private double gust_mph;
	    private double gust_kph;
	    private AirQuality air_quality;
	}

	@Data
	public static class Condition {
	    private String text;
	    private String icon;
	    private int code;
	}

	@Data
	public static class AirQuality {
	    private double co;
	    private double no2;
	    private double o3;
	    private double so2;
	    private double pm2_5;
	    private double pm10;
	    private int us_epa_index;
	    private int gb_defra_index;
	}

}
