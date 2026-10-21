package P15_DataProvidersViaFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Notepad_ReadWrite {

	public static void main(String[] args) throws FileNotFoundException, IOException  {
	File fread = new File(new File(System.getProperty("user.dir")).getParent()+"\\TestData\\ReadNotepadData.txt");	

	Properties p1 = new Properties();
	p1.load(new FileInputStream(fread));
	
	//1.  Read Note Pad Data
    String getname = p1.getProperty("Name");
    String getemail = p1.getProperty("Email");
    System.out.println("Username: " + getname);
    System.out.println("Useremail: " + getemail);
    System.out.println("Usergender: " + p1.getProperty("Gender"));
    System.out.println("Userage: " + p1.getProperty("Age"));
    System.out.println("Data readed successfully!");
   
    //2.  Write Note Pad Data
	File fwrite = new File(new File(System.getProperty("user.dir")).getParent()+"\\TestData\\WriteNotepadData.txt");	
    FileOutputStream fos = new FileOutputStream(fwrite);
	Properties p2 = new Properties();

    
	p2.setProperty("Address", "Central Police Line");
	p2.setProperty("Mobno", "9898958969");
	p2.setProperty("City", "Gwalior");
	p2.setProperty("Pin", "211011");

	// store the file into local system
	p2.store(fos, "Testdata");
	System.out.println("Data written successfully!");


	}

}
