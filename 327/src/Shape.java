
public class Shape {
	private int x;
	private int y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	void print() {
		System.out.println("x��ǥ:" + x + " y��ǥ:" + y);

	}

	class Rectangle extends Shape {
		private int width;
		private int height;

		public int getWidth() {
			return width;
		}

		public void setWidth(int width) {
			this.width = width;
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}

	
 double area() {
	 return (double)width * height;
 }
 void draw(){
	 System.out.println("(" + this.getX()+ "," + this.getY()+ ") ��ġ�� " + "����:" + width + "����:" + height);
 }
}
}