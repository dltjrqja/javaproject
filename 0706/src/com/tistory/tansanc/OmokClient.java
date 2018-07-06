package com.tistory.tansanc;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Point;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;

class OmokBoard extends Canvas {
	public static final int BLACK = 1, WHITE = -1;
	private int[][] map;
	private int size;
	private int cell;
	private String info = "게임 중지";
	private int color = BLACK;

	private boolean enable = false;

	private boolean running = false;
	private PrintWriter writer;
	private Graphics gboard, gbuff;
	private Image buff;

	OmokBoard(int s, int c) {
		this.size = s;
		this.cell = c;

		map = new int[size + 2][];
		for (int i = 0; i < map.length; i++)
			map[i] = new int[size + 2];

		setBackground(new Color(200, 200, 100));
		setSize(size * (cell + 1) + size, size * (cell + 1) + size);

		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				if (!enable)
					return;

				int x = (int) Math.round(me.getX() / (double) cell);
				int y = (int) Math.round(me.getY() / (double) cell);

				if (x == 0 || y == 0 || x == size + 1 || y == size + 1)
					return;

				if (map[x][y] == BLACK || map[x][y] == WHITE)
					return;

				writer.println("[STONE]" + x + " " + y);

				map[x][y] = color;

				if (check(new Point(x, y), color)) {
					info = "이겼습니다.";
					writer.println("[WIN]");
				}

				else
					info = "상대가 두기를 기다립니다.";
				repaint();
				enable = false;
			}
		});
	}

	public boolean isRunning() {
		return running;
	}

	public void startGame(String col) {
		running = true;
		if (col.equals("BLACK")) {
			enable = true;
			color = BLACK;
			info = "게임 시작... 두세요.";
		} else {
			enable = false;
			color = WHITE;
			info = "게임 시작... 기다리세요.";
		}
	}

	public void stopGame() {
		reset();
		writer.println("[STOPGAME]");
		enable = false;
		running = false;
	}

	public void putOpponent(int x, int y) {
		map[x][y] = -color;
		info = "상대가 두었습니다. 두세요.";
		repaint();
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public void setWriter(PrintWriter writer) {
		this.writer = writer;
	}

	public void update(Graphics g) {
		paint(g); // paint를 호출한다.
	}

	public void paint(Graphics g) {
		if (gbuff == null) {
			buff = createImage(getWidth(), getHeight());
			gbuff = buff.getGraphics();
		}
		drawBoard(g);
	}

	public void reset() {
		for (int i = 0; i < map.length; i++)
			for (int j = 0; j < map[i].length; j++)
				map[i][j] = 0;
		info = "게임 중지";
		repaint();
	}

	private void drawLine() {
		gbuff.setColor(Color.black);
		for (int i = 1; i <= size; i++) {
			gbuff.drawLine(cell, i * cell, cell * size, i * cell);
			gbuff.drawLine(i * cell, cell, i * cell, cell * size);
		}
	}

	private void drawBlack(int x, int y) {
		Graphics2D gbuff = (Graphics2D) this.gbuff;
		gbuff.setColor(Color.black);
		gbuff.fillOval(x * cell - cell / 2, y * cell - cell / 2, cell, cell);
		gbuff.setColor(Color.white);
		gbuff.drawOval(x * cell - cell / 2, y * cell - cell / 2, cell, cell);
	}

	private void drawWhite(int x, int y) {
		gbuff.setColor(Color.white);
		gbuff.fillOval(x * cell - cell / 2, y * cell - cell / 2, cell, cell);
		gbuff.setColor(Color.black);
		gbuff.drawOval(x * cell - cell / 2, y * cell - cell / 2, cell, cell);
	}

	private void drawStones() {
		for (int x = 1; x <= size; x++)
			for (int y = 1; y <= size; y++) {
				if (map[x][y] == BLACK)
					drawBlack(x, y); 
				else if (map[x][y] == WHITE)
					drawWhite(x, y);
			}
	}

	synchronized private void drawBoard(Graphics g) {

		gbuff.clearRect(0, 0, getWidth(), getHeight());
		drawLine();
		drawStones();
		gbuff.setColor(Color.red);
		gbuff.drawString(info, 20, 15);
		g.drawImage(buff, 0, 0, this);
	}

	private boolean check(Point p, int col) {
		if (count(p, 1, 0, col) + count(p, -1, 0, col) == 4)
			return true;
		if (count(p, 0, 1, col) + count(p, 0, -1, col) == 4)
			return true;
		if (count(p, -1, -1, col) + count(p, 1, 1, col) == 4)
			return true;
		if (count(p, 1, -1, col) + count(p, -1, 1, col) == 4)
			return true;
		return false;
	}

	private int count(Point p, int dx, int dy, int col) {
		int i = 0;
		for (; map[p.x + (i + 1) * dx][p.y + (i + 1) * dy] == col; i++)
			;
		return i;
	}

	public class OmokClient extends Frame implements Runnable, ActionListener {
		private TextArea msgView = new TextArea("", 1, 1, 1);
		private TextField sendBox = new TextField("");
		private TextField nameBox = new TextField();
		private TextField roomBox = new TextField("0");

		// 방에 접속한 인원의 수를 보여주는 레이블
		private Label pInfo = new Label("대기실:  명");

		private java.awt.List pList = new java.awt.List();
		private Button startButton = new Button("대국 시작");
		private Button stopButton = new Button("기권");

		// 각종 정보를 보여주는 레이블
		private Label infoView = new Label("<JAVA>", 1);

		private OmokBoard board = new OmokBoard(15, 30);
		private BufferedReader reader;
		private PrintWriter writer;
		private Socket socket;
		private int roomNumber = -1;
		private String userName = null;

		public OmokClient(String title) {
			super(title);
			setLayout(null);

			// 각종 컴포넌트를 생성하고 배치한다.
			msgView.setEditable(false);
			infoView.setBounds(10, 30, 480, 30);
			infoView.setBackground(new Color(200, 200, 255));
			board.setLocation(10, 70);
			add(infoView);
			add(board);
			Panel p = new Panel();
			p.setBackground(new Color(200, 255, 255));
			p.setLayout(new GridLayout(3, 3));
			p.add(new Label("이     름:", 2));
			p.add(nameBox);
			p.add(new Label("방 번호:", 2));
			p.add(roomBox);
			p.setBounds(500, 30, 250, 70);

			Panel p2 = new Panel();
			p2.setBackground(new Color(255, 255, 100));
			p2.setLayout(new BorderLayout());
			Panel p2_1 = new Panel();
			p2_1.add(startButton);
			p2_1.add(stopButton);
			p2.add(pInfo, "North");
			p2.add(pList, "Center");
			p2.add(p2_1, "South");
			startButton.setEnabled(false);
			stopButton.setEnabled(false);
			p2.setBounds(500, 110, 250, 180);

			Panel p3 = new Panel();
			p3.setLayout(new BorderLayout());
			p3.add(msgView, "Center");
			p3.add(sendBox, "South");
			p3.setBounds(500, 300, 250, 250);

			add(p);
			add(p2);
			add(p3);

			sendBox.addActionListener(this);
			startButton.addActionListener(this);
			stopButton.addActionListener(this);

			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent we) {
					System.exit(0);
				}
			});
		}

		public void actionPerformed(ActionEvent ae) {
			if (ae.getSource() == sendBox) {
				String msg = sendBox.getText();
				if (msg.length() == 0)
					return;
				if (msg.length() >= 30)
					msg = msg.substring(0, 30);
				try {
					writer.println("[MSG]" + msg);
					sendBox.setText("");
				} catch (Exception ie) {
				}
			} else if (ae.getSource() == startButton) {
				try {
					writer.println("[START]");
					infoView.setText("상대의 결정을 기다립니다.");
					startButton.setEnabled(false);
				} catch (Exception e) {
				}
			}

			else if (ae.getSource() == stopButton) {
				try {
					writer.println("[DROPGAME]");
					endGame("기권하였습니다.");
				} catch (Exception e) {
				}
			}
		}

		private void goToWaitRoom() {
			// TODO Auto-generated method stub

		}

		public void run() {
			String msg;
			try {
				while ((msg = reader.readLine()) != null) {

					if (msg.startsWith("[STONE]")) {
						String temp = msg.substring(7);
						int x = Integer.parseInt(temp.substring(0, temp.indexOf(" ")));
						int y = Integer.parseInt(temp.substring(temp.indexOf(" ") + 1));
						board.putOpponent(x, y);
						board.setEnable(true);
					}

					else if (msg.startsWith("[COLOR]")) {
						String color = msg.substring(7);
						board.startGame(color);
						if (color.equals("BLACK"))
							infoView.setText("흑돌을 잡았습니다.");
						else
							infoView.setText("백돌을 잡았습니다.");
						stopButton.setEnabled(true);
					}

					else if (msg.startsWith("[DROPGAME]"))
						endGame("상대가 기권하였습니다.");

					else if (msg.startsWith("[WIN]"))
						endGame("이겼습니다.");

					else if (msg.startsWith("[LOSE]"))
						endGame("졌습니다.");

					else
						msgView.append(msg + "\n");
				}
			} catch (IOException ie) {
				msgView.append(ie + "\n");
			}
			msgView.append("접속이 끊겼습니다.");
		}

		private void endGame(String msg) {
			infoView.setText(msg);
			startButton.setEnabled(false);
			stopButton.setEnabled(false);

			try {
				Thread.sleep(2000);
			} catch (Exception e) {
			}

			if (board.isRunning())
				board.stopGame();
			if (pList.getItemCount() == 2)
				startButton.setEnabled(true);
		}

		private void nameList(String msg) {
			pList.removeAll();
			StringTokenizer st = new StringTokenizer(msg, "\t");
			while (st.hasMoreElements())
				pList.add(st.nextToken());
			playersInfo();
		}

		private void playersInfo() {
		}

		private void connect() {
			try {
				msgView.append("서버에 연결을 요청합니다.\n");
				socket = new Socket("127.0.0.1", 7777);
				msgView.append("---연결 성공--.\n");
				msgView.append("이름을 입력하고 대기실로 입장하세요.\n");
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				writer = new PrintWriter(socket.getOutputStream(), true);
				new Thread(this).start();
				board.setWriter(writer);
			} catch (Exception e) {
				msgView.append(e + "\n\n연결 실패..\n");
			}
		}

		public void main(String[] args) {
			OmokClient client = new OmokClient("네트워크 오목 게임");
			client.setSize(760, 560);
			client.setVisible(true);
			client.connect();
		}
	}
}