package com.example.soap;

import com.zurnov.Crypto;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

@Component
public class CryptoRepository {
    private static final Map<String, Crypto> cryptos = new HashMap<>();

    @PostConstruct
    public void initData() {
        Crypto bitcoin = new Crypto();
        bitcoin.setName("Bitcoin");
        bitcoin.setTicker("BTC");
        bitcoin.setDescription("A decentralized digital currency without a central bank or single administrator.");

        cryptos.put(bitcoin.getTicker(), bitcoin);

        Crypto ethereum = new Crypto();
        ethereum.setName("Ethereum");
        ethereum.setTicker("ETH");
        ethereum.setDescription("A decentralized, open-source blockchain with smart contract functionality.");

        cryptos.put(ethereum.getTicker(), ethereum);
    }

    public Crypto findCrypto(String ticker) {
        Assert.notNull(ticker, "The crypto ticker must not be null");
        return cryptos.get(ticker);
    }
}

