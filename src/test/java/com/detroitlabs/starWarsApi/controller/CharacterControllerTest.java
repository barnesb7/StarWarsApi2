package com.detroitlabs.starWarsApi.controller;

import com.detroitlabs.starWarsApi.Service.StarWarsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
public class CharacterControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private CharacterController characterController;

    @InjectMocks
    private StarWarsService starWarsService;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(characterController).build();
    }

    @Test
    public void displayHomePage() {

        try {
            mockMvc.perform(
                    MockMvcRequestBuilders.get("/"))
                    .andExpect(status().isOk())
                    .andExpect(view().name("homepage"));

        }catch(Exception e){
            e.printStackTrace();
        }
    }

//   @Test
//    public void displayCharacterDetailsPage() {
//
//       try {
//           mockMvc.perform(
//                   MockMvcRequestBuilders.get("/detailsPage/1"))
//                   .andExpect(status().isOk())
//                   .andExpect(view().name("detailsPage"));
//
//       }catch(Exception e){
//           e.printStackTrace();
//       }
//
//    }
}