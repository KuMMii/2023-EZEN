package days03;

public class Operator05 {

	public static void main(String[] args) {
		
//		자료의 형변환 연산 & 캐스팅 연산
//		
//		캐스팅 연산 : 서로 호환이 가능한 자료끼리 자료의 형변환을 하려고 할 때 사용
//		작은 용량의 자료값을 큰 용량의 변수에 넣는 것은 아무 조치 없이 가능함
//		반대의 경우는 캐스팅 연산이 필요
		
//		정수들간의 캐스팅
		byte b1 = 10;
		// 큰용량(int) 값을 작은 용량(byte) 변수에 넣으면 에러가 발생해야 하지만
		// 변수값이 아닌 순수 정수자료는 캐스팅없이 입력 가능.
		int a = 10;
//		b1 = a; // 이건 에러-변수값을 넣었기 때문
		b1 = (byte)a; //용량이 큰 변수를 작은 변수에 넣을 때 캐스팅 연산 필요
		
		byte b2 = 30;
//		byte b3 = b1 + b2; //에러남
		//정수(int, byte, short)들의 산술연산의 결과는 int이기 때문에 위의 연산은 에러
		byte b3 = (byte)(b1+b2); //이렇게 변환해줘야함
		
		
//		실수들 간의 캐스팅
//		float f1 = 123.123; //에러. 별도의 표시없는 실수는 double
		float f1 = 123.123f;
		
		double d1 = 123.123;
//		f1 = d1; //에러
		f1 = (float)d1;
		d1= f1; //큰 용량 변수에 작은 용량 변수값을 넣는 건 캐스팅없이 가능
		
		
//		실수 -> 정수,		정수->실수 서로 호환성이 존재하는 자료끼리 캐스팅 가능
//		실수 -> 정수
		double d2 = 1.23456;
		int a = (int)d2; // a 변수에 1 저장
//		정수 -> 실수
		double d3 = (double)a; // d3 변수에 1.0 저장
		
//		문자 -> 정수
		char c = 'A';
		a = (int)c; //char'A'에 해당하는 아스키코드 65 저장
//		정수 -> 문자
		a =97;
		c = (char)a;//97 아스키코드에 해당하는 'a'글자 저장
		
//		String -> int
		// 잘못된 예
		String s1 = "12345";
//		int a4 = (int)s1; //에러
		int a5 = 123456;
//		String s2= (String)a5; //에러
		
		// 올바른 예
//		호환성이 없어서 캐스팅 연산이 안되는 자료들 간에는 메서드 사용
		String s4 ="12345";
		int a4 = Integer.parseInt(s4); //String->int
		int a6 = 123456;
		String s5 = String.valueOf( a6); // int->String
		
//		double -> String
		double d3 = 123.1234;
//		String s3 = (String)d3;//에러
		String s3 = String.valueOf(d3); //정상실행
		
//		String -> double
		String s4 = "123.456";
//		double d4 = (double) s4; //에러
		double d4 = Double.parseDouble(s4); //정상실행

		
		
		
		
		
		
	}

}
