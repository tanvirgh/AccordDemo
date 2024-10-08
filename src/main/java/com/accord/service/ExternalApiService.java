package com.accord.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * User : Tanvir Ahmed
 * Date: 11/7/2024.
 */


@RequiredArgsConstructor
@Service
public class ExternalApiService {

   private final WebClient webClient = WebClient.create();

   public String callGoogleApi(){
      return  webClient.get()
              .uri("https://www.google.com")
              .retrieve()
              .bodyToMono(String.class)
              .block();
   }



}
