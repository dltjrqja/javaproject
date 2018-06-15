import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class Test extends JFrame {
	int row = 0;

	public Test() {

		Vector columnNames = new Vector();

		columnNames.add("이름");

		columnNames.addElement("국어점수");

		columnNames.addElement("영어점수");

		columnNames.addElement("수학점수");

		columnNames.addElement("총합");

		columnNames.addElement("평균");

		ScoreDAO scoreDAO = new ScoreDAO();

		ScoreDTO scoreDTO = new ScoreDTO();

		scoreDAO.getConn();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setTitle("성적 관리프로그램");

		setBounds(450, 250, 1200, 320);

		setLayout(null);

		DefaultTableModel defaultTableModel = new DefaultTableModel(scoreDAO.getScore(), columnNames);

		JTable jTable = new JTable(defaultTableModel);

		JScrollPane jsp = new JScrollPane(jTable);

		jsp.setBorder(BorderFactory.createLineBorder(Color.black));

		jsp.setBounds(410, 10, 760, 260);

		JLabel nameLabel = new JLabel("이름");

		nameLabel.setBorder(new BevelBorder(BevelBorder.RAISED));

		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setBounds(10, 10, 120, 50);
		JTextField nameField = new JTextField(10);
		nameField.setBounds(140, 10, 120, 50);
		JButton addButton = new JButton("추가");
		addButton.setBounds(270, 10, 120, 50);
		JLabel korLabel = new JLabel("국어점수");
		korLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
		korLabel.setHorizontalAlignment(SwingConstants.CENTER);
		korLabel.setBounds(10, 70, 120, 50);
		JTextField korField = new JTextField(10);
		korField.setBounds(140, 70, 120, 50);
		JButton removeButton = new JButton("제거");

		removeButton.setBounds(270, 70, 120, 50);

		JLabel engLabel = new JLabel("영어점수");

		engLabel.setBorder(new BevelBorder(BevelBorder.RAISED));

		engLabel.setHorizontalAlignment(SwingConstants.CENTER);

		engLabel.setBounds(10, 130, 120, 50);

		JTextField engField = new JTextField(10);

		engField.setBounds(140, 130, 120, 50);

		JButton modifyButton = new JButton("수정");

		modifyButton.setBounds(270, 130, 120, 50);

		JLabel mathLabel = new JLabel("수학점수");

		mathLabel.setBorder(new BevelBorder(BevelBorder.RAISED));

		mathLabel.setHorizontalAlignment(SwingConstants.CENTER);

		mathLabel.setBounds(10, 190, 120, 50);

		JTextField mathField = new JTextField(10);

		mathField.setBounds(140, 190, 120, 50);

		JFrame alert = new JFrame();

		alert.setBounds(450, 250, 450, 250);

		addButton.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {

				scoreDTO.setName(nameField.getText());

				scoreDTO.setKor(Integer.parseInt(korField.getText()));

				scoreDTO.setEng(Integer.parseInt(engField.getText()));

				scoreDTO.setMat(Integer.parseInt(mathField.getText()));

				scoreDTO.setSum(scoreDTO.getKor() + scoreDTO.getEng() + scoreDTO.getMat());

				scoreDTO.setAve((int) scoreDTO.getSum() / 3);

				scoreDAO.insertScore(scoreDTO);

				nameField.setText("");

				korField.setText("");

				engField.setText("");

				mathField.setText("");

				Vector res = scoreDAO.getScore();

				defaultTableModel.setDataVector(res, columnNames);

				defaultTableModel.fireTableDataChanged();

				jTable.setModel(defaultTableModel);

			}

		});

		removeButton.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {

				int row = jTable.getSelectedRow();

				if (row == -1) {
					return;
				}

				scoreDAO.deleteScore(scoreDTO);

				nameField.setText("");

				korField.setText("");

				engField.setText("");

				mathField.setText("");

				Vector res = scoreDAO.getScore();

				defaultTableModel.setDataVector(res, columnNames);

				defaultTableModel.fireTableDataChanged();

				jTable.setModel(defaultTableModel);

			}

		});

		jTable.addMouseListener(new MouseListener() {

			@Override

			public void mouseClicked(MouseEvent arg0) {

				// TODO Auto-generated method stub

				int rw = jTable.getSelectedRow();

				row = rw;

				int column = jTable.getColumnCount();

				if (row == -1) {
					return;
				}

				String n = (String) defaultTableModel.getValueAt(row, 0);

				scoreDTO.setName(n);

				nameField.setText(String.valueOf(jTable.getValueAt(row, 0)));

				korField.setText(String.valueOf(jTable.getValueAt(row, 1)));

				engField.setText(String.valueOf(jTable.getValueAt(row, 2)));

				mathField.setText(String.valueOf(jTable.getValueAt(row, 3)));

			}

			@Override

			public void mouseEntered(MouseEvent e) {

				// TODO Auto-generated method stub

				return;

			}

			@Override

			public void mouseExited(MouseEvent e) {

				// TODO Auto-generated method stub

				return;

			}

			@Override

			public void mousePressed(MouseEvent e) {

				// TODO Auto-generated method stub

				return;

			}

			@Override

			public void mouseReleased(MouseEvent e) {

				// TODO Auto-generated method stub

				return;

			}

		});

		modifyButton.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {

				scoreDTO.setName(nameField.getText());

				scoreDTO.setKor(Integer.parseInt(korField.getText()));

				scoreDTO.setEng(Integer.parseInt(engField.getText()));

				scoreDTO.setMat(Integer.parseInt(mathField.getText()));

				scoreDTO.setSum(scoreDTO.getKor() + scoreDTO.getEng() + scoreDTO.getMat());

				scoreDTO.setAve((int) scoreDTO.getSum() / 3);

				scoreDAO.updateScore(scoreDTO);

				nameField.setText("");

				korField.setText("");

				engField.setText("");

				mathField.setText("");

				Vector res = scoreDAO.getScore();

				defaultTableModel.setDataVector(res, columnNames);

				defaultTableModel.fireTableDataChanged();

				jTable.setModel(defaultTableModel);

			}

		});

		add(nameLabel);

		add(nameField);

		add(addButton);

		add(korLabel);

		add(korField);

		add(removeButton);

		add(engLabel);

		add(engField);

		add(modifyButton);

		add(mathLabel);

		add(mathField);

		add(jsp);

		setVisible(true);
	}

	public static void main(String[] args) {

		Test t = new Test();

	}

}