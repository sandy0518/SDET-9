package genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyFileUtility {
	public String readDataFromPropertyFile(String key) throws Throwable {
		FileInputStream fis=new FileInputStream("./CommonData/commondata.properties");
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
}
