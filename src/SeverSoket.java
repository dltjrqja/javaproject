import java.io.IOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.sql.Date;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SeverSoket {
	public static void main1(String[] args) throws IOException {
		Socket s = new Socket("localhost", 9100);
		BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String res = input.readLine();
		System.out.println(res);
		System.exit(0);
	}

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(9100);
		try {
			while (true) {
				Socket socket = ss.accept();
				try {
					PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
					out.println(new Date(0).toString());
				} finally {
					socket.close();
				}
			}
		} finally {
			ss.close();
		}

	}

}
