import java.util.Scanner; 

public class CirclesTest {
	public static void main(String[] args){ 
		// TODO Auto-generated method stub
		
			String[] circles = new String[30];

			Scanner scan = new Scanner(System.in);

			int menu;
			String Bowling = ("볼링부");
			String Billiarddepartment=("당구부");
			String Reading=("독서부");
			String movie=("영화감상부");
			String s = null;
			String join =("가입되었습니다");
			String circles1;

			System.out.println("번호를 입력하세요");
			
			

			System.out.println("어떤 동아리에 가입하겠습니까");
			s = scan.next();
			System.out.println("영화감상부");
			if(s.equalsIgnoreCase(movie) )
				System.out.println("동아리가입에 성공하셨습니다");
			System.out.println("독서부");
			if(s.equalsIgnoreCase(Reading) )
				System.out.println("동아리가입에 성공하셨습니다");
			System.out.println("당구부");
			if(s.equalsIgnoreCase(Billiarddepartment) )
				System.out.println("동아리가입에 성공하셨습니다");
			System.out.println("볼링부");
			if(s.equalsIgnoreCase(Bowling) )
				System.out.println("동아리가입에 성공하셨습니다");
			s=scan.next();
			circles1 = scan.nextLine();
			menu = scan.nextInt();

			System.out.println();
			circles1 = scan.next();
			if(s.equalsIgnoreCase(null) )
				System.out.println("동아리가입에 성공하셨습니다");
	}
}
