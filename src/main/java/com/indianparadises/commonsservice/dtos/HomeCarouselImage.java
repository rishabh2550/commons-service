package com.indianparadises.commonsservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HomeCarouselImage {

    private Long imageId;

    private String imageName;

    private byte[] image;

}
