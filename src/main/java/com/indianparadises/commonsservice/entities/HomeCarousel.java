package com.indianparadises.commonsservice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class HomeCarousel {

    public HomeCarousel(String header, String description, Long imageId) {
        this.header = header;
        this.description = description;
        this.imageId = imageId;
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String header;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Long imageId;

}
