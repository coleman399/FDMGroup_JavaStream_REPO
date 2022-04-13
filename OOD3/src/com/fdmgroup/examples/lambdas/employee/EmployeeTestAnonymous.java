package com.fdmgroup.examples.lambdas.employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeTestAnonymous {

	private static final List<Employee> employees = new ArrayList<>();

	public static void main(String args[]) {
		initialize();

		// 1. Get a list of all employees in NYC.

		Unit unit = Unit.NYC;

		// List<Employee> nycEmployees = getEmployeesFilteredBy(new EmployeeFilter() {
		// @Override
		// public boolean filterEmployee(Employee employee) {
		// return employee.getUnit() == unit;
		// }
		// });

		// 1. parameter
		// 2. return type
		// 3. behavior / body of the lambdas

		EmployeeFilter nycFilter = (Employee employees) -> {
			return employees.getUnit() == unit;
		};
		List<Employee> nycEmployees = getEmployeesFilteredBy(nycFilter);
		System.out.println("--------NYC Employees--------");
		System.out.println(nycEmployees);

		// 2.Get all the java developers.

		// List<Employee> javaDevelopers = getEmployeesFilteredBy(new EmployeeFilter() {
		// @Override
		// public boolean filterEmployee(Employee employee) {
		// return employee.getSkills().contains(Skill.JAVA);
		// }
		// });

		EmployeeFilter javaFilter = (Employee employees) -> {
			return employees.getSkills().contains(Skill.JAVA);
		};
		List<Employee> javaEmployees = getEmployeesFilteredBy(javaFilter);
		System.out.println("--------Java Developers--------");
		System.out.println(javaEmployees);

		// 3. Get employees > 10 years experience

		// List<Employee> seniorProfessionals = getEmployeesFilteredBy(new
		// EmployeeFilter() {
		// @Override
		// public boolean filterEmployee(Employee employee) {
		// return employee.getExperience() > 10;
		// }
		// });

		EmployeeFilter experienceFilter = (Employee employees) -> {
			return employees.getExperience() > 10;
		};
		List<Employee> seniorEmployees = getEmployeesFilteredBy(experienceFilter);
		System.out.println("--------Senior Professionals--------");
		System.out.println(seniorEmployees);

	}

	public static List<Employee> getEmployeesFilteredBy(EmployeeFilter filter) {
		List<Employee> filteredEmployees = new ArrayList<>();
		for (Employee employee : employees) {
			if (filter.filterEmployee(employee)) {
				filteredEmployees.add(employee);
			}
		}
		return filteredEmployees;
	}

	private static void initialize() {

		// Josh is a trainer with skills: Java and Scrum
		List<Skill> dev1Skills = new ArrayList<>();
		dev1Skills.add(Skill.JAVA);
		dev1Skills.add(Skill.SCRUM);
		employees.add(new Employee("Josh", 8, Designation.TRAINER, Unit.CHARLOTTE, dev1Skills));

		// Linette is a trainer with skills: Java and Microservices
		List<Skill> dev2Skills = new ArrayList<>();
		dev2Skills.add(Skill.JAVA);
		dev2Skills.add(Skill.MICROSERVICES);
		employees.add(new Employee("Linette", 5, Designation.TRAINER, Unit.CANADA, dev2Skills));

		// DA is a trainer with skills: Excel and Python
		List<Skill> dev3Skills = new ArrayList<>();
		dev3Skills.add(Skill.PYTHON);
		dev3Skills.add(Skill.EXCEL);
		employees.add(new Employee("DA", 7, Designation.SALES, Unit.NYC, dev3Skills));

		// Kadri is a trainer with skills: Excel and Finance
		List<Skill> dev4Skills = new ArrayList<>();
		dev4Skills.add(Skill.EXCEL);
		dev4Skills.add(Skill.FINANCE);
		employees.add(new Employee("Kadri", 3, Designation.TRAINER, Unit.AUS, dev4Skills));

		// Paula is a trainer with skills: Unix and SQL
		List<Skill> dev5Skills = new ArrayList<>();
		dev5Skills.add(Skill.UNIX);
		dev5Skills.add(Skill.SQL);
		employees.add(new Employee("Paula", 22, Designation.TRAINER, Unit.NYC, dev5Skills));

		// Daniel is a trainer with skills: Java and SQL
		List<Skill> lead1Skills = new ArrayList<>();
		lead1Skills.add(Skill.JAVA);
		lead1Skills.add(Skill.SQL);
		employees.add(new Employee("Daniel", 11, Designation.TRAINER, Unit.CHARLOTTE, lead1Skills));

		// V is a manager in NYC ... Admin
		List<Skill> mgr1Skills = new ArrayList<>();
		mgr1Skills.add(Skill.ADMIN);
		employees.add(new Employee("V", 9, Designation.MANAGER, Unit.NYC, mgr1Skills));

		// John is a manager in Toronto ... Admin
		List<Skill> mgr2Skills = new ArrayList<>();
		mgr2Skills.add(Skill.ADMIN);
		employees.add(new Employee("John", 12, Designation.MANAGER, Unit.CANADA, mgr2Skills));

		// Lizette is an admin in NYC ... Admin
		List<Skill> admin1Skills = new ArrayList<>();
		admin1Skills.add(Skill.ADMIN);
		employees.add(new Employee("Lizette", 8, Designation.ADMIN, Unit.NYC, admin1Skills));

		// Nina is an admin in NYC ... Admin
		List<Skill> admin2Skills = new ArrayList<>();
		admin2Skills.add(Skill.ADMIN);
		employees.add(new Employee("Nina", 5, Designation.ADMIN, Unit.NYC, admin2Skills));

	}
}
