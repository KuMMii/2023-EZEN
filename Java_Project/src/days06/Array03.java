package days06;

public class Array03 {

	public static void main(String[] args) {
//		배열 변수의 활용 - 배열과 반복문
//		배열은 하나의 변수명을 가지며, 변수명과 인덱스를 조합하여 각 요소에 접근할 수 있음. 
//		일반적으로 for 반복문의 기준변수를 사용해 배열의 인덱스를 제어하는 방식으로 
//		배열의 각 요소에 접근하는 방식 활용됨
		
		int [] a= new int[100];
		a[0] = 1;
		a[1] = 2;
		a[2] = 3;
		a[3] = 4;
		a[4] = 5;
		a[5] = 6;
		a[6] = 7;
		a[7] = 8;
		a[8] = 9;
		a[9] = 10;
		//반복실행을 사용하지 않고 배열의 요소들에 값을 저장
		// 배열의 요소가 많을수록 값이 대입하는 동작이 힘들어짐
		
//		배열과 반복문을 활용해 값을 초기화하는 코드 - i변수의 값이 0~99까지 실행
		for(int i=0; i<100; i++) {
			a[i]=i+1;
		}
		
		for(int i=0; i<=100; i++) {
			System.out.printf("%d ", a[i]);
		}
		
		
		
		
	}

}