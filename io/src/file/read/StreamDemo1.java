package file.read;

import java.net.URL;
import java.io.FileOutputStream;
import java.io.InputStream;

public class StreamDemo1 {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://www.cnn.co.jp/storage/2016/12/07/c5efaa0d9ed2f45b7d2c9c42e6da8aaa/seaworld-florida.jpg");
		
		InputStream is = url.openStream();
		FileOutputStream fos = new FileOutputStream("a.jpg");
		
		int count = 0;
		byte[] buf = new byte[1024*8];
		while ((count=is.read(buf)) != -1) {
			fos.write(buf, 0, count);
		}
		
		fos.close();
	}
}
