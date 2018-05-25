import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Ex_05_25 {
	static class MyGUI extends JFrame {
	MyGUI(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("이벤트 처리 2");
		this.setLayout(new FlowLayout());
		
		JTextField txtX = new JTextField(10);
		JTextField txtY = new JTextField(10);
		this.add(txtX);
		this.add(txtY);
		this.addMouseListener(new MouseListener(){
		public void mouseClicked(MouseEvent e){	
		txtX.setText(Integer.toString(e.getX()));
		txtY.setText(Integer.toString(e.getY()));
		}
		public void mouseEntered(MouseEvent e){
			
		}
		public void mouseExited(MouseEvent e){
		}
		public void mousePressed(MouseEvent e){
	}
		public void mouseReleased(MouseEvent e){
}
		});
		setSize(500, 200);
		setVisible(true);
	}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyGUI();

	}

}
