package org.zurnov.soapclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.zurnov.soapclient.wsdl.GetCryptoRequest;
import org.zurnov.soapclient.wsdl.GetCryptoResponse;


public class SoapClient extends WebServiceGatewaySupport {

  private static final Logger log = LoggerFactory.getLogger(SoapClient.class);

  public GetCryptoResponse getCrypto(String crypto) {

    GetCryptoRequest request = new GetCryptoRequest();
    request.setTicker(crypto);

    log.info("Requesting crypto info for for " + crypto);

    return (GetCryptoResponse) getWebServiceTemplate()
        .marshalSendAndReceive("http://localhost:8080/ws/crypto", request,
            new SoapActionCallback(
                "http://zurnov.com/GetCountryRequest"));
  }
}
