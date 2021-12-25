package com.OzUFlix.CS320.Controller;

import com.OzUFlix.CS320.DTO.AvailableDTO;
import com.OzUFlix.CS320.DTO.UserDTO;
import com.OzUFlix.CS320.Service.AvailableService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = AvailableController.class)
@ActiveProfiles("test")
class AvailableControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AvailableService availableService;

    public List<AvailableDTO> allAvailable;

    @BeforeEach
    void setUp() {
        this.allAvailable = new ArrayList<>();
        AvailableDTO first = new AvailableDTO();
        first.setInfo(1);
        allAvailable.add(first);
    }

    @Test
    void findAll() throws Exception {
        given(availableService.findAll()).willReturn(allAvailable);
        this.mockMvc.perform(get("/availableMovies"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(allAvailable.size()));
    }



    @Test
    void getAvailableById() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void saveAvailableMovie() {
    }
}