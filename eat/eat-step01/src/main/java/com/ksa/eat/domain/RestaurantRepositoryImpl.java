package com.ksa.eat.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RestaurantRepositoryImpl implements RestaurantRepository {

    private List<Restaurant> restaurants = new ArrayList<Restaurant>();

    public RestaurantRepositoryImpl() {
        restaurants.add(new Restaurant(1004L, "Bob zip", "Seoul"));
        restaurants.add(new Restaurant(2020L, "Cyber Food", "Seoul"));
    }

    @Override
    public List<Restaurant> findAll() {
        return restaurants;
    }

    @Override
    public Restaurant findAllById(Long id) {
        return (Restaurant) restaurants.stream()       // stream을 사용하면 람다 식을 사요할 수 있다(요즘 유행하는 함수식 프로그래밍)
                .filter(r -> r.getId().equals(id))      // 하나씩 자동으로 루프가 돈다. id가 같은 것만 리턴이 된다
                .findFirst()                            // 그중에 첫번째 항목만
                .orElse(null);                          // 없다면 null

        // 람다를 사용하지 않고 만드려면 리스트 사이즈만큼 반복문을 돌면 된다
        // for(Restaurant r : restaurant) {
        //     if (r.getId() == id) {
        //         return r;
        //     }
        // }
        // return restaurant;
    }
}
