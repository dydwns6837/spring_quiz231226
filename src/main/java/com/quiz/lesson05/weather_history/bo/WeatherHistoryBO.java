package com.quiz.lesson05.weather_history.bo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson05.weather_history.domain.WeatherHistory;
import com.quiz.lesson05.weather_history.mapper.WeatherHistoryMapper;

@Service
public class WeatherHistoryBO {
	
	@Autowired
	private WeatherHistoryMapper weatherhistoryMapper;
	
	public List<WeatherHistory> getWeatherHistoryList() {
		return weatherhistoryMapper.selectWeatherHistoryList();
	}
	
	public void addWeatherHistory(Date date, String weather, String microDust,
			double temperatures, double precipitation, double windSpeed) {
		
		weatherhistoryMapper.insertWeatherHistory(date, weather, microDust, temperatures, precipitation, windSpeed);
	}
}
