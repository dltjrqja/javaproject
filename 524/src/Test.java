import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Test {

	private static final String Phonenumber = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number;
		String name;
		String address;
		String Phonenuber;
		Scanner s = new Scanner(System.in);
		HashMap<String, String> dic = new HashMap<String, String>();

		System.out.println("��ȭ��ȣ �������α׷� ����");

		while (true) {
			do {
				System.out.println("0.����: 1.����    2.ã��: 3.��ü����: 4.���� :");
				System.out.println("�Է��ϼ���");
				number = s.nextInt();
			} while ((number < 0) || (number > 4));
			if (number == 4) {
				System.out.println("���α׷�����");
				break;
			}

			switch (number) {
			case 0:
				System.out.println("�̸��Է�");
				name = s.next();
				System.out.println("�ּ��Է�");
				address = s.next();
				System.out.println("��ȣ�Է�");
				Phonenuber = s.next();
				String all = address + " " + Phonenumber;
				dic.put(name, all);
				break;
				
			case 1:
				System.out.println("�̸��Է�");
				name = s.next();
				if (dic.containsKey(name)) {
					
					dic.remove(name);
					System.out.println("��ȭ��ȣ ������ �Ϸ�Ǿ����ϴ�.");
					
				} else {
					System.out.println("���������ʴ� �̸��Դϴ�.");
				}
				break;
				
			case 2:
				System.out.println("�̸��Է�");
				
				name = s.next();
				System.out.println(name + " " + dic.get(name));
				break;

			case 3:
				
				
				
				
			}
		}

	}
}
