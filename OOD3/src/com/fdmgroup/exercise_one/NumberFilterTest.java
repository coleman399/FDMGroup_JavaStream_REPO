package com.fdmgroup.exercise_one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NumberFilterTest {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(4, 27, 7, 21, -5, 10, 32, 1056, -23);

		// i. Retrieve a list of even numbers
		filterNumbers(numbers, (number) -> number % 2 == 0);

		// ii. Retrieve a list of odd numbers
		filterNumbers(numbers, (number) -> number % 2 != 0);

		// iii. Retrieve a list of positive numbers
		filterNumbers(numbers, (number) -> number > 0);

		// iv. Retrieve a list of negative numbers
		filterNumbers(numbers, (number) -> number < 0);

		// v. Retrieve a list of prime numbers
		filterNumbers(numbers, (number) -> isPrime(number));
	}

	private static boolean isPrime(int number) {
		if (number == 1 || number < 0)
			return false;
		for (int i = 2; i < Math.sqrt(number); i++)
			if (number % i == 0)
				return false;
		return true;
	}

	public static void filterNumbers(List<Integer> numbers, NumberFilter filter) {
		List<Integer> filteredNumbers = new ArrayList<>();
		for (Integer number : numbers) {
			if (filter.filterNumber(number)) {
				filteredNumbers.add(number);
			}
		}
		Comparator<Integer> sortedFilteredNumbers = (number1, number2) -> number1.compareTo(number2);
		filteredNumbers.sort(sortedFilteredNumbers);
		System.out.println(filteredNumbers);
	}
}
