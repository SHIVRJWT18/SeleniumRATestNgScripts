package RS12_SerializationVsDeserialization;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/*Serialization: converting a Java object into JSON or XML format to send data
                 to an API.
                 
 POJO ---> Json                 
*/
public class SerializationDemo {
	
 @Test
 public void convertPojoTOJson() throws JsonProcessingException
 {
	 // Created a Java Object(POJO Object)
	 POJODemo pd = new POJODemo();
	 pd.setSname("Rakesh Bhadoriya");
	 pd.setAddress("Ahemadabad Gujarat");
	 pd.setSemail("bhadoriyarakesh123@gmail.com");
	 pd.setCourses(new String[]{"B.A", "M.A", "B.Com", "M.Com"});
	 
	 //Convert Java to Json Object
	 ObjectMapper om = new ObjectMapper();
	 String jsondata = om.writerWithDefaultPrettyPrinter().writeValueAsString(pd);
     System.out.println("ConvertedJson: "+jsondata);
 
 }
 
	
	
	
	
	
	
	
}
