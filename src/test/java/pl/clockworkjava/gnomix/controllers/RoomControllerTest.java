package pl.clockworkjava.gnomix.controllers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import pl.clockworkjava.gnomix.domain.room.Room;
import pl.clockworkjava.gnomix.domain.room.RoomService;

import java.util.Arrays;

@WebMvcTest(RoomController.class)
public class RoomControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RoomService roomService;

    @Test
    public void basic() throws Exception {

        Room r = new Room("1408");

        Mockito.when(roomService.findAll()).thenReturn(Arrays.asList(r));

        mockMvc.perform(get("/rooms"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("rooms"))
                .andExpect(view().name("rooms"))
                .andExpect(content().string(containsString("1408")));
    }
}
