package P14_HandleFileActions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Notepad_Read_Write {

	public static void main(String[] args) throws FileNotFoundException, IOException  {
	File f = new File("E:\\My Files\\abc.txt");
	Properties p = new Properties();
	p.load(new FileInputStream(f));
    String t1 = p.getProperty("Name");
    String t2= p.getProperty("Age");
    System.out.println(t1);
    System.out.println(t2);
    FileOutputStream fis = new FileOutputStream("C:\\Users\\ASTR-35\\Documents\\abc.txt");
	// create Properties class object to access properties file

	p.setProperty("Selenium", "https://chercher.tech");
	p.setProperty("Google", "https://google.com");
	p.setProperty("Yahoo", "https://yahoo.com");
	// store the file into local system
	p.store(fis, null);


	}

}
