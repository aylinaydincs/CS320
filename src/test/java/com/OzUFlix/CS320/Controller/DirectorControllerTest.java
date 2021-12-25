package com.OzUFlix.CS320.Controller;


import com.OzUFlix.CS320.DTO.DirectorDTO;
import com.OzUFlix.CS320.Service.DirectorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;


import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@WebMvcTest(controllers = DirectorController.class)
@ActiveProfiles("test")
class DirectorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DirectorService directorService;

    private List<DirectorDTO> directorList;

    @BeforeEach
    void setUp() {
        this.directorList = new ArrayList<>();
        DirectorDTO director = new DirectorDTO();
        director.setName("Nolan");
        this.directorList.add(director);
    }
    @Test
    void findAll() throws Exception {
        given(directorService.findAll()).willReturn(directorList);
        this.mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(directorList.size()));

    }

    @Test
    void getMovieById() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void saveMovie() {
    }
}