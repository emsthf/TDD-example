package com.ksa.eat.interfaces;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.core.StringContains.containsString;

// Junit5 설정
@ExtendWith(SpringExtension.class)   // Spring으로 테스트 할거야~ 라는 뜻
// 특정 클래스의 테스트 지정
@WebMvcTest(controllers = RestaurantController.class)   // Web MVC 클래스라는 것을 지정해줘야 한다
public class RestaurantControllerTest {
    @Autowired
    private MockMvc mvc;

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
}
