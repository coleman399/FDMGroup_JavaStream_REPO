package com.fdmgroup.optional_tutorial;

import java.util.ArrayList;
import java.util.function.Supplier;

public class Runner {
    public static void main(String[] args) {
        Computer computer1 = new Computer("Example Computer");
        Computer computer2 = new Computer("HP");
        ComputerStore computerStore = new ComputerStore();
        // Optional methods

        /**
         * isPresent()
         * Before calling get() we need to make sure that the Optional object doesn’t
         * contain a null value. We can do this by using the isPresent() method:
         * 
         * if (optionalMotherboard.isPresent()){
         * Motherboard motherboard = optionalMotherboard.get();
         * }
         * 
         * This doesn’t seem any better than just doing regular defensive coding without
         * using an optional:
         * 
         * if (motherboard != null) {
         * motherboard.getModel();
         * }
         *
         * So far Optionals are not really selling themselves. We’re about to see where
         * they can really help us. Optionals come into their own when we’re chaining
         * methods.
         */
        computer1.getMotherboard().isPresent();

        /**
         * ifPresent()
         * If present allows us to call a method on an object within an Optional. It
         * will only call the method if there’s an object present. If the Optional
         * contains a null value, the method won’t be called. This guarantees that there
         * won’t be a null pointer exception:
         * 
         * Consumer<Motherboard> printMotherboardModel =
         * motherboard -> System.out.println(motherboard.getModel());
         * 
         * computer.getMotherboard().ifPresent(printMotherboardModel);
         * 
         * Notice that ifPresent() takes a lambda expression of type Consumer.
         * It’s possible to nest multiple ifPresent() statements. The following code
         * will do the same as our first example on page 4, but this time there’s no
         * possibility of a null pointer exception:
         * 
         * computer.getMotherboard()
         * .ifPresent(motherboard -> motherboard.getMemory()
         * .ifPresent(memoryChip -> memoryChip.accessData()));
         * 
         * The accessData() method will only be called if there’s a motherboard object
         * present within the computer and there’s a memory object present in the
         * motherboard. Unless both of these things are true, nothing will happen.
         */
        computer1.getMotherboard()
                .ifPresent(motherboard -> motherboard.getMemory().ifPresent(memoryChip -> memoryChip.accessData()));

        /**
         * orElse()
         * This method allows us to replace a null value within an Optional with a dummy
         * value.
         * Create a new class called ComputerStore with the following code:
         * 
         * public class ComputerStore {
         * 
         * List<Computer> computers;
         * 
         * public Optional<List<Computer>> getComputers() {
         * return Optional.ofNullable(computers);
         * }
         * 
         * public void setComputers(List<Computer> computers) {
         * this.computers = computers;
         * }
         * }
         * 
         * Imagine that we want to find out the number of computers in the store. The
         * problem we have here is that the computers List may not have been set. In
         * this case the number of computers should be zero. But we won’t be able to
         * call the size() method on a null value. Let’s look at how orElse() can solve
         * this:
         * 
         * int numberOfComputers = computerStore.getComputers()
         * .orElse(new ArrayList<Computer>())
         * .size();
         * 
         * If the computerStore object contains a null value for it’s computers
         * attribute, the orElse() method will replace the null value with an empty
         * ArrayList of computers. This will allow us to call the size() method which
         * will then return zero.
         */
        int numberOfComputers = computerStore.getComputers().orElse(new ArrayList<Computer>()).size();
        System.out.println(numberOfComputers);

        /**
         * orElseThrow()
         * This method allows us to replace the usual null pointer exception with a
         * custom exception.
         * Create the following custom exceptions:
         * public class MissingMotherboardException extends Exception{
         * 
         * public MissingMotherboardException(String message) {
         * super(message);
         * }
         * }
         * public class MissingMemoryException extends Exception{
         * 
         * public MissingMemoryException(String message) {
         * super(message);
         * }
         * }
         * 
         * Let’s now try to chain three methods together:
         * Computer computer = new Computer("HP");
         * 
         * Supplier<MissingMotherboardException> missingMotherboard =
         * () -> new MissingMotherboardException("missing motherboard");
         * 
         * Supplier<MissingMemoryException> missingMemory =
         * () -> new MissingMemoryException("missing memory");
         * 
         * try {
         * computer.getMotherboard()
         * .orElseThrow(missingMotherboard)
         * .getMemory()
         * .orElseThrow(missingMemory)
         * .accessData();
         * } catch (MissingMotherboardException e) {
         * // code to deal with missing motherboard
         * System.out.println("missing motherboard");
         * } catch (MissingMemoryException e) {
         * // code to deal with missing memory
         * System.out.println("missing memory");
         * }
         * 
         * If you run the code above you should get the “missing motherboard” message.
         * Try calling the computer’s setMotherboard() method passing in a Motherboard
         * object. If you now rerun the code, you’ll get the “missing memory” message.
         * This is a massive improvement on throwing a null pointer exception. This time
         * our code is able to handle a missing motherboard one way and a missing memory
         * another way.
         * 
         * If the motherboard and memory are both present then the method chain will
         * successfully call the accessData() method.
         */

        Supplier<MissingMotherboardException> missingMotherboard = () -> new MissingMotherboardException(
                "missing motherboard");

        Supplier<MissingMemoryException> missingMemory = () -> new MissingMemoryException("missing memory");

        // Motherboard motherboard = new Motherboard("motherboard");
        // computer2.setMotherboard(motherboard);

        try {
            computer2.getMotherboard().orElseThrow(missingMotherboard).getMemory().orElseThrow(missingMemory)
                    .accessData();
        } catch (MissingMotherboardException e) {
            // code to deal with missing motherboard
            System.out.println("missing motherboard");
        } catch (MissingMemoryException e) {
            // code to deal with missing memory
            System.out.println("missing memory");
        }
    }

    public static class MissingMotherboardException extends Exception {

        public MissingMotherboardException(String message) {
            super(message);
        }
    }

    public static class MissingMemoryException extends Exception {

        public MissingMemoryException(String message) {
            super(message);
        }
    }

}
