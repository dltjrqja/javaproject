import java.util.Scanner;

public class RankTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String[] student = new String[5];
		int[][] score = new int[5][5];

		for (int i = 0; i < 5; i++) {
			System.out.printf("%d ���� �л� �̸��� �Է��ϼ���:", i + 1);
			student[i] = s.next();

			System.out.println("�������� �Է�");
			score[i][0] = s.nextInt();

			System.out.println("�������� �Է�");
			score[i][1] = s.nextInt();

			System.out.println("�������� �Է�");
			score[i][2] = s.nextInt();

			System.out.println("��ȸ���� �Է�");
			score[i][3] = s.nextInt();

			System.out.println("�������� �Է�");
			score[i][4] = s.nextInt();
		}
		int []korean = new int[5];
		int []Engilsh = new int[5];
		int[] Math = new int[5];
		int []Social = new int[5];
		int []Science = new int[5];
		int[] rank = new int[5];
		for (int o = 0; o < 5; o++) {
			korean += score[o][0];
			Engilsh += score[o][1];
			Math += score[o][2];
			Social += score[o][3];
			Science += score[o][4];
		}
		for(int i=0;i<5;i++){
			rank[i]=1;
			for(int j=0;j<5;j++){
				if(total[i]<total[j]){
					rank[i]++;
				}
				}
			}
		}
	for(int i =0; i<3; i++){

