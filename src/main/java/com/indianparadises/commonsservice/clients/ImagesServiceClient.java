package com.indianparadises.commonsservice.clients;

import com.indianparadises.commonsservice.dtos.HomeCarouselImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ImagesServiceClient {

    @Autowired
    private RestTemplate restTemplate;

    private String baseUrl;

    public ImagesServiceClient(@Value("${images-service.ip}") String ip, @Value("${images-service.port}") int port) {
        baseUrl = "http://" + ip + ":" +port;
    }

    public List<HomeCarouselImage> fetchHomeCarouselImages() {
        baseUrl += "/fetchHomeCarouselImages";
        List<HomeCarouselImage> homeCarouselImages = null;
        ResponseEntity<List<HomeCarouselImage>> responseEntity = restTemplate.exchange(baseUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<HomeCarouselImage>>() {});
        if(responseEntity.getStatusCode().equals(HttpStatus.OK)) {
            homeCarouselImages = responseEntity.getBody();
        }else {
            // code to handle error
        }
        return homeCarouselImages;
    }

}
