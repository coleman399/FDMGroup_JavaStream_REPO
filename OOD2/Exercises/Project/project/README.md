Object Oriented Development
Week 2 Assessment – TDD Code

Assessment

Trainees have 1 hour to use TDD to write appropriate tests and the implementing code to meet the below requirements. **The implementing classes must implement the appropriate service interface provided.**

Trainees are provided with two interface files: 

* GradeCalculatorService
    * This service requires an implementing class that fulfils the interface contract. To be successful, the implementing class must return the appropriate String value when a double representing a mark is passed in. They are as follows:
        * “fail” when less than 75.
        * “pass” when greater than or equal to 75 but less than 80.
        * “merit” when greater than or equal to 80 but less than 90.
        * “distinction” when greater than or equal to 90 but less than or equal to 100.
* GroupControllerService
    * This service requires an implementing class that fulfils the interface contract. To be successful, the implementing class must return objects of the appropriate type and meet the requirements specified below (you may require some mock objects):
        * When asking the service implementation for all trainees, the trainees should be read from a DatabaseReader object (you do not need to fully implement the database reader’s methods).
        * When removing a trainee by their username, a DatabaseWriter object should be called (you do not need to fully implement the database reader’s methods) from the service implementation.
        * When adding a trainee through the service implementation, the trainee should be passed to a DatabaseWriter object(you do not need to fully implement the database reader)


Marking Scheme:
* Fail
    * Unable to meet either of the Service requirements
* Pass
    * A GradeCalculatorService implementation returns the correct values and there are passing JUnit tests that prove this.
* Merit
    * A GroupControllerService implementation has the correct behaviour and there are passing JUnit tests that prove this.
* Distinction
    * GroupControllerService and GradeCalculatorService both have implementations that have the correct behaviour with passing tests that prove this using both Mockito and JUnit tests where appropriate. 

   

