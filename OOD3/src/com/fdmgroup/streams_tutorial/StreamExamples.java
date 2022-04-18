

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class StreamExamples {
    public static void main(String[] args) {
        Trainee trainee1 = new Trainee("John", "Smith", "Java", 2, 25, 75.0);
        Trainee trainee2 = new Trainee("Jane", "Jones", "BA", 3, 27, 82.0);
        Trainee trainee3 = new Trainee("Tom", "Williams", "BA", 8, 30, 25.0);
        Trainee trainee4 = new Trainee("Jo", "Taylor", "Java", 4, 20, 63.0);
        Trainee trainee5 = new Trainee("Pat", "Brown", "BA", 7, 22, 94.0);
        Trainee trainee6 = new Trainee("Fay", "Davies", "Java", 2, 26, 50.0);
        List<Trainee> trainees = new ArrayList<>(
                Arrays.asList(trainee1, trainee2, trainee3, trainee4, trainee5, trainee6));

        /**
         * What is a stream?
         * 
         * A stream produces a sequence of objects. It has methods which can be used
         * with lambda expressions to process the objects in the sequence one by one. It
         * can be used to do the same job as a loop. Multiple streams can be chained
         * together to reach the end result.
         * 
         * Stream methods come in two types:
         * 
         * • Intermediate operations – returns a stream. These can be found at any place
         * in a chain of streams except for the end.
         * • Terminal operations – returns an object which is not a stream. A terminal
         * operation will always take place at the end of a chain of streams.
         */

        // Filtering streams
        
        /**
         * Step 1
         * 
         * Call the trainee List’s stream method to create a stream containing all of
         * the trainee objects. This is an intermediate operation.
         */
        trainees.stream();

        /**
         * Step 2
         * 
         * Next we can call the ‘filter’ method for our stream of trainee objects. The
         * job of the ‘filter’ method is to return another stream containing fewer
         * objects that the stream that was derived from. Filter uses a Predicate to
         * determine which objects from the previous stream will be added to the next
         * stream. Filter is another intermediate operation.
         */
        trainees.stream().filter(trainee -> trainee.getStream().equals("BA"));

        /**
         * Step 3
         * 
         * After calling the filter, we now have a new stream which only contains
         * trainee objects which are on the BA stream. All that’s left to do is to count
         * those objects. We can do this by calling the stream’s ‘count’ method. This is
         * a terminal operation which returns a long value.
         */
        long numberOfBAtrainees = trainees.stream().filter(trainee -> trainee.getStream().equals("BA")).count();
        System.out.println("number of BA trainees: " + numberOfBAtrainees);

        /**
         * Creating a collection from a stream
         * In this scenario we’re going to create a new list containing only the
         * trainees which are on the BA stream. This can be done using the same two
         * intermediate operations, as the previous example but with a different
         * terminal operation which this time converts the stream of BA trainees into a
         * list of BA trainees:
         */
        List<Trainee> baTrainees = trainees.stream().filter(trainee -> trainee.getStream().equals("BA"))
                .collect(Collectors.toList());
        System.out.println("BA trainees: " + baTrainees);

        /**
         * This time our terminal operation is the ‘collect’ method. This can be used to
         * convert a stream to a collection. In its parentheses we can use the
         * ‘Collectors’ class to choose exactly which type of collection. In this
         * example we’ve used toList(), but we could have used toSet() or toMap().
         * 
         * Mapping streams to find min and max values
         * 
         * In this section we’ll start by finding the age of the oldest trainee. As with
         * all our previous examples of streams, we’ll start by calling the stream
         * method on the trainees List to get a stream of Trainee objects.
         * 
         * Step 1
         * 
         * As we’re only interested in the ages of the trainees, our next step will to
         * be to create a stream of integers containing the ages of the trainees. We can
         * do this by using the ‘map’ method.
         */
        trainees.stream().map(trainee -> trainee.getAge());

        /**
         * Step 2
         * 
         * The map method in the previous step has given us a stream of integers. We can
         * now find the highest number in the stream by using the stream’s ‘max’ method
         * with a Comparator lambda expression as an argument:
         */
        trainees.stream().map(trainee -> trainee.getAge()).max((age1, age2) -> age1.compareTo(age2));

        /**
         * Step 3
         * At this stage you might well think that all we need to do is to capture the
         * max age in an int or a long variable. Unfortunately, if you try this you’ll
         * get a compile error.
         * 
         * When we used the count() method earlier, it returned a long value, so you
         * might be wondering why max() returns an optional. The reason is that if the
         * trainees List was empty the count would be zero, but there wouldn’t be a max
         * age (i.e. the answer is null)
         * 
         * We’ll make use of the Optional ifPresent() method to print out the highest
         * age. If there is no highest age, nothing will be printed:
         */
        trainees.stream().map(trainee -> trainee.getAge()).max((age1, age2) -> age1.compareTo(age2))
                .ifPresent(maxAge -> System.out.println("the oldest trainee is " + maxAge + "years old."));

        /**
         * Mapping streams to IntStreams to find average and sum values
         * 
         * In the previous section we used the max() method to find the age of the
         * oldest trainee. We could also have used the min() method to find the age of
         * the youngest trainee.
         * 
         * Unfortunately, if you want to find the average age of the trainees you’ll
         * have a problem. The stream class doesn’t have an average() method.
         * 
         * Incidentally, it also doesn’t have a sum() method.
         * 
         * If we want to calculate an average or a sum, we’ll need to use a child class
         * of Stream called IntStream.
         * 
         * Unlike Stream, IntStream does have average() and sum() methods.
         * 
         * Step 1
         * 
         * Call the mapToInt() method on the stream of Trainee objects. The lambda
         * expression will be the same as we used with the map() method in the previous
         * section:
         */
        trainees.stream().mapToInt(trainee -> trainee.getAge());

        /**
         * Step 2
         * 
         * We can now call the average() method. Like the max() method, average()
         * returns an Optional. As we’re using an IntStream, the exact type is
         * OptionalDouble. Remember that this is different from Optional<Double>.
         * This time we’ll use the optional isPresent() method to check that a value was
         * returned and then the getAsDouble() method to get the value of the average
         * age:
         */
        OptionalDouble optionalAverageAge = trainees.stream().mapToInt(trainee -> trainee.getAge()).average();
        System.out.println("Optional Average Age: " + optionalAverageAge);

        /**
         * Reducing streams to find the trainee with the highest grade
         * Let’s say we want to find the trainee object which has the highest grade. In
         * this case we would use the stream’s reduce() method with a binary operator.
         * The reduce method will use the binary operator to compare pairs of trainees
         * to find out which one has the highest grade. Each time it will discard the
         * one with the lowest grade. It will keep repeating this process until there’s
         * only a single trainee remaining.
         * 
         * Step 1
         * 
         * Create a BinaryOperator which takes 2 trainees as arguments and returns the
         * trainee with the highest grade:
         */
        BinaryOperator<Trainee> traineeWithHightestGrade = (firstTrainee,
                secondTrainee) -> firstTrainee.getAverageGrade() > secondTrainee.getAverageGrade() ? firstTrainee
                        : secondTrainee;

        /**
         * Step 2
         * 
         * Pass the BinaryOperator into the stream’s reduce() method. This time we’ll
         * use the orElse method to return a dummy trainee object if the trainees list
         * is empty.
         */
        Trainee bestTrainee = trainees.stream().reduce(traineeWithHightestGrade)
                .orElse(new Trainee("dummy", "trainee", "dummy stream", 0, 0, 0.0));
        System.out.println("best trainee: " + bestTrainee);

        /**
         * Using streams with arrays
         * 
         * In an earlier example, we took the List of all trainees and used streams to
         * create a List of just BA trainees.
         * 
         * Let’s see how we could do this if we were working with arrays instead of
         * Lists.
         * 
         * We’ll start by creating an array of Trainee objects containing all of the 6
         * trainees
         */
        Trainee[] traineeArray = { trainee1, trainee2, trainee3, trainee4, trainee5, trainee6 };

        /**
         * Step 1
         * Create a stream containing the objects from the array:
         */
        Arrays.stream(traineeArray);

        /**
         * Step 2
         * Filter the stream using a predicate lambda expression so that it returns a
         * stream of BA trainees only:
         */
        Arrays.stream(traineeArray).filter(trainee -> trainee.getStream().equals("BA"));

        /**
         * Step 3
         * Finally convert the stream of BA trainees into an Array:
         */
        Trainee[] baTraineesArray = Arrays.stream(traineeArray).filter(trainee -> trainee.getStream().equals("BA"))
                .toArray(Trainee[]::new);
        System.out.println("BA traineesArray: " + baTraineesArray);
    }
}
