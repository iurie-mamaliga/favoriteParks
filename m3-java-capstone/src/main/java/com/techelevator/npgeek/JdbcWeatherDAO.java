package com.techelevator.npgeek;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcWeatherDAO implements WeatherDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcWeatherDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Weather> getWeatherByParkId(String parkCode) {
		List<Weather> fiveDayWeather = new ArrayList<>();

		String sqlSelectFiveDayWeather = "SELECT * FROM weather WHERE parkcode = ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectFiveDayWeather, parkCode);

		while (results.next()) {
			Weather weather = new Weather();
			weather.setParkCode(parkCode);
			weather.setFiveDayForecastValue(results.getInt("fivedayforecastvalue"));
			weather.setLowTemp(results.getInt("low"));
			weather.setHighTemp(results.getInt("high"));
			weather.setForecast(results.getString("forecast"));

			fiveDayWeather.add(weather);
		}
		return fiveDayWeather;
	}
}