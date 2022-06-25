package com.talendig.springboottalendig.thirdpartyapi.feignclient.config;

import com.talendig.springboottalendig.thirdpartyapi.feignclient.client.FeignClient;
import feign.Feign;
import feign.Logger;
import feign.httpclient.ApacheHttpClient;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfiguration {

    @Value("${jsonplaceholder.server}")
    private String jsonPlaceholderServer;

    @Bean
    FeignClient feignClientBuilder() {
        return Feign.builder()
                .client(new ApacheHttpClient())
                .contract(new SpringMvcContract())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .logger(new Slf4jLogger(FeignClient.class))
                .logLevel(Logger.Level.BASIC)
                .target(FeignClient.class, jsonPlaceholderServer);
    }

}
