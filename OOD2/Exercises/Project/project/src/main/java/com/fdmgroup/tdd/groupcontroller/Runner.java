package com.fdmgroup.tdd.groupcontroller;

import java.util.Map;

public class Runner {
    private DatabaseReader databaseReader;
    private DatabaseWriter databaseWriter;

    public Runner(GroupControllerService GroupControllerService, DatabaseReader databaseReader, DatabaseWriter databaseWriter) {
        this.databaseReader = databaseReader;
        this.databaseWriter = databaseWriter;
    }

    public Map<String, Trainee> getAllTrainees() {
        return databaseReader.readGroup();
    }

    public void removeTraineeByUsername(String username) {
        databaseWriter.deleteTraineeByUsername(username);
    }

	public void addTrainee(Trainee traineeMock) {
        databaseWriter.addTrainee(traineeMock);
	}
}
