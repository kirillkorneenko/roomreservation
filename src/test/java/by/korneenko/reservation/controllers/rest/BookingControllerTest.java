package by.korneenko.reservation.controllers.rest;

import by.korneenko.reservation.beans.BookingEntity;
import by.korneenko.reservation.configuration.SpringConfigurationWeb;
import by.korneenko.reservation.services.BookingService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfigurationWeb.class})
@WebAppConfiguration
public class BookingControllerTest {

    private MockMvc mockMvc;

    @Mock
    private BookingService bookingService;

    @InjectMocks
    private BookingController bookingController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(bookingController)
                .build();
    }

//    @Test
//    public void addBookingTest() throws Exception {
//        BookingEntity booking = new BookingEntity();
//        booking.setId(3L);
//        booking.setIdEmployee(2L);
//        booking.setIdRoom(2L);
//
//        Calendar cal = Calendar.getInstance();
//        cal.set(2018, 03, 06);
//        booking.setDate( new Date(cal.getTimeInMillis()));
//
////        Time timeStart = new Time(43200000);
////        Time timeEnd= new Time(46800000);
//
//        Time timeStart = new Time(57600000);
//        Time timeEnd= new Time(61200000);
//
//        booking.setTimeStart(timeStart);
//        booking.setTimeEnd(timeEnd);
//
//        mockMvc.perform(post("/api/booking/add")
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//                .content(TestUtil.convertObjectToJsonBytes(booking)))
//                .andExpect(status().isOk()).andDo(print());
//
//        verify(bookingService, times(1)).getBookingByUser(2L);
//        verifyNoMoreInteractions(bookingService);
//    }
//
//    @Test
//    public void getBookingByEmployee() throws Exception {
//        mockMvc.perform(get("/api/booking/bookingByEmployee/2")
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andExpect(status().isOk()).andDo(print());
//
//        verify(bookingService, times(1)).getBookingByUser(2L);
//        verifyNoMoreInteractions(bookingService);
//    }
}