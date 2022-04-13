package main.java.com.fdmgroup.lambda_expression_tutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Examples {
    public static void main(String[] args) {
        Trainee trainee1 = new Trainee("John", "Smith", "Java", 2, 25, 75.0);
        Trainee trainee2 = new Trainee("Jane", "Jones", "BA", 3, 27, 82.0);
        Trainee trainee3 = new Trainee("Tom", "Williams", "BA", 8, 30, 25.0);
        Trainee trainee4 = new Trainee("Jo", "Taylor", "Java", 4, 20, 63.0);
        Trainee trainee5 = new Trainee("Pat", "Brown", "BA", 7, 22, 94.0);
        Trainee trainee6 = new Trainee("Fay", "Davies", "Java", 2, 26, 50.0);

        Function<Trainee, String> getTraineeFullName = trainee -> trainee.getFirstName() + " " + trainee.getLastName();
        String trainee1_fullName = getTraineeFullName.apply(trainee1);
        System.out.println(trainee1_fullName);

        BiFunction<Trainee, String, String> getTraineeNameWithTitle = (trainee, title) -> title + " "
                + trainee.getFirstName() + " " + trainee.getLastName();
        String trainee2_nameWithTitle = getTraineeNameWithTitle.apply(trainee2, "Ms");
        System.out.println(trainee2_nameWithTitle);

        Predicate<Trainee> veryWeakTrainee = trainee -> trainee.getAverageGrade() < 50;
        Boolean trainee3_veryWeakTrainee = veryWeakTrainee.test(trainee3);
        Boolean trainee4_veryWeakTrainee = veryWeakTrainee.test(trainee4);
        System.out.println("is trainee3 weak? " + trainee3_veryWeakTrainee);
        System.out.println("is trainee4 weak? " + trainee4_veryWeakTrainee);

        BinaryOperator<Trainee> getOldestTrainee = (firstTrainee,
                secondTrainee) -> firstTrainee.getAge() > secondTrainee.getAge() ? firstTrainee : secondTrainee;
        Trainee oldestTrainee = getOldestTrainee.apply(trainee1, trainee2);
        System.out.println("Oldest Trainee: " + oldestTrainee.toString());

        Consumer<Trainee> printFullName = trainee -> System.out
                .println(trainee.getFirstName() + " " + trainee.getLastName());

        printFullName.accept(trainee5);

        List<Trainee> trainees = new ArrayList<>(
                Arrays.asList(trainee1, trainee2, trainee3, trainee4, trainee5, trainee6));

        // forEach Takes a Consumer
        trainees.forEach(printFullName);

        // removeIf Takes a Predicate
        trainees.removeIf(veryWeakTrainee);

        Comparator<Trainee> traineeStreamComparator = (firstTrainee, secondTrainee) -> firstTrainee.getStream()
                .compareTo(secondTrainee.getStream());
        Collections.sort(trainees, traineeStreamComparator);
        System.out.println("Sort by Stream: ");
        trainees.forEach(trainee -> System.out.println(trainee));

        Comparator<Trainee> traineeGradeComparator = (firstTrainee, secondTrainee) -> firstTrainee.getAverageGrade()
                .compareTo(secondTrainee.getAverageGrade());
        Collections.sort(trainees, traineeGradeComparator);
        System.out.println("Sort by Grade: ");
        trainees.forEach(trainee -> System.out.println(trainee));

        Comparator<Trainee> traineeStreamThenGradeComparator = traineeStreamComparator
                .thenComparing(traineeGradeComparator);
        Collections.sort(trainees, traineeStreamThenGradeComparator);
        System.out.println("Sort by Stream then Grade: ");
        trainees.forEach(trainee -> System.out.println(trainee));

        Map<String, Integer> traineesPerStream = new HashMap<>();
        for (Trainee trainee : trainees) {
            String stream = trainee.getStream();
            traineesPerStream.merge(stream, 1, (currentCount, one) -> currentCount + one);
        }

        /**
         * Let’s break down what’s happening in the merge() method. There are 3
         * arguments:
         * • Argument 1 (stream) – this is the key object which will either be added to
         * the map or have its value within the map changed.
         * • Argument 2 (1) – this is the amount which will be added to argument 1’s
         * value in the map.
         * • Argument 3 ((currentCount,one) -> currentCount + one) – A BiFunction which
         * will change the value in the map associated with argument 1. The BiFunction’s
         * two arguments are based on the merge() method’s previous two arguments.
         * o currentCount – the value in the map currently associated with argument 1.
         * o one – the amount to be added to the value in the map (argument 2)
         * 
         * The BiFunction’s return value is the new value in the map for the key in
         * argument 1.
         * 
         */
    }

}
