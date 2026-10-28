package RS12_SerializationVsDeserialization;

import java.util.Arrays;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/*DeSerialization: converting JSON or XML response data from an API into a 
 *                 Java object.
 *  Json ----> POJO    
 *  Pkg name : fasterxml.jackson.databind.ObjectMapper;
*/
public class DeSerializationDemo {

	@Test
	public void ConvertJsonToPOJO() throws JsonMappingException, JsonProcessingException
	{
	String jsondata = "{\r\n"
			+ "  \"sname\" : \"Tannu Bhadoriya\",\r\n"
			+ "  \"semail\" : \"bhadoriyatannu123@gmail.com\",\r\n"
			+ "  \"address\" : \"Gwalior Madhya Pradesh\",\r\n"
			+ "  \"courses\" : [ \"B.A\", \"M.A\", \"B.Com\", \"M.Com\" ]\r\n"
			+ "}";
	
	// Convert Json data ----> Pojo Object
	 ObjectMapper om = new ObjectMapper();
	 POJODemo pd = om.readValue(jsondata, POJODemo.class);
	 System.out.println("Sname: "+pd.getSname());
	 System.out.println("Semail: "+pd.getSemail());
	 System.out.println("Saddress: "+pd.getAddress());
	 System.out.println("Scouses: "+Arrays.toString(pd.getCourses()));	
    }
}