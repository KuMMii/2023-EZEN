package days17;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class IO13 {

	public static void main(String[] args) throws IOException {
		File d = new File("D:\\JAVA01\\Java_se\\temp");
		if(!d.exists()) d.mkdirs();
		
		File filebinary = new File(d, "binary_data_using_buffer.dat");
		File filetext = new File(d, "text_data_using_buffer.txt");
		
		FileInputStream fis= new FileInputStream(filebinary);
		BufferedInputStream bisBinary=new BufferedInputStream(fis);
		
		BufferedReader brText = new BufferedReader(new FileReader(filetext));
		
		int input;
		while((input = bisBinary.read())!= -1)
			System.out.printf("%d \n", input);
		
		System.out.println();
		while((input = brText.read())!= -1)
			System.out.printf("%c", input);
		
		bisBinary.close();
		brText.close();
		
		

	}

}
