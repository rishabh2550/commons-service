package com.indianparadises.commonsservice.services;

import com.indianparadises.commonsservice.clients.ImagesServiceClient;
import com.indianparadises.commonsservice.dtos.HomeCarouselImage;
import com.indianparadises.commonsservice.dtos.HomeCarouselResponse;
import com.indianparadises.commonsservice.entities.HomeCarousel;
import com.indianparadises.commonsservice.repositories.HomeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class HomeServiceTests {

    @Mock
    private HomeRepository homeRepository;

    @Mock
    private ImagesServiceClient imagesServiceClient;

    @InjectMocks
    private HomeService homeService;

    private List<HomeCarousel> homeCarouselDetails;
    private List<HomeCarouselImage> homeCarouselImages;


    @BeforeEach
    public void setUp() {
        homeCarouselDetails = createHomeCarouselDetailsStub();
        homeCarouselImages = createHomeCarouselImagesStub();
    }

    @Test
    public void testHappyPathFetchHomeCarouselDetails() {
        when(homeRepository.fetchHomeCarouselDetails()).thenReturn(homeCarouselDetails);
        when(imagesServiceClient.fetchHomeCarouselImages()).thenReturn(homeCarouselImages);

        List<HomeCarouselResponse> homeCarouselResponseList = homeService.fetchHomeCarouselDetails();

        assertEquals(4, homeCarouselResponseList.size());
        assertEquals(1L, homeCarouselResponseList.get(0).getId());
        assertEquals("Timeless Elegance", homeCarouselResponseList.get(0).getHeader());
        assertEquals("The Majestic Taj Mahal", homeCarouselResponseList.get(0).getDescription());
        assertEquals(202L, homeCarouselResponseList.get(0).getImageId());
        assertEquals("taj_mahal.jpg", homeCarouselResponseList.get(0).getImageName());

        assertEquals(2L, homeCarouselResponseList.get(1).getId());
        assertEquals("Sacred Marvels", homeCarouselResponseList.get(1).getHeader());
        assertEquals("Exploring the Mystical Grandeur of Ancient Indian Temples", homeCarouselResponseList.get(1).getDescription());
        assertEquals(452L, homeCarouselResponseList.get(1).getImageId());
        assertEquals("thanjavur_temple.jpg", homeCarouselResponseList.get(1).getImageName());

        assertEquals(3L, homeCarouselResponseList.get(2).getId());
        assertEquals("Celebrating Diversity", homeCarouselResponseList.get(2).getHeader());
        assertEquals("Colors, Rhythms, and Joy of Indian Festivals", homeCarouselResponseList.get(2).getDescription());
        assertEquals(502L, homeCarouselResponseList.get(2).getImageId());
        assertEquals("holi.jpg", homeCarouselResponseList.get(2).getImageName());

        assertEquals(4L, homeCarouselResponseList.get(3).getId());
        assertEquals("Escaping to Serenity", homeCarouselResponseList.get(3).getHeader());
        assertEquals("Discovering the Tranquil Beauty of Indian Hill Stations", homeCarouselResponseList.get(3).getDescription());
        assertEquals(552L, homeCarouselResponseList.get(3).getImageId());
        assertEquals("hill_station.jpg", homeCarouselResponseList.get(3).getImageName());
    }

    private List<HomeCarousel> createHomeCarouselDetailsStub() {
        List<HomeCarousel> homeCarouselDetails = new ArrayList<>();
        homeCarouselDetails.add(new HomeCarousel(1L, "Timeless Elegance",
                "The Majestic Taj Mahal", 202L));
        homeCarouselDetails.add(new HomeCarousel(2L, "Sacred Marvels",
                "Exploring the Mystical Grandeur of Ancient Indian Temples", 452L));
        homeCarouselDetails.add(new HomeCarousel(3L, "Celebrating Diversity",
                "Colors, Rhythms, and Joy of Indian Festivals", 502L));
        homeCarouselDetails.add(new HomeCarousel(4L, "Escaping to Serenity",
                "Discovering the Tranquil Beauty of Indian Hill Stations", 552L));
        return homeCarouselDetails;
    }

    private List<HomeCarouselImage> createHomeCarouselImagesStub() {
        List<HomeCarouselImage> homeCarouselImages = new ArrayList<>();
        homeCarouselImages.add(new HomeCarouselImage(202L, "taj_mahal.jpg", null));
        homeCarouselImages.add(new HomeCarouselImage(452L, "thanjavur_temple.jpg", null));
        homeCarouselImages.add(new HomeCarouselImage(502L, "holi.jpg", null));
        homeCarouselImages.add(new HomeCarouselImage(552L, "hill_station.jpg", null));
        return homeCarouselImages;
    }

}
