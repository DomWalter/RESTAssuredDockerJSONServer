package firstPackage;

import java.util.Random;

public class InputData {

    public static String AddPost(){

        Random r = new Random();
		int low = 0;
		int hi = 200;
		int result = r.nextInt(hi-low) + low;
		
		 String payload = "{\n" +
		        "  \"id\": \"Some id "+result+"\",\n" +
		        "  \"title\": \"test 1\",\n" +
		        "  \"author\": \"test author\"\n" +
                "}";
                
        return (payload);

    }


    
}