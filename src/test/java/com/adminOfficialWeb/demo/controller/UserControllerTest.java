package com.adminOfficialWeb.demo.controller;

import com.adminOfficialWeb.demo.dto.UserDTO;
import com.adminOfficialWeb.demo.entity.User;
import com.adminOfficialWeb.demo.service.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;


public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;

    @Mock
    private UserServiceImpl userService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void getAllUser() throws Exception {
        List<UserDTO> userDTOS = new ArrayList<>();
        UserDTO userDTO = new UserDTO();
        userDTO.setName("ufuk");
        userDTO.setSurname("ünal");
        userDTO.setEmail("ufuk@unal");
        userDTO.setPassword("1234");
        userDTOS.add(userDTO);
        UserDTO userDTO1 = new UserDTO();
        userDTO1.setName("ufuk");
        userDTO1.setSurname("ünal");
        userDTO1.setEmail("ufuk@unal");
        userDTO1.setPassword("1234");
        userDTOS.add(userDTO1);
        when(userService.findAll()).thenReturn(userDTOS);
        mockMvc.perform(MockMvcRequestBuilders.get("/users/all")
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.data",hasSize(2)));
    }

}
