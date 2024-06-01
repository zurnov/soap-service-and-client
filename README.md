# soap-service-and-client

## Client endpoint

#### Request
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:gs="http://zurnov.com">
   <soapenv:Header/>
   <soapenv:Body>
      <gs:getCryptoRequest>
         <gs:ticker>BTC</gs:ticker>
      </gs:getCryptoRequest>
   </soapenv:Body>
</soapenv:Envelope>

```

#### Response
```
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <ns2:getCryptoResponse xmlns:ns2="http://zurnov.com">
            <ns2:crypto>
                <ns2:name>Bitcoin</ns2:name>
                <ns2:ticker>BTC</ns2:ticker>
                <ns2:description>A decentralized digital currency without a central bank or single administrator.</ns2:description>
            </ns2:crypto>
        </ns2:getCryptoResponse>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>

```
