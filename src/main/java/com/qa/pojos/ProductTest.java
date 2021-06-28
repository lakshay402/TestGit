package com.qa.pojos;

import org.apache.juneau.html.HtmlSerializer;
import org.apache.juneau.json.JsonParser;
import org.apache.juneau.json.JsonSerializer;
import org.apache.juneau.parser.ParseException;
import org.apache.juneau.serializer.SerializeException;
import org.apache.juneau.xml.XmlSerializer;

public class ProductTest {

	public static void main(String args[]) throws SerializeException, ParseException {
		
		//Serialization
		
		System.out.println("----------------Example of Serialization-------------------");
		//pojo to json
		
		JsonSerializer jsonSerializer = JsonSerializer.DEFAULT_READABLE;
		
		String sellerName[] = {"ABC software", "Neon Enterprise", "XYZ IT solutions"};
		
		Product product = new Product("macPro", 1000, "White", sellerName);
		
		String json = jsonSerializer.serialize(product);
		
		System.out.println(json);
	
		System.out.println("----------------------------------------------------------------");
	
		//pojo to XML
		
		XmlSerializer xmlSerializer = XmlSerializer.DEFAULT_NS_SQ_READABLE;
		
		String xml=xmlSerializer.serialize(product);
	
		System.out.println(xml);
		
		System.out.println("----------------------------------------------------------------");
		
		//pojo to HTML
		
		HtmlSerializer htmlSerializer = HtmlSerializer.DEFAULT_SQ_READABLE;
		String html = htmlSerializer.serialize(product);
		
		System.out.println(html);
		
		
		
	//DeSerialization
		
		System.out.println("----------------Example of Deserialization-------------------");
		
		//JSON to POJO:
		JsonParser jsonParser = JsonParser.DEFAULT;
		
		String jsonVal = "{\r\n"
				+ "	\"color\": \"White\",\r\n"
				+ "	\"name\": \"macPro\",\r\n"
				+ "	\"price\": 1000,\r\n"
				+ "	\"sellerName\": [\r\n"
				+ "		\"ABC software\",\r\n"
				+ "		\"Neon Enterprise\",\r\n"
				+ "		\"XYZ IT solutions\"\r\n"
				+ "	]\r\n"
				+ "}";
		
		Product pro = jsonParser.parse(jsonVal, Product.class);
		
		System.out.println(pro.getColor());
		System.out.println(pro);
		
	}
	
}
