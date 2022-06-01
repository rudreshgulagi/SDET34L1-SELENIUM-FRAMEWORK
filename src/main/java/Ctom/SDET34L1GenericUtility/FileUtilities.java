
package Ctom.SDET34L1GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * This class contains only property file specific common methods
 * @author rudresh
 *
 */
public class FileUtilities {
static Properties property;
/**
 * This method is used to open the propertyfile
 * @throws IOException
 */

public static void openPropertyFile(String filepath) throws IOException {
	FileInputStream fis=new FileInputStream(filepath);
	property=new Properties();
	property.load(fis);
}
/**
 * 
 * @param key
 * @return
 */
public static String getDataFromPropertyFile(String key) {
	String value=property.getProperty(key);
	return value;
//hiiii	
}

}
