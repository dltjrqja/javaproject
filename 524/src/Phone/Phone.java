package Phone;

import java.util.*;

public class Phone {

	public static void main(String[] args) {

		int number;

		String name;
		String address;
		String phonenumber;

		Scanner r = new Scanner(System.in);

		HashMap<String, String> dic = new HashMap<String, String>();

		System.out.println("��ȭ��ȣ ���� ���α׷� ����");

		while (true) {

			do {
				System.out.println("0.���� :  1.���� :  2.ã��:  3.��ü����:  4.���� : ");

				System.out.print("�Է� >>> ");

				number = r.nextInt();

			} while ((number < 0) || (number > 4));

			if (number == 4) {

				System.out.println("���α׷��� ����˴ϴ�");
				break;
			}
			switch (number) {

			case 0:
				System.out.print("�̸� �Է�  ");
				name = r.next();
				System.out.print("�ּ� �Է� ");
				address = r.next();
				System.out.print("��ȭ �Է�  ");

				phonenumber= r.next();

				String all = address + " " + phonenumber;

				dic.put(name, all);
				break;

			case 1:
				System.out.print("�̸� �Է� > ");

				name = r.next();
				if (dic.containsKey(name)) {
					dic.remove(name);

					System.out.println("������ �Ϸ�Ǿ����ϴ�.");
				} else {

					System.out.println("�������� �ʴ� �̸��Դϴ�.");
				}
				break;
			case 2:
				System.out.print("�̸� �Է� >>> ");
				name = r.next();
				System.out.println(name + " " + dic.get(name));
				break;
			case 3:

				Set<String> keys = dic.keySet();

				Iterator<String> it = keys.iterator(); 
				while (it.hasNext()) {
					String key = it.next();

					String value = dic.get(key);

					System.out.println(key + "," + value);
				}
				break;
			}
		}
	}
}