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

		System.out.println("전화번호 관리 프로그램 시작");

		while (true) {

			do {
				System.out.println("0.삽입 :  1.삭제 :  2.찾기:  3.전체보기:  4.종료 : ");

				System.out.print("입력 >>> ");

				number = r.nextInt();

			} while ((number < 0) || (number > 4));

			if (number == 4) {

				System.out.println("프로그램이 종료됩니다");
				break;
			}
			switch (number) {

			case 0:
				System.out.print("이름 입력  ");
				name = r.next();
				System.out.print("주소 입력 ");
				address = r.next();
				System.out.print("전화 입력  ");

				phonenumber= r.next();

				String all = address + " " + phonenumber;

				dic.put(name, all);
				break;

			case 1:
				System.out.print("이름 입력 > ");

				name = r.next();
				if (dic.containsKey(name)) {
					dic.remove(name);

					System.out.println("삭제가 완료되었습니다.");
				} else {

					System.out.println("존재하지 않는 이름입니다.");
				}
				break;
			case 2:
				System.out.print("이름 입력 >>> ");
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