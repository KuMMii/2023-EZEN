package days09;

// 멤버 메서드 : 클래스에 소속되어 클래스 객체에 종속된 메서드
// 멤버 메서드는 특별한 경우를 제외하곤 static을 사용하지 않음

class Animal{
	String name;
	int age;
	public void output() {
		
		System.out.println("저의 이름은 "+name+"나이는" +age+"입니다");
	}//멤버 메서드 : 메서드를 호출한 객체에 대해서 메서드 내의 코드들을 실행함
	//호출한 객체 : a1, a2 등 Animal 로 생성한 객체변수
	//output 내부의 name변수와 age는 명령 실행시에 호출한 객체의 name과 age로 귀속됨
	
	//클래스 모양대로 생성된 객체들은 클래스에서 물려받은 변수에 자신만의 값들을 넣고 멤버 메서드를 이용할 수 있다.
	public void input() {
		name="바둑이";
		age=7;
		// 이 메서드를 호출하는 객체는 모두가 똑같이 name변수가 바둑이, age가 7로 저장됨
	}
	public void inputWithParam(String n, int a) {
		name=n;
		age=a;
		output();
		//멤버메서드들 간에 서로간 자유로운 호출가능
		//물론 호출된 객체는 그대로 승계됨
	}
	//멤버메서드는 클래스형으로 생성된 객체 "전용" 메서드이다. 단독사용은 에러
//	메서드의 실행이 객ㄱ체전달용으로만 사용된다는 뜻
//	멤버메서드의 내용은 해당 객체와 상관없는 명령이 들어갈수도 있지만
//	보통은 멤버변수의 조직, 출력, 입력을 위한 명령어로 주로 구성됨
}
public class Class04 {

	public static void main(String[] args) {

		Animal a1=new Animal();
//		a1.name="댕댕이";
//				a1.age=5;
//				System.out.println("저의 이름은 "+a1.name+"나이는" +a1.age+"입니다");
		a1.input();
		a1.output();
		
		Animal a2=new Animal();
//		a2.name="냥냥이";
//				a2.age=6		;
//				System.out.println("저의 이름은 "+a2.name+"나이는" +a2.age+"입니다");
//		a2.input();
//		a2.output();
		a2.inputWithParam("냥냥이", 6);
	}
	
	Animal a3=new Animal();
	a3.inputWithParam("야옹이", 8);
	//위의 내용처럼 객체의 맴버변수에 값을 넣을 때는 직접 값을 넣는 것보다 메서드를 이용하는 경우가 많아질 예정
	//차후 만들어지는 클래스의 멤버변수는 클래스 외부에서 직접접근을 차단할 예정
	//반드시 멤버 메서드를 통해서만 접근이 가능할 예정
}
