package methods;
//All of the required imports for the class 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import containers.BigContainer;
import containers.SmallContainer;
import items.Items;

public class Calculations {
	//All private variables and lists that are going to be implemented in the class
	private List<Items> items;
	private List <Integer> order;
	private Map<Items,Integer> itemQuantityMap;
	private int orderQuantity;
	private int counterBC = 0;
	private int counterSC = 0;
	
	//Getters and Setters for counter for Big Containers and counter for Small Containers
	public int getCounterBC() {
		return counterBC;
	}
	public void setCounterBC(int counterBC) {
		this.counterBC = counterBC;
	}
	public int getCounterSC() {
		return counterSC;
	}
	public void setCounterSC(int counterSC) {
		this.counterSC = counterSC;
	}
	//Getters and Setters for order quantity
	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	
	//This would be a default constructor for items, itemquantiymap and order. They consist of lists for saving order and quantity.
	public Calculations() {
		items = new ArrayList<>();
		itemQuantityMap = new HashMap<>();
		order = new ArrayList<>();
	}
	
		//Constructor using fields
	public Calculations(List<Items> items, List<Integer> order) {
		super();
		this.items = items;
		this.order = order;
	}
	
	// Add items to the list and update itemQuantityMap, so that it would not print the information about the items too many times and would just print the info once.
	public void addItems(Items item, int quantity) {
		for (int i = 0; i < quantity; i++) {
	        items.add(item);
		}
		itemQuantityMap.put(item, quantity);
	}
	//Add order quantity to the list of order
	public void addOrder(int orderQuantity) {
		order.add(orderQuantity);
	}
	// Calculate the total volume of all items
	public double totalVolume() {
		double totalVolume = 0;
		for (Items item : items) {
			totalVolume += item.calculateVolume();
		}
		return totalVolume;
	}
	// Calculate the total weight of all items
	public double totalWeight() {
		double totalWeight = 0;
		for (Items item : items) {
			totalWeight += item.getWeight();
		}
		return totalWeight;
	}
	
	// Determine the best shipping method and return the number of big containers and small containers needed by comparing totalVolume or volume left with the Volume of the containers
	
	public int[] bestShipping() {
	    double volumeLeft = totalVolume();
	    this.counterBC = 0;
	    this.counterSC = 0;
	    double volSC = new SmallContainer().calculateVolume();
	    double volBC = new BigContainer().calculateVolume();

	    if (volumeLeft <= volSC) {
	        this.counterSC = 1;
	    } else {
	        while (volumeLeft > volBC) {
	            this.counterBC++;
	            volumeLeft -= volBC;
	        }

	        if (volumeLeft <= volSC) {
	            this.counterSC = 1;
	        } else {
	            this.counterBC++;
	        }
	    }
	    return new int[] { this.counterBC, this.counterSC };
	}
    // Calculate the total shipping price by mulitplying the price that is from the containers classes
	//by multiplying the amount of Big COntainers or Small Containers. Additionally, when it comes to small containers, it 
	//it compares the weights, since there are 2 prices for Small Containers
	public double shippingPrice() {
	    double priceBC = new BigContainer().getShippingCost();
	    double priceSC = new SmallContainer().getShippingCost();
	    
	    int[] shippingMethod = bestShipping();
	    int counterBC = shippingMethod[0];
	    int counterSC = shippingMethod[1];
	    
	    double totalWeight = totalWeight();
	    double totalPrice = 0.0;

	    totalPrice += counterBC * priceBC;
	    if (totalWeight <= 500) {
	        totalPrice += counterSC * priceSC; // Shipping cost for 500 kg or less
	    } else {
	        totalPrice += counterSC * 1200.0; // Shipping cost for weight more than 500 kg
	    }
	    
	    return totalPrice;
	}
	//Print the infromatioin about the items in String form, due to GUI being able to put only return part of the printItem function
	//therefore it is easier to create a string, as well as creating a concat, as it concatenates one string to the end of another, therefore appending
	// it to the end of the String.This part is useful in GUI implementation of the project.
     public String printItem() {
    	 String info = "Items Information: ";
    	 String divide = "\n--------------------------------------------------------------------";
    	 String printIt = "";
    	    Set<Items> printedItems = new HashSet<>();//Hashset is created so that it will be easier to access unique items at all items
    	    //in this case, the printed amount of items. This ensures that the item info is printed only once for each item.
    	    
    	    for (Items item : items) {
    	        if (!printedItems.contains(item)) {
    	            int quantity = itemQuantityMap.containsKey(item) ? itemQuantityMap.get(item) : 0;
    	            String itemsPrint = "\nItem: " + item.getName() + " has dimensions: " 
    	            + item.getLength() + " x " + item.getWidth() + " x " + item.getHeight() + " m. " +
    	            "\nQuantity: " + quantity + ", Volume: " + item.calculateVolume() * quantity + " m3" +
    	            " and Weight: " + item.getWeight() * quantity + " kg.";
    	            printIt = printIt.concat(itemsPrint).concat(divide);
    	            printedItems.add(item);
    	        }
    	    }
    	    return (info + divide + printIt + divide);
			
     }
     // Print information about the order, which would be bestShipping and shippingPrice of the whole order of items being input in the scanner. 
     public String printOrder() {
    	 int[] shippingMethod = bestShipping();
    	 double totalPrice = shippingPrice();
    	 System.out.println();
    	 System.out.println("Best Shipping Method would be: " + shippingMethod[0] + " Big Container(s), " + shippingMethod[1] + " Small Container(s)");
			System.out.println("Total Shipping Price: " + totalPrice + " €");
       return ("-----------------------");
     
     }
     
    	 
   
    
    }

