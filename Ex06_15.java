import java.awt.*;
import javax.swing.*;





public class Ex06_15 {
	static class MyGUI extends JFrame {
		MyGUI(){
			setLayout(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setTitle("BoderLayout");
			
			this.setLayout(new GridLayout(10, 10));
			JButton[]btn =  new JButton[4];
			
			JButton btn1 = new JButton("�̸�");
			btn1.setBounds(10,10,100,10);
			this.add(btn1);
			
			JButton btn2 = new JButton("��������");
			btn2.setBounds(10,10,100,20);
			this.add(btn2);
			
			JButton btn3 = new JButton("��������");
			btn3.setBounds(10,10,100,30);
			this.add(btn3);
			
			JButton btn4 = new JButton("��������");
			btn4.setBounds(10,10,100,40);
			this.add(btn4);
			
			setSize(1000,500);
			setVisible(true);
		}
	
	
		
	}

	public static void main(String[] args) {
		new MyGUI();
	}
}
