// BookOfferControllerTest.java
package myy803.springboot.sb_tutorial_7_signup_signin.controller;

import myy803.springboot.sb_tutorial_7_signup_signin.model.BookOffer;
import myy803.springboot.sb_tutorial_7_signup_signin.model.User;
import myy803.springboot.sb_tutorial_7_signup_signin.service.BookOfferService;
import myy803.springboot.sb_tutorial_7_signup_signin.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class BookOfferControllerTest {

    @Mock
    private BookOfferService bookOfferService;

    @Mock
    private UserService userService;

    @InjectMocks
    private BookOfferController bookOfferController;

    private MockMvc mockMvc;
    private BookOffer testBookOffer;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(bookOfferController).build();

        testBookOffer = new BookOffer();
        testBookOffer.setId(1);
        testBookOffer.setTitle("Test Book");
        testBookOffer.setAuthors("John Doe");
        testBookOffer.setCategory("Fiction");
    }

    @Test
    public void testShowBookOfferForm() throws Exception {
        mockMvc.perform(get("/user/bookoffer"))
                .andExpect(status().isOk())
                .andExpect(view().name("user/bookoffer"))
                .andExpect(model().attributeExists("bookOffer"));
    }

    @Test
    public void testShowUserBookOffers() throws Exception {
        when(userService.getCurrentUser()).thenReturn(new User());
        when(bookOfferService.getBookOffersByUser(anyInt())).thenReturn(Arrays.asList(testBookOffer));

        mockMvc.perform(get("/user/bookoffers"))
                .andExpect(status().isOk())
                .andExpect(view().name("user/bookoffers"))
                .andExpect(model().attributeExists("bookOffers"));
    }

    @Test
    public void testViewAllBookOffers() throws Exception {
        when(bookOfferService.findAllBookOffers()).thenReturn(Arrays.asList(testBookOffer));

        mockMvc.perform(get("/user/allbookoffers"))
                .andExpect(status().isOk())
                .andExpect(view().name("user/allbookoffers"))
                .andExpect(model().attributeExists("bookOffers"));
    }
}
