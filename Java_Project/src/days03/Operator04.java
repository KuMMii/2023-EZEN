package days03;

public class Operator04 {

	public static void main(String[] args) {
		// 논리연산자 &&(AND), ||(OR), !(NOT)
		// 다수개의 관계(비교)연산식 결과 (true/false)값 또는 boolean 값은 연산해 하나의 boolean값을 결과로 얻는 연산
		// 피연산자 : boolean, 연산의 결과 : boolean
		
		// && : 두 항이 모두 true이어야 결과가 true, 둘 중 하나가 false이면 결과는 false
		// || : 두 항이 모두 false이어야 결과가 false, 둘 중 하나가 true이면 결과는 true
		// ! : 단항연산 - 피연산자의 true/false 값을 반대로 바꾸는 연산
		
		boolean b1;
		b1 = true && false;
		System.out.printf("%b && %b -> %b\n", true, false, b1);
		
		int a = 80;
		boolean b2 = a >50;
		boolean b3 = a <=100;
		
		b1 = b2 && b3;
		System.out.printf("b2 && b3 -> %b\n", b1);
		b1 = (a>50) && (a<=100); //간편하게 이렇게 많이 씀
		//50<a<=100 절대 불가
		System.out.println("a>50 이면서 a<=100 : " +b1);
		
		// a 변수의 값이 70보다 크거나 40보다 작으면 true, 아님 false 출력
		a = 50;
		b1=(a>70) || (a<40);
		System.out.println("a<70 이거나 a<40 : " +b1);
		
		// AND 연산자 (&&)
		// 좌항과 우항의 관계(비교)식 결과 또는 boolean 값이 모두 true인 경우 결과값
		// 좌항과 우항 중 하나라도 false인 경우 false 결과값
		//좌향의 비교연산 결과가 false인 경우 우항의 식을 비교x
		System.out.printf("F&&F = %b\n", false && false);
		System.out.printf("F&&F = %b\n", true &&false);
		System.out.printf("F&&F = %b\n", false &&true);
		System.out.printf("T&&T = %b\n", true && true);
		
		// OR 연산자 (||)
		// 좌항과 우항의 관계(비교)식 결과 또는 boolean 값이 하나라도 결과가 true인 경우 true가 결과
		// 좌항과 우항 모두 false인 경우 false가  결과
		//좌향의 결과가 false인 경우 우항의 식을 비교x
		System.out.printf("F||F = %b\n", false || false);
		System.out.printf("F||F = %b\n", true || false);
		System.out.printf("F||F = %b\n", false ||true);
		System.out.printf("T&&T = %b\n", true || true);
		
		// NOT 연산자 (!)
		// 단항연산자, 피연산자의 논리값을 결과로 냄 false->true true->false
		b1=false;
		System.out.printf("Not(!)%b = %b\n", b1, !b1);
		System.out.printf("Not(!)%b = %b\n",true, true);

		// 점수가 80점 이상이면서 90 이하이면 true, 아니면 false
		int num = 85;
		boolean result = (num>=80) &&(num<=90);
		System.out.printf("result = %b\n", result);
		
		num = 150;
		result = (num>=100) &&(num<=50);
		System.out.printf("100이상 또는 50 미만 result = %b\n", result);
		
		int kor=35, eng=98, mat=95;
		double avg;
		avg = (kor+eng+mat)/3.0;
		System.out.println(avg);
		boolean r1 = (avg>=80 &&(eng>=75 && kor>=80));
		System.out.printf("평균 80이상 && 영어 75이상이고 국어 80이상 = %b\n", r1);
		boolean r2 = (kor>=50 && eng >= 60 && mat >=70);
		System.out.printf("국어 50이상 && 영어 60이상 && 수학 70이상 = %b\n", r2);
		boolean r3 = (kor<40 || eng<40 || mat<40);
		// result = !( (kor>=40)&&(eng>=40)&&(mat>=40)); 도 가능
		System.out.printf("한 과목이라도 40 미만인가? : %b\n", r3);
		
		r1 = (avg>=60) && (kor >=40)&& (eng >=40) && (mat>=40);
		System.out.printf("평균 60이상, 모든 과목 40 이상인가? : %b\n", r1);
		r2 = (avg<60)|| !((kor>=40)&&(eng>=40)&&(mat>=40));
		System.out.printf("평균 60미만이거나, 한 과목이라도 40 미만인가? : %b\n", r2);
		r3 = (avg>=70)||((eng>=80)&&(mat>=80));
		System.out.printf("평균 70이상이거나, 영어와 수학이 모두 80이상인가? : %b\n", r3);
		
//		국어점수가 짝수라면 true, 홀수라면 false
//		int n = kor%2;
//		r1 = n==0;
		r2 = (kor%2)==0;
		System.out.printf("국어점수가 짝수인가? : &b\n", r2);
//		연산의 우선순위
//		1. ()괄호
//		2. 피연산자 앞에 있는 ++, --
//		3. 곱셈, 나눗셈 , 나머지
//		4. 덧셈, 뺄셈
//		5. 관계연산
//		6. 논리연산
//		7. =
		
//		year변수에 저장된 년도가 윤년이면 true, 평년이면 false를 출력
		int year1 = 2020, year2= 2022;
//		윤년의 조건
//		해당 년도가 4의 배수이면서, 100의 배수가 아니거나, 400의 배수인 해
		int x = year1%4;
		int y = year1%100;
		int z = year1 % 400;
		result = (x==0) || (y!=0)&&(z==0);
		System.out.println("2020년은 윤년? : "+result);
		
		result = (year2%4==0)&&(year2%100 !=0)||(year2%400==0);
//		result = (year2%4==0)&&!(year2%100 ==0)||(year2%400==0);
		System.out.println("2022년은 윤년? : "+result);
				
		
		
		
		
		
		
	}

}
