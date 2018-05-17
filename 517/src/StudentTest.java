import java.util.Scanner;

	class StudentTest1 {

		public static void main(String[] args) {

			Scanner sc = new Scanner(System.in);
			int []stu = new int[10];
			int tot=0, avg;
			for(int i=0; i<10; i++){
				System.out.print( (i+1)+ "번재 학생의 점수를 입력하세요==>");
				stu[i] = sc.nextInt();
				tot = tot + stu[i];
			}
			avg = tot/10;

			System.out.println(" 성적 결과 ");

			for(int i=1; i<=10; i++)

				System.out.print(i + "\t");

			System.out.println();

			for(int i=0; i<10; i++)
				System.out.print(stu[i] + "\t");

			System.out.println();

			System.out.println("총점:" + tot);

			System.out.println("평균:" + avg);

		}

	}

public class StudentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
