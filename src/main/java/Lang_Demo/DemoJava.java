package Lang_Demo;

import java.io.File;

/**
 * Hello world!
 *
 */
public class DemoJava
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    	String path = new File(System.getProperty("user.dir")).getParent();
    	System.out.println(path+"\\TestData\\FakeTestData.xlsx");
    }
}
