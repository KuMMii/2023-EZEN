package days17;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class IO12 {

	public static void main(String[] args) throws IOException {

		File d = new File("D:\\JAVA01\\Java_se\\temp");
		if(!d.exists()) d.mkdirs();
		
		File file_binary = new File(d, "binary_data_using_buffer.dat");
		File file_text = new File(d, "text_data_using_buffer.txt");
		
		//버퍼를 이용한 이진데이터 출력을 위한 객체 생성
		FileOutputStream fos = new FileOutputStream(file_binary);
		BufferedOutputStream bosBinary = new BufferedOutputStream(fos);
		
		//버퍼를 이용한 문자 데이터를 출력할 수 있는 객체 생성
		BufferedWriter bwText = new BufferedWriter(new FileWriter(file_text));
		
		//버퍼에 내용을 출력
		//버퍼에 출력된 데이터는 해당 스트림이 close되거나 해당 스트림 객체에 대해서  flush 메서드가 호출되면 실제 스트림을 통해 출력됨
		bosBinary.write(255);
		bosBinary.write(22);
		//flush 메소드는 버퍼에 쌓여있는 데이터를 출력하는 메소드(버퍼를 비우는 명령을 실행)
		bosBinary.flush();
		
		bwText.write("Hello");
		bwText.write("World~!");
		//flush 메소드는 버퍼에 쌓여있는 데이터를 출력하는 메소드(버퍼를 비우는 명령을 실행)
		bwText.flush();
		
		bosBinary.close();
		bwText.close();
		
		
		
	}

}
