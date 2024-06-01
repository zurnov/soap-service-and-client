package com.example.soap;

import com.zurnov.GetCryptoRequest;
import com.zurnov.GetCryptoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CryptoEndpoint {
    private static final String NAMESPACE_URI = "http://zurnov.com";

    private CryptoRepository cryptoRepository;

    @Autowired
    public CryptoEndpoint(CryptoRepository cryptoRepository) {
        this.cryptoRepository = cryptoRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCryptoRequest")
    @ResponsePayload
    public GetCryptoResponse getCrypto(@RequestPayload GetCryptoRequest request) {
        GetCryptoResponse response = new GetCryptoResponse();
        response.setCrypto(cryptoRepository.findCrypto(request.getTicker()));

        return response;
    }
}
