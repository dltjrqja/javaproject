import java.util.Scanner;

public class circles{
	int cir;
	int select;
	
	
	
	void circles(){
		String[] circles = new String[30];
		Scanner scan = new Scanner(System.in);
		int menu;
		String circles1;
		System.out.println("��ȣ�� �Է��ϼ���");
		menu = scan.nextInt();
		System.out.println("� ���Ƹ��� �����ϰڽ��ϱ�");
		circles1 = scan.nextLine();
		
		circles[menu] = circles1; 
		
		
		System.out.println("��ȣ�� �Է��ϼ���");
		menu = scan.nextInt();
		
		System.out.println();
	}
	

}