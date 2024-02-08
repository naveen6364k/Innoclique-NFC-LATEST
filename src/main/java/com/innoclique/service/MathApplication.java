package com.innoclique.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Naveen Kumar Chintala
 */

@Service
public class MathApplication {

	@Autowired
	private Calculator myService;
	
	 public MathApplication(Calculator calculator) {
	        this.myService = calculator;
	    }
	 
	 public int addNumbers(int a, int b) {
	        return myService.addNumbers(a, b);
	    }
}
