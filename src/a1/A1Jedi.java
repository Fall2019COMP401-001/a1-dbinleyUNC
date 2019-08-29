package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		int itemCount = scan.nextInt();
		
		//parallel arrays created to store the names of the items, how many are bought, 
		//and how many customers bought them
		String[] itemNames = new String[itemCount];
		int[] itemFrequency = new int[itemCount];
		int [] customerFrequency = new int[itemCount];
		
		//loop collects the names of the items, but skips over the prices because they are not necessary
		for (int i = 0; i< itemCount; i++) {
			itemNames[i] = scan.next();
			scan.nextDouble();
		}
		
		//iterates through each shopper
		int shopperCount = scan.nextInt();
		for (int a = 0; a<shopperCount; a++) {
			//names of customers are not needed, so they are skipped over
			scan.next();
			scan.next();
			
			//loop iterates through all the items that each customer buys, 
			// by using subCount to determine how many they bought
			int subCount = scan.nextInt();
			for (int b = 0; b<subCount;b++) {
				int howMany = scan.nextInt();
				
				//correspondingIndex is used to save the index in the parallel arrays that corresponds to the next scanned string 
				//it is then used to add to the frequency that the item is bought and add to the amount of customers who bought it
				int correspondingIndex = A1Adept.findIndexOfString(scan.next(), itemNames);
				itemFrequency[correspondingIndex] += howMany;
				customerFrequency[correspondingIndex]++;
				}
		}
		
		/* output message
		 * uses all customerFrequency, itemFrequency, and itemNames to output the needed information
		 * includes if statement so that a different message will be displayed if no one bought a given item
		 */
		for (int b = 0; b<itemCount; b++) {
			if (customerFrequency[b] == 0) {
				System.out.println("No customers bought " + itemNames[b]);
			}
			else
				System.out.println(customerFrequency[b] + " customers bought " + itemFrequency[b] + " " + itemNames[b]);
		}
	}
}
