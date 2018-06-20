import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;

import org.omg.CORBA.portable.InputStream;

public class DownloadImage {
	public static void main(String[] args) throws Exception {
		String website = "http://www.oracle.com/us/hp07-bg121314-openworld-2x2280475.jpg";
		System.out.println("" + website + "사이트에서 이미지를 다운로드합니다.");
		URL url = new URL(website);
		byte[] buffer = new byte[2048];
		try (InputStream in = (InputStream) url.openStream();
				OutputStream out = new FileOutputStream("test.jpg");) {
			int length = 0;
			while ((length = in.read(buffer)) != -1) {
				System.out.println("" + length + "바이트 만큼 읽었음!");
				out.write(buffer, 0, length);
			}
			in.close();
			out.close();
		} catch (Exception e) {
			System.out.println("예외: " + e.getMessage());
		}
	}
}