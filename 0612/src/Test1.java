import java.awt.*;
import java.awt.event.*;

public class Test1 {

	public static void main(String[] args) {
		Frame frame = new Frame("���� ó��");
		frame.setLayout(new BorderLayout());

		Panel panel1 = new Panel();
		panel1.setLayout(new FlowLayout());
		frame.add(panel1, "North");

		Label title1 = new Label("����ó��");
		panel1.add(title1);

		Panel panel2 = new Panel();
		panel2.setLayout(new FlowLayout(5));
		frame.add(panel2, "Center");

		Label sub1 = new Label("����");
		Label sub2 = new Label("����");
		Label sub3 = new Label("����");
		Label sub4 = new Label("����");
		Label sub5 = new Label("����");

		TextField tf1 = new TextField("", 10);
		TextField tf2 = new TextField("", 10);
		TextField tf3 = new TextField("", 10);
		TextField tf4 = new TextField("", 10);
		TextField tf5 = new TextField("", 10);
		panel2.add(sub1);
		panel2.add(tf1);
		panel2.add(sub2);
		panel2.add(tf2);
		panel2.add(sub3);
		panel2.add(tf3);
		panel2.add(sub4);
		panel2.add(tf4);
		panel2.add(sub5);
		panel2.add(tf5);

		Panel panel3 = new Panel();
		panel3.setLayout(new FlowLayout());
		frame.add(panel3, "South");

		Button b1 = new Button("����ϱ�");
		Button b2 = new Button("�ʱ�ȭ");
		panel3.add(b1);
		panel3.add(b2);

		frame.setSize(300, 500);
		frame.setLocation(250, 300);
		frame.setVisible(true);

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
		});
		b1.addActionListener(new ButtonEventHandler());
	}

}

class ButtonEventHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		System.out.println("��ư�� ���Ƚ��ϴ�.");
	}
}