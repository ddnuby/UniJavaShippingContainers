//DinaOrman
package test;
//All inputs necessarily
import items.Mouse; 
import items.Laptop;
import items.LCDscreen;
import items.Desktop;
import methods.Calculations;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		//Calling scanner
        try (Scanner scanner = new Scanner(System.in)) {
			Calculations calculation = new Calculations();
			
			System.out.println("Enter quantity for each item:");
			int laptopQuantity = getInputQuantity(scanner, "Laptop");
            int mouseQuantity = getInputQuantity(scanner, "Mouse");
            int desktopQuantity = getInputQuantity(scanner, "Desktop");
            int lcdScreenQuantity = getInputQuantity(scanner, "LCD Screen");
			//getInputQuantity is for the try and catch, or the error handling, so it has all of the info about the inputs, and can see which are wrong
			
			calculation.addItems(new Laptop(), laptopQuantity);
			calculation.addItems(new Mouse(), mouseQuantity);
			calculation.addItems (new Desktop(), desktopQuantity);
			calculation.addItems(new LCDscreen(), lcdScreenQuantity);

           
			// Read the order information
			calculation.addOrder(0);
			
			
		//Printing item info as well as total weight and volume
			System.out.println(calculation.printItem());
			
			double totalWeight = calculation.totalWeight();
			System.out.println("Total Weight of all items is: " + totalWeight + " kg");
			double totalVolume = calculation.totalVolume();
			System.out.println("Total Volume of all items is: " + totalVolume + " m3");
			System.out.println(calculation.printOrder());
	
      }
        
     
        
        
        }
	 // Helper method to get valid input for item quantity
	private static int getInputQuantity(Scanner scanner, String itemName) {
	    int quantity;
	    while (true) {
	        System.out.print(itemName + ": ");
	        String input = scanner.nextLine();
	        try {
	            quantity = Integer.parseInt(input);

	            // Check if quantity is negative or decimal
	            if (quantity < 0 || quantity != (int) quantity) {
	                throw new InputMismatchException();
	            }

	            break; // Break out of the loop if input is valid
	        } catch (NumberFormatException e) {
	            System.out.println("Oops!It seems like there is an invalid input. Please try and enter the value down below again.");
	        } catch (InputMismatchException e) {
	            System.out.println("Oops!It seems like there is an invalid input. Please try and enter the value down below again.");
	        }
	    }
	    return quantity;
	}
}
	

