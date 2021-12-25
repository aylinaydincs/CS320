package com.OzUFlix.CS320.Controller;

import com.OzUFlix.CS320.DTO.UserDTO;
import com.OzUFlix.CS320.Service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@WebMvcTest(controllers = UserController.class)
@ActiveProfiles("test")
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private List<UserDTO> userList;

    @BeforeEach
    void setUp() {
        this.userList = new ArrayList<>();
        UserDTO user = new UserDTO();
        user.setName("Başak");
        user.setPassword("123");
        user.setUserType(0);
        this.userList.add(user);
    }

    @Test
    void findAll() throws Exception {
        given(userService.findAll()).willReturn(userList);
        this.mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(userList.size()));
    }

    @Test
    void getUserById() throws Exception {
        UserDTO user = new UserDTO();
        user.setId(3);
        user.setName("Ekin");
        user.setPassword("123");
        user.setUserType(0);
        given(userService.findById(3)).willReturn(user);
        this.mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(user.getName()));

    }

    @Test
    void getUserRent() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void save() {
    }

}