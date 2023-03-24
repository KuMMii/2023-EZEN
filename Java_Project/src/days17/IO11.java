package days17;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class IO11 {

	public static void main(String[] args) throws IOException {
		//abc.txt 파일의 내용을 읽어와서 콘솔창에 출력하기
		
		File dir = new File("D:\\JAVA01\\Jave_se\\temp");
		if(!dir.exists()) dir.mkdirs();
		
		File abc = new File(dir, "abc.txt");
		FileReader fisText = new FileReader(abc);
		
		int dataText;
		while((dataText =fisText.read())!= -1) {
			System.out.print((char)dataText);
		}
		fisText.close();
			
	}

}
