package days06;

import java.util.Scanner;

public class Array01 {

	public static void main(String[] args) {
		
//		배열
//		동일한 변수이름에 번호(첨자)를 붙여서 다수개의 데이터를 효과적으로 한번에 저장 
//		& 다를 수 있게 하는 저장구조(사용 형태가 약간 다른 다수개의 변수)
//		1. 다수개의 변수를 같은 이름으로 손쉽게 선언하여 사용가능
//		2. 하나의 이름으로 다수개의 변수들을 제어할 수 있음
		
//		배열의 생성방법
//		자료형 [] 배열변수명;
//		int a; //정수형 변수선언;
		int [] a; //정수형 배열선언
		
//		a는 일반 정수형 변수와는 다른 참조(reference)변수임
//		참조변수는 메모리(주기억장치:RAM)내부의 공간 중 HEAP이라는 영역 안에 
//		실제데이터가 저장된 곳을 지정하고 그곳을 위치정보를 저장하는 변수
		
//		reference값=참조값=주소값=어드레스값
//		참조변수(reference변수)는 위 네개의 이름이 지칭하는 그 하나의 값을 저장하는 변수
//		a=123; // 에러 a변수는 정수를 저장하는 변수가 아니고, 
//		정수가 지정된 곳의 주소를 저장하는 변수이기 때문에 일반 정수를 넣으려고 하면 에러 발생
//		
//		현재는 배열에 정수를 몇 개 저장할 수 있는지 개수와 메모리가 정해지지 않았음
//		배열을 사용하기 전에 저장할 수 있는 개수와 메모리 주소를 반드시 정해놓고 사용함
		a = new int[3]; // Heap영역에 정수 세개를 저장할 공간을 마련하고, 그 시작주소를 a변수에 저장
//		세개의 정수가 저장될 공간은 주기억장치상에 연속공간으로 마련됨
//		new 연산자 : 동적인 메모리를 생성하는 연산자
//						  프로그램의 구동 중에 HEAP 메모리에 공간을 생성하는 연산자로 생성된 메모리의 참조(주소)값을 반환전달함
		Scanner sc = new Scanner(System.in);
//		//Scanner 자료형의 공간만큼 Heap 마련하고 그 주소를 sc 변수에 저장
//		
//		둘을 합쳐서
		int []b = new int[3];
//		으로 선언하기도 함.
//		
//		배열의 각 공간에 값을 대입하는 벙법
//		인덱스(첨자) 연산 사용
//		배열의 인덱스 : 시작은0. 종료는 배열의 크기 =1
		a[0] =100; //배열의 1번째 요소에 값을 대입
		a[1] =200; //배열의 2번째 요소에 값을 대입
		a[2] =300; //배열의 3번째 요소에 값을 대입
		
		int i=0;
		b[i]=400;
		
//		int kor1, kor2, kor3
//		kori= 98; // XXX
		
		i=1;
		b[i]=500;
		b[i+1]=600;
		
		System.out.printf("a[0] = %d\n", a[0]);
		System.out.printf("a[1] = %d\n", a[1]);
		System.out.printf("a[2] = %d\n", a[2]);
		System.out.printf("b[0] = %d\n", b[0]);
		System.out.printf("b[1] = %d\n", b[1]);
		System.out.printf("b[2] = %d\n", b[2]);
		
		
		
		
		
	}

}
