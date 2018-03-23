
 class Employee {
			private String name;

			private double salary;
	


			private static int count = 0; // 정적 변수
	
	

			// 생성자

			public Employee(String n, double s) {

				name = n;

				salary = s;

				count++; // 정적 변수인 count를 증가

			}



			// 객체가 소멸될 때 호출된다.

			protected void finalize() {

				count--; // 직원이 하나 줄어드는 것이므로 count를 하나 감소

			}



			// 정적 메소드

			public static int getCount() {

				return count;

			}
		}
	public class EmployeeTest {

		public static void main(String[] args) {

			Employee e1, e2, e3;

			e1 = new Employee("김철수", 35000);

			e2 = new Employee("최수철", 50000);

			e3 = new Employee("김철호", 20000);



			int n = Employee.getCount();

			System.out.println("현재의 직원수=" + n);

		}

	}
 

