package com.indianparadises.commonsservice.controllers;

import com.indianparadises.commonsservice.dtos.HomeCarouselResponse;
import com.indianparadises.commonsservice.services.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private HomeService homeService;

    @GetMapping(path = "/fetchHomeCarouselDetails")
    public ResponseEntity<List<HomeCarouselResponse>> fetchHomeCarouselDetails() {
        List<HomeCarouselResponse> homeCarouselResponseList = homeService.fetchHomeCarouselDetails();
        return new ResponseEntity<>(homeCarouselResponseList, HttpStatus.OK);
    }

}
