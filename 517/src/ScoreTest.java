import java.io.*;

public class ScoreTest {
public static void main(String[] ar) throws IOException{

BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
String name;
int kor, eng, math, tot;
float avg;


System.out.print("이름 = ");
name = in.readLine();

System.out.print("국어 = ");
kor = Integer.parseInt( in.readLine() );

System.out.print("영어 = ");
eng = Integer.parseInt( in.readLine() );

System.out.print("수학 = ");
math = Integer.parseInt( in.readLine() );


tot = kor + eng + math;
avg = tot / 3.0f;

System.out.println(); // 개행의 의미
System.out.println(name + " 님!! 당신의 성적은 다음과 같습니다.");
System.out.println("총점 : " + tot + " 점");
System.out.printf("평균 : %.2f 점\n", avg);
}
}
