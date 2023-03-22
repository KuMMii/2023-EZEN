package days06;

import java.util.Scanner;

public class ControllOp_LoopEx {

	public static void main(String[] args) {
		
		// 컴퓨터가 사용자에게 알려주지 않은 0~200 사이의 값을 변수에 저장합니다.
		// 사용자에게 컴퓨터가 저장하고 있을 숫자를 예측해서 입력하도록 합니다.
		// 입력된 숫자와 컴퓨터가 기억된 숫자를 비교해서 일치하면 게임 종료
		// 불일치면 그 수치를 비교해서 UP 또는 DOWN을 출력하고 다시 입력합니다.
		// 숫자를 맞추면 다시 물어봅니다. "다른 게임을 하시겠습니까?(Y:1/N:2)"
		// 계속한다고 하면 맨 위 컴퓨터가 숫자를 다시 결정하는 곳 부터 반복합니다.
		// 게임 중간에라도 종료하고자 한다면 0을 입력해서 종료가능
		Scanner sc = new Scanner(System.in);
		int user;
		int num2;
		do {
		com =(int)(Math.random()*200)+1;
//		System.out.println(com);
			do {
				System.out.printf("숫자를 입력하세요(0을 입력하면 종료됩니다) : ");
				user=sc.nextInt();
				if(user==0) {
				System.out.println("프로그램이 사용자 요청에 의해 종료되었습니다");
				return;		//이부분이 어려웠음!
				}
				if(com>user) System.out.println("UP");
				else if(com<user) System.out.println("DOWN");
				else System.out.println("정답입니다.");
	
			}while((com!=user)); {
				System.out.println("다른 게임을 하시겠습니까?(Y:1/N:2) : ");
				num2=sc.nextInt();
			}
		}while((num2==1));
			System.out.println("게임을 종료합니다.");
	}

}
