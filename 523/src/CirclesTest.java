import java.util.Scanner; 

public class CirclesTest {
	public static void main(String[] args){ 
		// TODO Auto-generated method stub
		
			String[] circles = new String[30];

			Scanner scan = new Scanner(System.in);

			int menu;
			String Bowling = ("������");
			String Billiarddepartment=("�籸��");
			String Reading=("������");
			String movie=("��ȭ�����");
			String s = null;
			String join =("���ԵǾ����ϴ�");
			String circles1;

			System.out.println("��ȣ�� �Է��ϼ���");
			
			

			System.out.println("� ���Ƹ��� �����ϰڽ��ϱ�");
			s = scan.next();
			System.out.println("��ȭ�����");
			if(s.equalsIgnoreCase(movie) )
				System.out.println("���Ƹ����Կ� �����ϼ̽��ϴ�");
			System.out.println("������");
			if(s.equalsIgnoreCase(Reading) )
				System.out.println("���Ƹ����Կ� �����ϼ̽��ϴ�");
			System.out.println("�籸��");
			if(s.equalsIgnoreCase(Billiarddepartment) )
				System.out.println("���Ƹ����Կ� �����ϼ̽��ϴ�");
			System.out.println("������");
			if(s.equalsIgnoreCase(Bowling) )
				System.out.println("���Ƹ����Կ� �����ϼ̽��ϴ�");
			s=scan.next();
			circles1 = scan.nextLine();
			menu = scan.nextInt();

			System.out.println();
			circles1 = scan.next();
			if(s.equalsIgnoreCase(null) )
				System.out.println("���Ƹ����Կ� �����ϼ̽��ϴ�");
	}
}
