package com.innoclique;

import static org.junit.jupiter.api.Assertions.assertEquals;

//MyServiceTest.java

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.innoclique.service.Calculator;

/**
 * @author Naveen Kumar Chintala
 */

@SpringBootTest
public class CalculatorTest {

 @Autowired
 private Calculator myService;

 @Test
 public void testAddNumbers() {
     // Given
     int num1 = 2;
     int num2 = 3;

     // When
     int result = myService.addNumbers(num1, num2);

     // Then
     assertEquals(5, result, "Adding 2 and 3 should be 5");
 }
}
