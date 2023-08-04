package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {
	public static String getValue = "";

	public static String getData(String val) {
		File file=new File("C:\\Users\\snehagupta01\\eclipse-workspace\\NAGP_sampleApplication\\src\\main\\java\\resources\\data.properties");
		FileInputStream fis=null;
		Properties prop=null;
		
		try {
		 fis = new FileInputStream(file);
		 prop= new Properties();
		 prop.load(fis);
			} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
			}
		catch (IOException e) {
			e.printStackTrace();
			}
		getValue=prop.getProperty(val);
		return getValue;
	}
	
	public static String getBaseData(String val) {
		File file=new File("C:\\Users\\snehagupta01\\eclipse-workspace\\NAGP_sampleApplication\\src\\main\\java\\resources\\config.properties");
		FileInputStream fis=null;
		Properties prop=null;
		
		try {
		 fis = new FileInputStream(file);
		 prop= new Properties();
		 prop.load(fis);
			} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
			}
		catch (IOException e) {
			e.printStackTrace();
			}
		getValue=prop.getProperty(val);
		return getValue;
	}

}
