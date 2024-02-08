package com.example.demo;

/**
 * @author Naveen Kumar Chintala
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.innoclique.service.Calculator;
import com.innoclique.service.MathApplication;

@ExtendWith(MockitoExtension.class)
public class MathApplicationTest {

	@Mock
	private Calculator calculatorMock;
	
@Test
 public void testAddNumbers() {

    //Invoking MOCK 
     when(calculatorMock.addNumbers(2, 3)).thenReturn(5);

     // Create MathApplication with the mocked Calculator
     MathApplication mathApplication = new MathApplication(calculatorMock);

     // Test the MathApplication using the mocked Calculator
     int result = mathApplication.addNumbers(2, 3);

     // Verify the result
     assertEquals(5, result, "Expected result is 5");

     // Verify that the add method of the Calculator was called with the specified arguments
     Mockito.verify(calculatorMock).addNumbers(2, 3);
 }
}
