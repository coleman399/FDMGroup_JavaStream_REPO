package com.fdmgroup;

public class Trainee {
    private int traineeId;
    private String firstName;
    private String lastName;
    private AcademyStream stream;

    public Trainee() {
        super();
    }
    
    public Trainee(int traineeId, String firstName, String lastName, AcademyStream stream) {
        this.traineeId = traineeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.stream = stream;
    }

    public int getTraineeId() {
        return traineeId;
    }

    public void setTraineeId(int traineeId) {
        this.traineeId = traineeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public AcademyStream getStream() {
        return stream;
    }

    public void setStream(AcademyStream stream) {
        this.stream = stream;
    }

    @Override
    public String toString() {
        return "Trainee [firstName=" + firstName + ", lastName=" + lastName + ", stream=" + stream + ", traineeId="
                + traineeId + "]";
    } 
    
}
