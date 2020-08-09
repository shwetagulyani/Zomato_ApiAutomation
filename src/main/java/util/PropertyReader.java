package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

public class PropertyReader {
	
		public static String fileload(String input) throws IOException, URISyntaxException {
			File f = new File(PropertyReader.class.getClassLoader().getResource("Url.properties").toURI()); 
			FileInputStream fi = new FileInputStream(f); 
			Properties pr = new Properties();
			pr.load(fi);
			String output = pr.getProperty(input);  
			return output;
		}

	}
