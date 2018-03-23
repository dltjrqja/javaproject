
 class Box {
	int width, lenght, height;
	Box(int w, int l, int h) {
		width = w;
		lenght = l;
		height = h;
	}
	
	boolean isSameBox(Box obj) {
		int length = 0;
		if((obj.width == width) & (obj.lenght == length)
				& (obj.height == height))
			
			return true;
		else
			return false;
	}
}
	
	
 class BoxTest {	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Box obj1 = new Box(10, 20, 50);
Box obj2 = new Box(10, 20, 50);
System.out.println("obj1 == obj2 : " + obj1.isSameBox(obj2));
	}

}
 