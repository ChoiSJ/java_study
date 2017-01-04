package xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class BookParser {
	
	public static void main(String[] args) throws Exception {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document doc = builder.parse(new File("src/book.xml"));
		
		String value1 = doc.getElementsByTagName("title").item(0).getTextContent();
		String value2 = doc.getElementsByTagName("author").item(0).getTextContent();
		String value3 = doc.getElementsByTagName("price").item(0).getTextContent();
		
		System.out.println(value1);
		System.out.println(value2);
		System.out.println(value3);
	}
}
