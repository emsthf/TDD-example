package com.ksa.eat.domain;

import java.util.List;

public interface RestaurantRepository {
    List<Restaurant> findAll();
    Restaurant findAllById(Long id);
}
