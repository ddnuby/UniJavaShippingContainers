package containers;
//Inheritance
public class BigContainer extends Containers{
	//Private variables that have info about the big container
	private double length = 12.01;
	private double width = 2.43;
	private double height =  2.59;
	
	//constructor using super()
	public BigContainer() {
		super();
	
	//Getters and setters
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

	// Calculate the volume of the container
	public double calculateVolume() {
		return this.length * this.width * this.height;
	}
	// Get the shipping cost for the container
	public double getShippingCost() {
        return 1800.0;
    }
	
	//Print container information
	public void printContainerInfo() {
		System.out.println("Container Info : ");
		System.out.println("Container Dimensions: " + this.length + " x " + this.width + " x " + this.height + " m");
		System.out.println("Volume: " + calculateVolume() + " m³");
		System.out.println("-------------------------------");
	}
}
