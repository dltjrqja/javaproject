import java.util.Scanner;

public class circles{
	int cir;
	int select;
	
	
	
	void circles(){
		String[] circles = new String[30];
		Scanner scan = new Scanner(System.in);
		int menu;
		String circles1;
		System.out.println("번호를 입력하세요");
		menu = scan.nextInt();
		System.out.println("어떤 동아리에 가입하겠습니까");
		circles1 = scan.nextLine();
		
		circles[menu] = circles1; 
		
		
		System.out.println("번호를 입력하세요");
		menu = scan.nextInt();
		
		System.out.println();
	}
	

}