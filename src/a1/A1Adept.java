package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		int itemCount = scan.nextInt();
		
		//parallel arrays defined to store the prices and names of items
		double[] itemPrices = new double[itemCount];
		String[] itemNames = new String[itemCount];
		
		//item names and prices are stored in the arrays
		for (int i = 0; i< itemCount; i++) {
			itemNames[i] = scan.next();
			itemPrices[i]= scan.nextDouble();
		}
		
		//parallel arrays are made to store the information of the shoppers
		int shopperCount = scan.nextInt();
		String[] fNames = new String[shopperCount];
		String[] lNames = new String[shopperCount];
		double[] amountsSpent = new double[shopperCount];
		
		//loop iterates through each person and the items that he/she bought
		for (int a = 0; a<shopperCount; a++) {
			fNames[a] = scan.next();
			lNames[a] = scan.next();
			
			/*subCount represents how many items each person bought
			* subCount is used to loop through the items that each person bought
			* totalPrice represents how much money is spent by each person, which is
			  calculated in the following for loop*/
			int subCount = scan.nextInt();
			double totalPrice = 0; 
			for (int b = 0; b<subCount;b++) {
				int howMany = scan.nextInt();
				
				/*itemPrice is retrieved 
				 * the location of the string in the itemNames array is located
				 * this is then used to find the price in the same index of the parallel price array
				 */
				double itemPrice = itemPrices[findIndexOfString(scan.next(), itemNames)];
				totalPrice += itemPrice*howMany;
				}
			amountsSpent[a] = totalPrice;
		}
		
		//min & max indices are found
		//avg is calculated
		int indexOfMin = findValueMinIndex(amountsSpent);
		int indexOfMax = findValueMaxIndex(amountsSpent);
		double avg = calculateAvg(amountsSpent);
		
		/*output message
		 * uses the 2 names arrays and the amountsSpent array
		 * biggest and smallest indices are located by the variables defined above*/
		System.out.println("Biggest: " + fNames[indexOfMax] + " " + lNames[indexOfMax] + 
				" (" + String.format("%.2f",amountsSpent[indexOfMax])+ ")" );
		System.out.println("Smallest: " + fNames[indexOfMin] + " " + lNames[indexOfMin] + 
				" (" + String.format("%.2f",amountsSpent[indexOfMin])+ ")" );
		System.out.println("Average: " + String.format("%.2f",avg));
		
	}
	
	/*function used to find a string in a given array
	 * takes in the string that is being searched for, 
	   the array that is to be searched,
	   and returns the index where the string is located in the array
	 * if the string is not found, the function returns -1
	 * however, this will never happen in this program because all the 
	   strings being searched were already appended to the itemNames array
	*/
	static int findIndexOfString(String s, String[] items) {
		int index= -1;
		for (int c = 0; c< items.length; c++) {
			if (s.equals(items[c])) {
				index = c;
			}
		}
		return index;
	}
	
	/*I modified the min and max functions from A1 example to take in double[] arrays 
	 and return an index of the min/max rather the min/max itself */
	static int findValueMinIndex(double[] vals) {
			
			// Initialize current minimum to first value in array.
			double cur_min = vals[0];
			int cur_index = 0;
			// Starting with second value (if any), compare each value
			// in array with current minimum and replace if smaller.
			
			for (int i=1; i < vals.length; i++) {
				if (vals[i] < cur_min) {
					cur_min = vals[i];
					cur_index= i;
				}
			}
			
			return cur_index;
		}
	
	static int findValueMaxIndex(double[] vals) {
		
		// Initialize current minimum to first value in array.
		double cur_max = vals[0];
		int cur_index = 0;
		// Starting with second value (if any), compare each value
		// in array with current minimum and replace if smaller.
		
		for (int i=1; i < vals.length; i++) {
			if (vals[i] > cur_max) {
				cur_max = vals[i];
				cur_index = i;
			}
		}
		
		return cur_index;
	}
	
	//calculates the average of the values in a double array
	//modified from A1Example
	static double calculateAvg(double[] vals) {
		double sum= 0;
		for (int i = 0; i< vals.length; i++) {
			sum += vals[i];
		}
		return sum/vals.length;
	}
}
