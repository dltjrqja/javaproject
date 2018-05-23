import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []korean = new int[3];
		int []Engilsh = new int[3];
		int[] Math = new int[3];
		int[] rank = new int[3];
		int[]total = new int[3];
		Scanner scan = new Scanner(System.in);
		
		for (int i =0;i<3;i++){
			
			System.out.printf("%d번쨰 국어점수 입력:",i+1);
			korean[i]=scan.nextInt();
			System.out.printf("%d번쨰 영어점수 입력:",i+1);
			Engilsh[i]=scan.nextInt();
			System.out.printf("%d번쨰 수학점수 입력:",i+1);
			Math[i]=scan.nextInt();
			
			
				
			total[i]=korean[i]+Engilsh[i]+Math[i];
		}
		for(int i=0;i<3;i++){
			rank[i]=1;
			for(int j=0;j<3;j++){
				if(total[i]<total[j]){
					rank[i]++;
	}
	

}
	System.out.printf("국어:%5d 영어:%5d 수학:%5d  총점:%7d 등수: %5d\n",korean[i],
			Engilsh[i],Math[i],total[i],rank[i]);
	}
		}
	}
