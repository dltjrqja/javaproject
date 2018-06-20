import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import org.omg.CORBA.portable.InputStream;

public class SocketTest {
	public static void main(String[] args) throws IOException {
		try (Socket s = new Socket("time-c.nist.gov", 13)) {
			java.io.InputStream inStream =  s.getInputStream();
			Scanner in = new Scanner(inStream);
			while (in.hasNextLine()) {
				String line = in.nextLine();
				System.out.println(line);
			}
		}
	} 
}