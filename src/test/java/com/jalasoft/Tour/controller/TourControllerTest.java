package com.jalasoft.Tour.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @author Giordano Bortolini
 */
@SpringBootTest
@AutoConfigureMockMvc
public class TourControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void givenTours_whenRequest_getMethod_thenOk() throws Exception {

    this.mockMvc.perform(MockMvcRequestBuilders.get("/tour/ticket")).andDo(MockMvcResultHandlers.print()).andExpect(
        MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string("You will meet a love the flag day."));

  }
}
