package days17;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IO14 {

	public static void main(String[] args) throws IOException {

		//"D:\\JAVA01\\Java_se\\temp"폴더 안의 "eclipse-inst-jre-win64.exe"파일을
		//"D:\\JAVA01\\Java_se\\copy"폴더로 복사
		//이진 형식으로 읽어 바로 써넣는 방식
		//BufferedInputStream 	BufferedOutputStream
		
		File originalDir = new File("D:\\JAVA01\\Java_se\\temp");
		File copyDir = new File("D:\\JAVA01\\Java_se\\copy");
		if(!copyDir.exists()) copyDir.mkdirs();
		
		File fileOriginal = new File(originalDir, "eclipse-inst-jre-win64.exe");
		File fileCopy = new File(copyDir, "eclipse-inst-jre-win64.exe");
		
		BufferedInputStream bis= new BufferedInputStream(new FileInputStream(fileOriginal));
		BufferedOutputStream bos= new BufferedOutputStream(new FileOutputStream(fileCopy));
		
//		int input;
//		while((input = bis.read())!= -1)
//			bos.write(input);
//		
		byte[] data = new byte[1024];
		int size; //맨 마지막 입력은 1kb가 안될 수 있으니 size를 사용해 입력받은 만큼의 출력을 실행
		while((size= bis.read(data))!=-1) bos.write(data, 0 , size);
		
		bis.close();
		bos.close();
		
	}

}
