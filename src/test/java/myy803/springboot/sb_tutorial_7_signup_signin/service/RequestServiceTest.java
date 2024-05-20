// RequestServiceTest.java
package myy803.springboot.sb_tutorial_7_signup_signin.service;

import myy803.springboot.sb_tutorial_7_signup_signin.dao.RequestDAO;
import myy803.springboot.sb_tutorial_7_signup_signin.model.Request;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class RequestServiceTest {

    @Mock
    private RequestDAO requestDAO;

    @InjectMocks
    private RequestServiceImpl requestService;

    private Request testRequest;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        testRequest = new Request();
        testRequest.setId(1);
        testRequest.setMessage("Test message");
    }

    @Test
    public void testSaveRequest() {
        requestService.saveRequest(testRequest);

        verify(requestDAO, times(1)).save(testRequest);
    }

    @Test
    public void testFindById() {
        when(requestDAO.findById(anyInt())).thenReturn(Optional.of(testRequest));

        Request foundRequest = requestService.findRequestById(1);

        assertEquals(testRequest, foundRequest);
    }

    @Test
    public void testFindByIdNotFound() {
        when(requestDAO.findById(anyInt())).thenReturn(Optional.empty());

        Request foundRequest = requestService.findRequestById(1);

        assertNull(foundRequest);
    }

}
