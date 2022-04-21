package com.fdmgroup.tdd.groupcontroller;

import java.util.Map;

public interface GroupControllerService {
	public Map<String, Trainee> getAllTrainees();
	public void addTrainee(Trainee trainee);
	public void removeTraineeByUsername(String traineeUsername);
	
}
