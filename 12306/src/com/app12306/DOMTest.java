package com.app12306;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class DOMTest {

	public static void main(String[] args) {
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/xiaojf/Desktop/ExtNameMime.txt")));
			File f = new File("/Users/xiaojf/Desktop/web.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(f);
			NodeList nl = doc.getElementsByTagName("mime-mapping");
			for (int i = 0; i < nl.getLength(); i++) {
				String str = 
				 doc.getElementsByTagName("extension").item(i).getFirstChild().getNodeValue() + " " +
				 doc.getElementsByTagName("mime-type").item(i).getFirstChild().getNodeValue();
				bw.write(str+"\r\n");
			}
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
