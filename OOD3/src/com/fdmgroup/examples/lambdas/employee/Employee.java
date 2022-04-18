

import java.util.List;

public class Employee {

    private String name;
    private Unit unit;
    private int experience;
    private Designation designation;
    private List<Skill> skills;

    public Employee(String name, int experience, Designation designation, Unit unit, List<Skill> skills) {
        this.name = name;
        this.unit = unit;
        this.experience = experience;
        this.designation = designation;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Designation getDesignation() {
        return designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return this.getName() + " with " + this.getExperience() + " years of experience \n";
    }

    public static boolean hasJavaSkills(Employee employee) {
        System.out.println("Checking if employee has java skills: " + employee.getName());
        return employee.getSkills().contains(Skill.JAVA);
    }

}
