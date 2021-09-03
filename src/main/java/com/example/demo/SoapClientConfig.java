package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;


@Configuration
public class SoapClientConfig {

    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
       // jaxb2Marshaller.setContextPath("com.example.demo");
        jaxb2Marshaller.setPackagesToScan("com.example.demo.model");
        return jaxb2Marshaller;
    }

    @Bean
    public ArticleClient articleClient(Jaxb2Marshaller jaxb2Marshaller) {
        ArticleClient articleClient = new ArticleClient();
        articleClient.setDefaultUri("http://localhost:8088/article");
        articleClient.setMarshaller(jaxb2Marshaller);
        articleClient.setUnmarshaller(jaxb2Marshaller);
        return articleClient;
    }
}