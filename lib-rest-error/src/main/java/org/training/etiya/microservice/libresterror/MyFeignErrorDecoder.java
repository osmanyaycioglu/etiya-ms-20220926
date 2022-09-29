package org.training.etiya.microservice.libresterror;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;
import java.io.InputStream;

public class MyFeignErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey,
                            Response response) {
        try {
            InputStream inputStream = response.body()
                                              .asInputStream();
            ObjectMapper objectMapper = new ObjectMapper();
            ErrorObj errorObj = objectMapper.readValue(inputStream,
                                                       ErrorObj.class);
            return  new RestFeignException(errorObj,response.status());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new RestFeignException();
    }
}
