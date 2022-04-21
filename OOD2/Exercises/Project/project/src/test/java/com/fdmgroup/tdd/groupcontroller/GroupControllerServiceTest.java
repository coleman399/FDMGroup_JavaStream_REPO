package com.fdmgroup.tdd.groupcontroller;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GroupControllerServiceTest {
	private GroupControllerService groupControllerService;
    private DatabaseReader databaseReader;
	private DatabaseWriter databaseWriter;
	private Trainee traineeMock;
	private Runner runner;

	@BeforeEach
	public void setUp() throws Exception {
		this.groupControllerService = mock(GroupControllerService.class);
        this.databaseReader = mock(DatabaseReader.class);
		this.databaseWriter = mock(DatabaseWriter.class);
		this.traineeMock = mock(Trainee.class);
		this.runner = new Runner(groupControllerService, databaseReader, databaseWriter);
		
	}
	
	// Test One
	@Test
	public void getAllTrainees_ReturnMap_CallsReadGroupFromDataBaseReader() {
		Map<String, Trainee> result = new HashMap<String, Trainee>();
		result.put("1234", traineeMock);
		when(databaseReader.readGroup()).thenReturn(result);
		Map<String, Trainee> returnedMap = runner.getAllTrainees(); 
		assertEquals(result, returnedMap);
	}

	// Test Two
	@Test
	public void removeTraineeByUsername_PassTraineeToDeleteTraineeByUsername() {
		runner.removeTraineeByUsername("any string");
		verify(databaseWriter, times(1)).deleteTraineeByUsername("any string");
	}

	//Test Three
	@Test
	public void addTrainee_PassTraineeToDataBaseWriterAddTrainee() {
		runner.addTrainee(traineeMock);
		verify(databaseWriter, times(1)).addTrainee(traineeMock);
	}

}
