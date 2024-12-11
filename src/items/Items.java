package items;
//Abstract class
public abstract class Items {
	//Private variables for all of the info from the items
	private String name;
	private double weight;
	private double length;
	private double width;
	private double height;
	
	//Constructor using fields
	public Items() {
		super();
	}

	//Getters and setters
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getWeight() {
		return weight;
	}



	public void setWeight(double weight) {
		this.weight = weight;
	}



	public double getLength() {
		return length;
	}



	public void setLength(double length) {
		this.length = length;
	}



	public double getWidth() {
		return width;
	}



	public void setWidth(double width) {
		this.width = width;
	}



	public double getHeight() {
		return height;
	}



	public void setHeight(double height) {
		this.height = height;
	}
//Calculating the volume of each item
	public double calculateVolume() {
		return length * width * height;
	}

//Print item info(to be implemented in subclasses
	public abstract void printItemInfo();


}
