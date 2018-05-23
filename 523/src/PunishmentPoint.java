import java.util.Scanner; 


 

 
 


 


 
		 


 
		 public static void main(String[] args){ 


 
		  Scanner s = new Scanner(System.in); 


 
		  int[] stack = new int[5]; 


 
		  int top = 0; 


 
		  char Student = '1'; 


 
		  int select = 9; 


 
 


 
		  while (select != 3) { 


 
		   System.out.printf("1 넣기 2빼기 3끝 : "); 


 
		   select = s.nextInt(); 


 
 


 
		   switch (select) { 


 
		   case 1: 


 
		    if (top >= 5) { 


 
		      


 
		     System.out.printf("상점이 많아서 들어가지않음\n"); 


 
		    } else { 


 
		     stack[top] = Student++; 


 
		     System.out.printf("%c 상점이 들어감\n", stack[top]); 


 
		     top++; 


 
		    } 


 
		    break; 


 



 
		   case 2: 


 
		    if (top <= 0) { 


 
		     System.out.printf("빠져나갈 상점이없음\n"); 


 
		    } else { 


 
		     top--; 


 
		     System.out.printf("%c 상점이 빠짐\n", stack[top]); 


 
		    } 


 
		    break; 


 



 
		   case 3: 


 
		    System.out.printf("현재 상점이 %d점이 있음.\n", top); 

		    System.out.printf("상점시스템종료.\n"); 

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
