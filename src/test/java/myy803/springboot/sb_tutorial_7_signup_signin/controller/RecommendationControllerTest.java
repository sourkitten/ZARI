// RecommendationControllerTest.java
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class RecommendationControllerTest {

    @Mock
    private BookOfferService bookOfferService;

    @Mock
    private UserService userService;

    @InjectMocks
    private RecommendationController recommendationController;

    private MockMvc mockMvc;
    private BookOffer testBookOffer;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(recommendationController).build();

        testBookOffer = new BookOffer();
        testBookOffer.setId(1);
        testBookOffer.setTitle("Test Book");
        testBookOffer.setAuthors("John Doe");
        testBookOffer.setCategory("Fiction");
    }

    @Test
    public void testShowRecommendationStrategies() throws Exception {
        mockMvc.perform(get("/user/recommendations"))
                .andExpect(status().isOk())
                .andExpect(view().name("user/recommendations"));
    }

    @Test
    public void testGetRecommendationsByCategory() throws Exception {
        when(userService.getCurrentUser()).thenReturn(new User());
        when(bookOfferService.recommendByCategory(anyInt())).thenReturn(Arrays.asList(testBookOffer));

        mockMvc.perform(post("/user/recommendations")
                        .param("strategy", "category"))
                .andExpect(status().isOk())
                .andExpect(view().name("user/recommendation_results"))
                .andExpect(model().attributeExists("recommendations"));
    }

    @Test
    public void testGetRecommendationsByAuthor() throws Exception {
        when(userService.getCurrentUser()).thenReturn(new User());
        when(bookOfferService.recommendByAuthor(anyInt())).thenReturn(Arrays.asList(testBookOffer));

        mockMvc.perform(post("/user/recommendations")
                        .param("strategy", "author"))
                .andExpect(status().isOk())
                .andExpect(view().name("user/recommendation_results"))
                .andExpect(model().attributeExists("recommendations"));
    }

    @Test
    public void testGetRecommendationsDefault() throws Exception {
        when(userService.getCurrentUser()).thenReturn(new User());
        when(bookOfferService.findAllExcludingUser(anyInt())).thenReturn(Arrays.asList(testBookOffer));

        mockMvc.perform(post("/user/recommendations")
                        .param("strategy", "default"))
                .andExpect(status().isOk())
                .andExpect(view().name("user/recommendation_results"))
                .andExpect(model().attributeExists("recommendations"));
    }
}
