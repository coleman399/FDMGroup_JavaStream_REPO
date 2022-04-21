package com.fdmgroup.tdd.gradecalculator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class GradeCalculatorServiceTest {
	private GradeCalculatorService gradeCalculatorService;
	private Runner runner;

	@BeforeEach
	void setUp() throws Exception {
		gradeCalculatorService = mock(GradeCalculatorService.class);
		runner = new Runner(gradeCalculatorService);
	}

	// Test One
	@Test
	void  getGrade_ReturnStringUsingGradeCalculatorService_FailWhenLessThan75() {
		when(gradeCalculatorService.getClassification(74.00)).thenReturn("Fail");
		String returnedString = runner.getGrade(74.00);
		String result = "Fail";
		assertEquals(result, returnedString);
	}

	// Test Two
	@Test
	void  getGrade_ReturnStringUsingGradeCalculatorService_PassWhenGreaterThanOrEqualTo75ButLessThan80() {
		when(gradeCalculatorService.getClassification(76.00)).thenReturn("Pass");
		String returnedString = runner.getGrade(76.00);
		String result = "Pass";
		assertEquals(result, returnedString);
	}


	// Test Three
	@Test
	void  getGrade_ReturnStringUsingGradeCalculatorService_PassWhenGreaterThanOrEqualTo80ButLessThan90() {
		when(gradeCalculatorService.getClassification(85.00)).thenReturn("Merit");
		String returnedString = runner.getGrade(85.00);
		String result = "Merit";
		assertEquals(result, returnedString);
	}

	// Test Four
	@Test
	void  getGrade_ReturnStringUsingGradeCalculatorService_PassWhenGreaterThanOrEqualTo90ButLessThanOrEqualTo100() {
		when(gradeCalculatorService.getClassification(95.00)).thenReturn("Distinction");
		String returnedString = runner.getGrade(95.00);
		String result = "Distinction";
		assertEquals(result, returnedString);
	}
}
