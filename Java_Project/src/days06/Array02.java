package days06;

public class Array02 {

	public static void main(String[] args) {
		
//		배열의 선언과 저장 공간 생성 방법
//		1. 배열 변수의 선언 후, 실제 배열 공간을 할당 받는 방법
		int [] a1 = null;
//		null:아무것도 없다는 뜻의 값
		String s1 = null; //Heap에 공간확보가 되지 않은 상태
		String s2 = ""; // Heap에 공간이 확보되고 그 주소가 저장된 상태

		int [] b1; //null값도 넣지 않은 상태. 초기화되지 않은 상태. 초기화되지 않으면 사용을 못함
		System.out.println(a1);
//		System.out.println(b1); //에러. 초기화되지 않은 변수의 사용은 에러
//		변수에 null을 초기화한 것과 아무것도 초기화하지 않은 것은 다름.
//		null은 참조변수에다만 넣음
		a1 = new int[4];
		
//		2. 배열 변수의 선언과 배열의 생성을 동시에 진행
		int[]a2 = new int[4];
//		new에 의해서 HEAP메모리에 생성되는 모든 영역은 정수형 자료라면 0
//		실수형 자료라면 0.0, String 자료라면 null값으로 초기화됨
		System.out.println(a1[0]+" "+ a1[1] + " " + a1[2] + " " + a1[3]);
		System.out.println(a2[0]+" "+ a2[1] + " " + a2[2] + " " + a2[3]);
		double [] d = new double[4];  //모두 0.0으로 초기화
		String [] s = new String[4]; //모두 null로 초기화
		System.out.println(d[0]+" "+ d[1] + " " + d[2] + " " + d[3]);
		System.out.println(s[0]+" "+ s[1] + " " + s[2] + " " + s[3]); //String 자체가 이미 참조변수
		
		System.out.println("\n");
//		3. 배열을 생성하면서 임의의 값으로 초기화하는 방법
//		크기가 5인 배열을 생성하면서 , 각 요소의 값을 1,2,3,4,5로 초기화하는 코드
		int[] a3 = new int[ ] {5,4,3,2,1};
		System.out.println(a3[0]+" "+ a3[1] + " " + a3[2] + " " + a3[3] + " " + a3[4]);
		
		int[] a5 = {5,4,3,2,1};
		System.out.println(a5[0]+" "+ a5[1] + " " + a5[2] + " " + a5[3] + " " + a5[4]);
		
		a5[0]= 100;
		System.out.println(a5[0]+" "+ a5[1] + " " + a5[2] + " " + a5[3] + " " + a5[4]);
		
		4. 배열 변수 a7, a8 동시 선언하는 코드
		int [] a7,a8;
		a7= new int[3];
		a8= new int[3];
		
		5. 배열변수와 일반 변수를 동시에 선언 가능
		int a9 [], a10 [], a11;
		//배열변수(참조변수)는 변수 뒤에 대괄호 표시
		a9 = new int[3];
		a10= new int[3];
		a11 =10;
		
		
		
	}

}
