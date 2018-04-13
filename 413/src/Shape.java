

public class Shape {
	private int x;
	private int y;

	public Shape(int x, int y) {
		System.out.println("Shape()");
		this.x = x;
		this.y = y;

	}
}
 class ColoredRectangle extends Rectangle {
		String color;

		public ColoredRectangle(int x, int y, int width, int height, String color) {
			super(x, y, width, height);
			System.out.println("ColoredRectangle()");
			this.color = color;
		}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ColoredRectangle obj = new ColoredRectangle(10, 10, 20, 20, "red");
	}
}  
 class Rectangle extends Shape {
	private int width;
	private int height;
	
	public Rectangle(int x, int y, int width, int height){
		super(x, y);
		System.out.println("Rectangle()");
		this.width = width;
		this.height = height;
	}
		double calcArea(){
			return width * height;
		}
		
 }
	