import java.util.Scanner; 


 

 
 


 


 
		 


 
		 public static void main(String[] args){ 


 
		  Scanner s = new Scanner(System.in); 


 
		  int[] stack = new int[5]; 


 
		  int top = 0; 


 
		  char Student = '1'; 


 
		  int select = 9; 


 
 


 
		  while (select != 3) { 


 
		   System.out.printf("1 �ֱ� 2���� 3�� : "); 


 
		   select = s.nextInt(); 


 
 


 
		   switch (select) { 


 
		   case 1: 


 
		    if (top >= 5) { 


 
		      


 
		     System.out.printf("������ ���Ƽ� ��������\n"); 


 
		    } else { 


 
		     stack[top] = Student++; 


 
		     System.out.printf("%c ������ ��\n", stack[top]); 


 
		     top++; 


 
		    } 


 
		    break; 


 



 
		   case 2: 


 
		    if (top <= 0) { 


 
		     System.out.printf("�������� �����̾���\n"); 


 
		    } else { 


 
		     top--; 


 
		     System.out.printf("%c ������ ����\n", stack[top]); 


 
		    } 


 
		    break; 


 



 
		   case 3: 


 
		    System.out.printf("���� ������ %d���� ����.\n", top); 

		    System.out.printf("�����ý�������.\n"); 

		    break; 
 
		   } 
		  } 
	 } 
	} 
public class PunishmentPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
