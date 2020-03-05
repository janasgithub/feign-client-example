package com.techGist.feign;

import com.google.gson.JsonObject;
import com.techGist.feign.client.WeatherCheckService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(FeignConfiguration.class)
public class WheatherApp implements CommandLineRunner {

    public WheatherApp(WeatherCheckService weatherCheckService) {
        this.weatherCheckService = weatherCheckService;
    }

    public static void main(String[] args) {
        SpringApplication.run(WheatherApp.class, args);
    }

    final
    WeatherCheckService weatherCheckService;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("Start Application");
        final String appId = "d1967a4093e8902d696d8c1f55f35e9b";
        JsonObject responseDTO = weatherCheckService.getWeatherByCity("London,uk", appId);
        System.out.println(responseDTO.toString());
    }
}
