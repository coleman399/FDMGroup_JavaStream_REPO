import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;


public class Notes {
	public static void main(final String[] args) {
		// Scanner in = new Scanner(System.in);
		
		// Binary Whole Number = Sum of powers of 2
		// 101 = 2^2 + 2+1 + 2^1 + 2^0 = 4 + 2 + 1 = 4 + 0 + 1 = 5
		// Decimals
		// Floating Point Decimal = A whole number, a period, and a whole number
		// 4.7 = 100 . 111
		// Binary Decimal = Sum of inverted powers of 2
		// 101 = 1/(2^2) + 1/(2^1) + 1/(2^0) = .5 + .25 + .125 = .5 + 0 + .125 = .625

		// double x = .7;
		// double y = .7;
		// double z = x * y;
		// System.out.println(z);

		// BigDecimal a = new BigDecimal(.7);
		// BigDecimal b = new BigDecimal(".7");
		// BigDecimal c = BigDecimal.valueOf(.7);
		// System.out.println(b.multiply(c));

		// String helloWorld = "Hello World";
		// System.out.println(helloWorld);
		
		// alt + shift + r = will select all instances of highlighted variable so you can alter its name without having to do so for each one independently. 

        ArrayList<String> selected = new ArrayList<String>(Arrays.asList("Dillon", "is", "the", "best!"));

		for (String select : selected) {
			System.out.println(select);
		}

		Iterator<String> iter = selected.iterator();

		while (iter.hasNext()) {
			String word = iter.next();
			System.out.println(word);
			if (word.equals(word)) {
				iter.remove();
			}
		}

		// java is pass by value
		/*
		
		dependency is relationship between to classes
		
		class a uses an instance of class b
		A broken arrow with an open head represents a dependency
		
		class a has a single instance of class b
		A solid arrow with an open head represents a association
		
		class b has many instances of class a
		A solid line with a diamond represents an aggregation

		A solid line with a solid diamond represents a composition


		*/
	}

}
