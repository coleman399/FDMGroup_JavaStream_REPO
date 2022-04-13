package com.fdmgroup.streams_tutorial;

public class Trainee {
    private String firstName;
    private String lastName;
    private String stream;
    private Integer week;
    private Integer age;
    private Double averageGrade;
    
    public Trainee(String firstName, String lastName, String stream, Integer week, Integer age, Double averageGrade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.stream = stream;
        this.week = week;
        this.age = age;
        this.averageGrade = averageGrade;
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

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(Double averageGrade) {
        this.averageGrade = averageGrade;
    }

    @Override
    public String toString() {
        return "Trainee [age=" + age + ", averageGrade=" + averageGrade + ", firstName=" + firstName + ", lastName="
                + lastName + ", stream=" + stream + ", week=" + week + "]";
    }
}
