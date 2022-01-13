package com.ksa.eat.interfaces;

import java.util.ArrayList;
import java.util.List;

import com.ksa.eat.domain.Restaurant;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {

    @GetMapping("/restaurants")
    public List<Restaurant> list() {
        // 아래 두줄은 컨트롤러에 대한 기능만 잘 돌아가는지 테스트. 서비스를 테스트하고 싶으면 아래 두줄을 서비스에 대한 코드로 바꿔주면 된다
        // TODO 아래에 두줄은 서비스 개발할 때 서비스 클래스로 대체 필요
        List<Restaurant> restaurants = new ArrayList<>();
        Restaurant restaurant = new Restaurant(1004L, "Bob zip", "Seoul");

        restaurants.add(restaurant);
        return restaurants;
    }
}
