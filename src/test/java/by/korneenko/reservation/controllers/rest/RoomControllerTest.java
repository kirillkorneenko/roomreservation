package by.korneenko.reservation.controllers.rest;


import by.korneenko.reservation.beans.RoomEntity;
import by.korneenko.reservation.configuration.SpringConfigurationWeb;
import by.korneenko.reservation.services.RoomService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfigurationWeb.class})
@WebAppConfiguration
public class RoomControllerTest {

    private MockMvc mockMvc;

    @Mock
    private RoomService roomService;

    @InjectMocks
    private RoomController roomController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(roomController)
                .build();
    }

    @Test
    public void getById() throws Exception {
        RoomEntity room = new RoomEntity();
        room.setId( 1L);
        room.setNumber("1");
        when(roomService.getByKey( 1L)).thenReturn(room);

        mockMvc.perform(
                get("/api/room/1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(new ObjectMapper().writeValueAsString(room)))
                .andExpect(status().isOk()).andDo(print());

        verify(roomService, times(1)).getByKey(1L);
        verifyNoMoreInteractions(roomService);
    }


}