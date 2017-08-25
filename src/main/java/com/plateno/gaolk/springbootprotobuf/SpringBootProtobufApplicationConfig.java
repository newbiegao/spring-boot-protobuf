package com.plateno.gaolk.springbootprotobuf;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;


@Configuration
public class SpringBootProtobufApplicationConfig {

    @Autowired
    private  RestTemplateBuilder restTemplateBuilder ;

    @Bean
    public ProtobufHttpMessageConverter protobufHttpMessageConverter(){

        return new ProtobufHttpMessageConverter() ;
    }

    @Bean
    public RestTemplate restTemplate(){

        RestTemplate restTemplate = new RestTemplate() ;
        restTemplate.getMessageConverters().add(new  ProtobufHttpMessageConverter());

        restTemplate.getInterceptors().add(new ClientHttpRequestInterceptor() {
            @Override
            public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

                request.getHeaders().add("Content-Type","application/x-protobuf");
                request.getHeaders().add("Accept","application/x-protobuf");
                return execution.execute(request, body);
            }
        }) ;

        return restTemplate ;
    }
}
