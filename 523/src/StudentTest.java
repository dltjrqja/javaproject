public class StudentTest {
	public static void main(String args[]) {
		String[] name = { "이석범", "배종현", "정의성", "김성현", "이효건" };
		byte[][] score = { { 90, 85, 78 }, { 52, 91, 68 }, { 100, 80, 75 }, { 64, 40, 72 }, { 70, 88, 94 } };
		short[] sum = new short[5];
		short[] sum_subject = new short[3];
		short total_sum = 0;
		float[] average = new float[5];
		float[] average_subject = new float[3];
		float total_average = 0.0f;
		short[] rank = new short[5];
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[1].length; j++) {
				sum[i] += score[i][j];
				average[i] = (float) sum[i] / score[1].length;
			}
		}

		for (int i = 0; i < score[1].length; i++) {
			for (int j = 0; j < score.length; j++) {
				sum_subject[i] += score[j][i];
				average_subject[i] = (float) sum_subject[i] / score.length;
			}
		}
		for (int i = 0; i < score.length; i++) {
			int stat = 1;
			for (int j = 0; j < score.length; j++) {
				if (sum[i] < sum[j])
					stat++;
			}
			rank[i] = (short) stat;
		}
		System.out.println("이 름\t국어\t영어\t수학\t합계\t평균\t석차\n");
		for (int i = 0; i < score.length; i++) {
			System.out.print(name[i] + "\t");
			for (int j = 0; j < score[1].length; j++) {
				System.out.print(score[i][j] + "\t");
			}
			System.out.print(sum[i] + "\t");

			System.out.format("%.1f", average[i]);
			System.out.print("\t" + rank[i]);

		}
		System.out.print("합계\t");
		for (int i = 0; i < score[1].length; i++) {
			System.out.print(sum_subject[i] + "\t");
			total_sum += sum_subject[i];
		}
		System.out.println(total_sum);
		System.out.print("평균\t");
		for (int i = 0; i < score[1].length; i++) {
			System.out.print(average_subject[i] + "\t");
			total_average += average_subject[i];
		}
		System.out.println(total_average);
	}
}
