package com.indianparadises.commonsservice.services;

import com.indianparadises.commonsservice.clients.ImagesServiceClient;
import com.indianparadises.commonsservice.dtos.HomeCarouselImage;
import com.indianparadises.commonsservice.dtos.HomeCarouselResponse;
import com.indianparadises.commonsservice.entities.HomeCarousel;
import com.indianparadises.commonsservice.repositories.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HomeService {

    @Autowired
    private HomeRepository homeRepository;

    @Autowired
    private ImagesServiceClient imagesServiceClient;

    public List<HomeCarouselResponse> fetchHomeCarouselDetails() {
        List<HomeCarousel> homeCarouselDetails = homeRepository.fetchHomeCarouselDetails();
        List<HomeCarouselImage> homeCarouselImages = imagesServiceClient.fetchHomeCarouselImages();
        List<HomeCarouselResponse> homeCarouselResponseList = createHomeCarouselResponseList(homeCarouselDetails, homeCarouselImages);
        return homeCarouselResponseList;
    }

    private List<HomeCarouselResponse> createHomeCarouselResponseList(List<HomeCarousel> homeCarouselDetails, List<HomeCarouselImage> homeCarouselImages) {
        List<HomeCarouselResponse> homeCarouselResponseList = new ArrayList<>();
        for(int i=0; i<homeCarouselDetails.size(); i++) {
            HomeCarousel homeCarousel = homeCarouselDetails.get(i);
            Optional<HomeCarouselImage> result = homeCarouselImages.stream().filter(img -> img.getImageId().equals(homeCarousel.getImageId())).findFirst();
            if(result.isPresent()) {
                HomeCarouselImage homeCarouselImage = result.get();
                HomeCarouselResponse homeCarouselResponse = new HomeCarouselResponse();
                homeCarouselResponse.setId(homeCarousel.getId());
                homeCarouselResponse.setHeader(homeCarousel.getHeader());
                homeCarouselResponse.setDescription(homeCarousel.getDescription());
                homeCarouselResponse.setImageId(homeCarouselImage.getImageId());
                homeCarouselResponse.setImageName(homeCarouselImage.getImageName());
                homeCarouselResponse.setImage(homeCarouselImage.getImage());
                homeCarouselResponseList.add(homeCarouselResponse);
            }
        }
        return homeCarouselResponseList;
    }

}
