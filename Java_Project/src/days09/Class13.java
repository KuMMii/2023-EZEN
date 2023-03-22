package days09;

//앞선 예제와 같이 클래스 내부에 생성자를 꺼내어 따로 정의하지 않으면, 
//컴파일러는 자동으로 클래스 내부에 숨어 있는 생성자(디폴트 생성자)를 호출함

//디폴트 생성자 : Bclass(){}와 같이 생겨서 기본 형태만 설정되고 매개변수가 없는 생성자
class Bclass{
	private int age;
//	Bclass(){	}// 디폴트 생성자
	// 내용이 아무것도 없는 디폴트 생성자는 따로 생성자를 꺼내지 않은 것과 동일함

// 생성자를 꺼내서 사용하는 경우는 필요한 명령을 넣어서 객체생성시 실행하게 하거나 
//	아래처럼 매개변수를 넣어서 별도의 관련 명령을 추가 기술할 때 꺼냄
	Bclass( int a ){
		age = a;
	} // 생성자도 리턴값만 없을 뿐, 메서드이므로 매개변수를 사용할 수 있음
}
public class Class13 {

	public static void main(String[] args) {
		//BClass b = new BClass();
		//별도의 생성자가 없으면, 컴파일러가 클래스 내부에 숨어있는 "디폴트생성자"를 호출함
		
		Bclass b1 = new Bclass(40);
		Bclass b2 = new Bclass(50);
		//생성자의 매개변수를 활용하는 경우 각각의 객체마다 서로 다른 값을 가질 수 있음
		
	}

}
