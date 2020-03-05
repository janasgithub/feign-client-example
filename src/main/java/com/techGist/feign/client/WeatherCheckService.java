package com.techGist.feign.client;

import com.google.gson.JsonObject;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface WeatherCheckService {

    @Headers("Accept: application/json")
    @RequestLine("GET /weather?q={city}&appid={appid}")
    JsonObject getWeatherByCity(@Param("city") String city, @Param("appid") String appId);

}
