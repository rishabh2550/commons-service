package com.indianparadises.commonsservice.repositories;

import com.indianparadises.commonsservice.entities.HomeCarousel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HomeRepository {

    @Autowired
    private EntityManager em;

    public List<HomeCarousel> fetchHomeCarouselDetails() {
        String jpql = "select h from HomeCarousel h";
        TypedQuery<HomeCarousel> query = em.createQuery(jpql, HomeCarousel.class);
        return query.getResultList();
    }

}
