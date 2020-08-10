package util;

import java.io.*;
import java.net.URISyntaxException;
import au.com.bytecode.opencsv.CSVReader;
import java.util.*;

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
