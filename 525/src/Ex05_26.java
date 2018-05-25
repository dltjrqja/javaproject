import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

 
public class Ex05_26 {
	static class MyGUI extends JFrame{
		MyGUI(){
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setTitle("이벤트 처리 3");
			this.setLayout(new FlowLayout());
			
			JTextField txt = new JTextField(10);
			JTextArea area = new JTextArea(10, 10);
			this.add(txt);
			this.add(area);
			
			txt.addKeyListener(new KeyAdapter(){
				public void keyReleased(KeyEvent e){
					int key = e.getKeyCode();
					if(key == KeyEvent.VK_ENTER){
						String str = txt.getText();
						
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
