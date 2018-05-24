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

		System.out.println("전화번호 관리프로그램 실행");

		while (true) {
			do {
				System.out.println("0.삽입: 1.삭제    2.찾기: 3.전체보기: 4.종료 :");
				System.out.println("입력하세요");
				number = s.nextInt();
			} while ((number < 0) || (number > 4));
			if (number == 4) {
				System.out.println("프로그램종료");
				break;
			}

			switch (number) {
			case 0:
				System.out.println("이름입력");
				name = s.next();
				System.out.println("주소입력");
				address = s.next();
				System.out.println("번호입력");
				Phonenuber = s.next();
				String all = address + " " + Phonenumber;
				dic.put(name, all);
				break;
				
			case 1:
				System.out.println("이름입력");
				name = s.next();
				if (dic.containsKey(name)) {
					
					dic.remove(name);
					System.out.println("전화번호 삭제가 완료되었습니다.");
					
				} else {
					System.out.println("존재하지않는 이름입니다.");
				}
				break;
				
			case 2:
				System.out.println("이름입력");
				
				name = s.next();
				System.out.println(name + " " + dic.get(name));
				break;

			case 3:
				
				
				
				
			}
		}

	}
}
