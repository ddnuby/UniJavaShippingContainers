package containers;

public class Containers {
	//Private variables for all containers
	private double length;
	private double width;
	private double height;
	
	//Constructor using fields 
	public Containers() {
		super();
	}
	//Getters and setters
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
	
	
	public double calculateVolume() {
		return length * width * height;
	}
	// Print container information for all containers
	public void printContainerInfo() {
		System.out.println("Container Info");
		System.out.println("Container Dimensions: " + length + " x " + width + " x " + height + " cm");
		System.out.println("Volume: " + calculateVolume() + " cm³");
		System.out.println("-------------------------------");
	}
}
