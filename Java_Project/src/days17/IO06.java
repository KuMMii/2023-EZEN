package days17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IO06 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//InputStreamReader a =new InputStreamReader(System.in);
		//BufferedReader b = new BuffereReader(a);
		
		String input;
		//BufferedReader 클래스의 객체를 사용해 String 타입 자료를 읽어 온 후 형변환을 시행
		System.out.print("Type an integer: ");
		input = br.readLine(); //비록 읽어내는 것을 String으로 읽어내지만 아래에서 정수변환을 사용함
		int num = Integer.parseInt(input);//입력된 문자열을 정수로 변환
		System.out.printf("Input Integer : %d\n", num);
		
		System.out.print("Type an Double: ");
		input = br.readLine(); 
		double d= Double.parseDouble(input);
		System.out.printf("Input Double : %.2f\n", d);
		
		System.out.print("Type an Character :");
		char ch = (char)br.read();
		System.out.printf("Input Character : %c\n", ch);
		br.close();
	}

}
