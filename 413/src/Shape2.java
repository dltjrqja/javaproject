
public class Shape2 {
	protected int x, y;
}

class Rectangle extends Shape2 {
	private int width, height;
}
	class Triagle extends Shape2{
		private int base, height;
	}
	class Circle extends Shape2{
		private int radius;
	}
	class ShapeTest{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape2 s1, s2;
		s1 = new Shape2();
		s2 = new Rectangle();
		
	}

}
