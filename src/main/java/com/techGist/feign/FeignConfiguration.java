package com.techGist.feign;


import com.techGist.feign.client.WeatherCheckService;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.slf4j.Slf4jLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5";


    @Bean
    public WeatherCheckService weatherCheckService() {
        return Feign.builder()
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(WeatherCheckService.class))
                .logLevel(feign.Logger.Level.FULL)
                .target(WeatherCheckService.class, BASE_URL);
    }
}
