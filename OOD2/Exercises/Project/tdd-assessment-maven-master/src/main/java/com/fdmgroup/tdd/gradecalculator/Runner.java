package com.fdmgroup.tdd.gradecalculator;

public class Runner {
    GradeCalculatorService gradeCalculatorService;

    public Runner(GradeCalculatorService gradeCalculatorService){
        this.gradeCalculatorService = gradeCalculatorService;
    }

    public String getGrade(double grade) {
        return gradeCalculatorService.getClassification(grade);
    }

}
