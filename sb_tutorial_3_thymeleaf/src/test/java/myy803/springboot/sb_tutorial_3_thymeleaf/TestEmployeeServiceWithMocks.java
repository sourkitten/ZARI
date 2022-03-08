package myy803.springboot.sb_tutorial_3_thymeleaf;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import myy803.springboot.sb_tutorial_3_thymeleaf.entity.Employee;
import myy803.springboot.sb_tutorial_3_thymeleaf.service.EmployeeService;
import myy803.springboot.sb_tutorial_3_thymeleaf.service.EmployeeServiceImpl;
import myy803.springboot.sb_tutorial_3_thymeleaf.dao.*;


//@SpringBootTest
//@TestPropertySource(
//  locations = "classpath:application.properties")
//@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
class TestEmployeeServiceWithMocks {

	@TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
 
        @Bean
        public EmployeeService employeeService() {
            return new EmployeeServiceImpl();
        }
    }

	@Autowired 
	EmployeeService employeeService;
	
	@MockBean
	//@Qualifier(value = "employeeDAOJpaImpl")
	EmployeeDAO employeeDAO;
	
	@Test
	void testEmployeeDAOJpaImplIsNotNull() {
		Assertions.assertNotNull(employeeService);
	}

	@Test
	void testFindByIdReturnsEmployee() {
		Mockito.when(employeeDAO.findById(1)).thenReturn(new Employee(1, "", "Andrews", ""));
		Employee storedEmployee = employeeService.findById(1);
		Assertions.assertNotNull(storedEmployee);
		Assertions.assertEquals("Andrews", storedEmployee.getLastName());
	}
}
