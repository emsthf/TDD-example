package com.ksa.eat.interfaces;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ksa.eat.domain.RestaurantRepositoryImpl;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.core.StringContains.containsString;

// Junit5 설정
@ExtendWith(SpringExtension.class)   // Spring으로 테스트 할거야~ 라는 뜻
// 특정 클래스의 테스트 지정
@WebMvcTest(controllers = RestaurantController.class)   // Web MVC 클래스라는 것을 지정해줘야 한다
public class RestaurantControllerTest {
    @Autowired
    private MockMvc mvc;

    // RestaurantController에서 @Autowired 적용된 모든 멤버 변수는
    // RestaurantControllerTest에서 @SpyBean 적용된 멤버 변수로 등록 필요!!!
    // 멤버 변수 수가 많아지면 @MockBean을 이용하는 방법도 있다.
    @SpyBean
    private RestaurantRepositoryImpl restaurantRepository;     // SpyBean 어노테이션을 이용해서 스프링이 자동으로 의존성 주입하게 해야 한다

    // 가게 목록
    // "\"name\":\"Bob zip\""
    @Test
    public void list() throws Exception {
        mvc.perform(                    // 컨트롤러 테스트
                get("/restaurants"))        // 호출할 URI
                .andExpect(                 // 결과 확인
                        status().isOk())        // 접속 결과 상태 코드 값
                .andExpect(content()
                        .string(containsString("\"name\":\"Bob zip\"")));
    }

    // 가게 상세
    // \"id\":\"1004\"
    // \"name\":\"Bob zip\"
    @Test
    public void detail() throws Exception {
        mvc.perform(get("/restaurants/1004"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"id\":1004")))
                .andExpect(content().string(containsString("\"name\":\"Bob zip\"")));
        mvc.perform(get("/restaurants/2020"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"id\":2020")))
                .andExpect(content().string(containsString("\"name\":\"Cyber Food\"")));
    }
}
