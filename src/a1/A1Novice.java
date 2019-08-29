package a1;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		int count = scan.nextInt();
		
		/* parallel arrays are created in order to store the names and prices
		 * these arrays will be used to output the final console message */
		String[] fNames = new String[count];
		String[] lNames = new String[count];
		double[] prices = new double[count];
		
		/*for loop iterates through every person and their items
		  */
		for (int i = 0; i<count;i++) {
			//names are saved
			fNames[i]= scan.next();
			lNames[i] = scan.next();
			
			/*subCount represents how many items each person bought
			* subCount is used to loop through the items that each person bought
			* totalPrice represents how much money is spent by each person, which is
			  calculated in the following for loop*/
			int subCount = scan.nextInt();
			double totalPrice = 0; 
			for (int a = 0; a<subCount;a++) {
				int howMany = scan.nextInt();
				//the name of the item bought was not used, so it's skipped over by scan.next()
				scan.next();
				double itemPrice = scan.nextDouble();
				totalPrice += itemPrice*howMany;
				}
			//the price that a given person spent is stored in the array
			prices[i] = totalPrice;
			}
		
		/* console output
		 * uses all 3 parallel arrays to display the abbreviated first name, the last name, and the price
		 */
		for (int b = 0; b<fNames.length; b++) {
			System.out.println(abbreviate(fNames[b]) + lNames[b] + ": " + String.format("%.2f",prices[b]));
		}
	}
	
	/* function used to abbreviate first name
	 * takes in a string
	 * returns first character, followed by a period
	*/
	static String abbreviate(String s) {
		return s.charAt(0) + ". ";
	}
}
