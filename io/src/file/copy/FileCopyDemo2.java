package file.copy;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.io.IOUtils;

public class FileCopyDemo2 {
	public static void main(String[] args) throws Exception {
		
		String path = "https://static1.squarespace.com/static/53692e71e4b06caf80245405/t/53699473e4b0cd9f3195e135/1399428212922/siteAboutS.jpg?format=1000w";
		
		URL url = new URL(path);
		InputStream is = url.openStream();
		FileOutputStream fos = new FileOutputStream("cuties.jpg");
		
		IOUtils.copy(is, fos);
	}
}
