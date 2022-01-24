package com.ksa.eat.interfaces;

import java.util.ArrayList;
import java.util.List;

import com.ksa.eat.domain.MemberEntity;
import com.ksa.eat.domain.MemberRepository;
import com.ksa.eat.domain.Restaurant;

import com.ksa.eat.domain.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RestaurantController {

    private final MemberRepository memberRepository;

    private final RestaurantRepository repository;


    @GetMapping("/api/findAll")
    public List<MemberEntity> findAllMembers() {
        // MemberEntity entity = new MemberEntity.builder().username("ddd").name("ssss").build();
        return memberRepository.findAll();
    }


    @GetMapping("/restaurants")
    public List<Restaurant> list() {
        // 아래 두줄은 컨트롤러에 대한 기능만 잘 돌아가는지 테스트. 서비스를 테스트하고 싶으면 아래 두줄을 서비스에 대한 코드로 바꿔주면 된다
        // TODO 아래에 한줄은 서비스 개발할 때 서비스 클래스로 대체 필요
        List<Restaurant> restaurants = repository.findAll();
        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id) {
        // List<Restaurant> restaurants = new ArrayLis<>();
        // 리스트가 위 쪽에서부터 반복된다. 깔끔한 코드를 위해 반복되는 부분을 계속 생성하지 않고 메소드로 빼서 만들면?
        // 원래 이 로직이 있어야 할 곳은 DB가 붙어야 할 곳이므로 리포지토리로 가야 한다.
        Restaurant restaurant = repository.findAllById(id);

        return restaurant;
    }

    @GetMapping("/api/test")
    public String test() {
        return "test api return result!!!";
    }

    @GetMapping("/api/test2")
    public String test2() {
        return "test2 api return result@@@";
    }

    // @GetMapping("/restaurants")
    // public List<Restaurant> list() {
    //     // 아래 두줄은 컨트롤러에 대한 기능만 잘 돌아가는지 테스트. 서비스를 테스트하고 싶으면 아래 두줄을 서비스에 대한 코드로 바꿔주면 된다
    //     // TODO 아래에 세줄은 서비스 개발할 때 서비스 클래스로 대체 필요
    //     List<Restaurant> restaurants = new ArrayList<>();
    //     restaurants.add(new Restaurant(1004L, "Bob zip", "Seoul"));
    //     restaurants.add(new Restaurant(2020L, "Cyber Food", "Seoul"));

    //     return restaurants;
    // }

    // @GetMapping("/restaurants/{id}")
    // public Restaurant detail(@PathVariable("id") Long id) {
    //     List<Restaurant> restaurants = new ArrayLis<>();
    //     // 리스트가 위 쪽에서부터 반복된다. 깔끔한 코드를 위해 반복되는 부분을 계속 생성하지 않고 메소드로 빼서 만들면?
    //     // 원래 이 로직이 있어야 할 곳은 DB가 붙어야 할 곳이므로 리포지토리로 가야 한다.
    //     restaurants.add(new Restaurant(1004L, "Bob zip", "Seoul"));
    //     restaurants.add(new Restaurant(2020L, "Cyber Food", "Seoul"));
    //     return (Restaurant) restaurants.stream()       // stream을 사용하면 람다 식을 사요할 수 있다(요즘 유행하는 함수식 프로그래밍)
    //         .filter(r -> r.getId().equals(id))      // 하나씩 자동으로 루프가 돈다. id가 같은 것만 리턴이 된다
    //         .findFirst()                            // 그중에 첫번째 항목만
    //         .orElse(null);                          // 없다면 null
    // }
}
