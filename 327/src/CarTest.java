
class Car{
	int speed;
	public void setspeed(int speed){
		this.speed = speed;
		System.out.println("�ӵ���" + speed);
	}	
}


class SportCar extends Car {
	public void setTurbo(boolean flag){
		boolean turbo;
	 turbo = flag; 
	}
}
	 class Motorcycle extends Car{
		 public void setSound(boolean on){ 
			 boolean Sound;
			 Sound = on;
		 }
	 } 
class Truck extends Car {
	public void setClearance(boolean none){
		boolean Clearance;
		Clearance = none;
		System.out.println("�������´�" + Clearance);		
	}
}	 
public class CarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Truck  c = new Truck();
		c.speed = 20;
		c.setspeed(80);
		c.setClearance(true);
		
		 	
			
			
			
	}
		}