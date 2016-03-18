import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * About: This class is to run the python file and get its result. 
 * I created this class learning from online resources
 * IMPORTANT: If you want to run this program on your personal computer, 
 * you need to change the path to where you save the python file
 */
public class Run_python {
	  String img_array_str;
	   public Run_python(String img_array_str) {
	    	this.img_array_str = img_array_str;
	   }
	   public String run(){
	        String s = null;
	 
	        try {	             
	            // Using terminal to run python file 
	            Process p = Runtime.getRuntime().exec("python /Users/liuxiyun/Dropbox/handwritten_recognition.py "+img_array_str);
	             
	            BufferedReader Input = new BufferedReader(new
	                 InputStreamReader(p.getInputStream()));
	            BufferedReader Error = new BufferedReader(new
	                 InputStreamReader(p.getErrorStream()));
	 
	            // read the output from the command
	            while ((s = Input.readLine()) != null) {
	                return s;
	            }
	             
	            // read any errors from the attempted command
	            System.out.println("Error of the command (if any):\n");
	            while ((s = Error.readLine()) != null) {
	                System.out.println(s);
	            }
	             
	            System.exit(0);
	        }
	        catch (IOException e) {
	            System.out.println("exception happened - here's what I know: ");
	            e.printStackTrace();
	            System.exit(-1);
	        }
	        return "EXIT FINALLY";
	    }
}
