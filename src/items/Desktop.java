package items;
//Inheritance
public class Desktop extends Items{
	
	private String name = "Desktop";
	//Private variables for the item  with info stored in them
	private double weight = 20;
	private double length = 1;
	private double width = 0.5;
	private double height = 1.5;

	//Constructor using super (inheritance from the superclass)
	public Desktop() {
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

	//Calculate the volume of the item
	@Override
	public double calculateVolume() {
		return this.length * this.width * this.height;
	}
	//Print item info
	public void printItemInfo() {
		System.out.println("Item: " + this.name);
		System.out.println("the weight is " + this.weight + "kg");
		System.out.println("the dimensions are " + this.length + " x " + this.width + " x " + this.height + " m");
		System.out.println("the volume is " + calculateVolume() + " cubic m");
		System.out.println("----------------------");
	}

}
