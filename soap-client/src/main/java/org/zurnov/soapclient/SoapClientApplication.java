package org.zurnov.soapclient;

import java.util.Scanner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.zurnov.soapclient.wsdl.GetCryptoResponse;

@SpringBootApplication
public class SoapClientApplication {


  public static void main(String[] args) {
    SpringApplication.run(SoapClientApplication.class, args);
  }

  @Bean
  CommandLineRunner lookup(SoapClient soapClient) {

    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the ticker of the cryptocurrency (e.g., BTC, ETH): ");
    String ticker = scanner.nextLine();
    scanner.close();

    return args -> {
      try {
        GetCryptoResponse response = soapClient.getCrypto(ticker);
        if (response != null && response.getCrypto() != null) {
          System.out.println("Name: " + response.getCrypto().getName());
          System.out.println("Ticker: " + response.getCrypto().getTicker());
          System.out.println("Description: " + response.getCrypto().getDescription());
        } else {
          System.out.println("No data found for ticker: " + ticker);
        }
      } catch (Exception e) {
        System.out.println("Error occurred: " + e.getMessage());
        e.printStackTrace();
      }
    };
  }

}
