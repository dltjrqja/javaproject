class Car{
	private String model;

    private String color;

    private int speed;



     // 자동차의 시리얼 번호

    private int id;

    static int numbers = 0;



    public Car(String m, String c, int s) {

          model = m;

          color = c;

          speed = s;

           // 자동차의 개수를 증가하고 id에 대입한다. 

          id = ++numbers;

    }

}
public class CarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car c1 = new Car("S600", "white", 80); 	// 첫 번째 생성자 호출

        Car c2 = new Car("E500", "blue", 20); 	// 첫 번째 생성자 호출

        int n = Car.numbers;	// 정적 변수 

        System.out.println("지금까지 생성된 자동차 수 = " + n);
 
  }

}
