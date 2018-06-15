import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GUI {
static class MyGUI extends JFrame{
	MyGUI(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("성적처리");
		
	String  table = (String) ("이름 .국어점수, 영어점수 , 수학점수");

	setTitle("BoderLayout");
	
	this.setLayout(new GridLayout(10, 10));
	JButton[]btn =  new JButton[4];
	
	JButton btn1 = new JButton("이름");
	this.add(btn1, BorderLayout.WEST);
	
	JButton btn2 = new JButton("영어점수");
	this.add(btn2, BorderLayout.CENTER);
	
	JButton btn3 = new JButton("수학점수");
	this.add(btn3, BorderLayout.EAST);
	
	JButton btn4 = new JButton("국어점수");
	this.add(btn4, BorderLayout.SOUTH);
	
	setSize(1000,500);
	setVisible(true);
}



}
public static void main(String[] args) {
	
}
}