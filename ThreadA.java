import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ThreadA implements Runnable{/*ThreadA is I/O intensive which is reading and writing 
	                                       from a file*/
	
	public void run(){
		for(int i=0;i<=1000000000;i++){
			try {
	            File inputFile = new File("C:/Users/DELL/Desktop/eclipse work/temp.txt");
	            File outputFile = new File("C:/Users/DELL/Desktop/eclipse work/temp.txt");

	            FileInputStream fis = new FileInputStream(inputFile);
	            FileOutputStream fos = new FileOutputStream(outputFile);
	            int c;

	            while ((c = fis.read()) != -1) {
	               fos.write(c);
	            }

	            fis.close();
	            fos.close();
	        } catch (FileNotFoundException e) {
	            System.err.println("FileStreamsTest: " + e);
	        } catch (IOException e) {
	            System.err.println("FileStreamsTest: " + e);
	        }
}
}
}
