package days09;

import java.util.Scanner;

//멤버 메서드의역할은 은닉자료의 접근만 있는것이X
//멤버 자료의 유효한 값의 관리와 가공 및 권한 적용 및 제어 등을 담당함

class AccountWithPermission{
	private double balance;
	Scanner sc = new Scanner(System.in);
	
	public void initBalance(int money) {
		balance = money;
	}
	public void withdraw() {
		System.out.print("출금할 금액을 입력하세요 : ");
		int money = Integer.parseInt(sc.nextLine());
		System.out.print("비밀번호를 입력하세요 : ");
		String pass = sc.nextLine();
		if(!pass.equals("1234")) {
			System.out.println("비밀번호가 맞지 않습니다");
			return;
		}
		if(money>balance) {
			System.out.println("잔액이 부족합니다.");
			return;
		}
		balance -= money;
		System.out.println(money +"원 출금이 완료되었습니다");
	}
	public void display() {
		System.out.printf("현재 잔액은 %.2f원 입니다.\n", balance);
		
	}
	public void deposit(){
		System.out.print("입금할 금액을 입력하세요 : ");
		int money =Integer.parseInt(sc.nextLine());
		if(money<0)
			System.out.println("입금액 오류. 관리자에게 문의하세요");
		return; //void의 return은 되돌림 값 없이 메서드를 종류하란 뜻입니다.
	}
	balance+=money;
	System.out.printf(money+" 원 입금 끝");
}

public class Class07 {

	public static void main(String[] args) {

		AccountWithPermission a = new AccountWithPermission();
		a.initBalance(50000); //잔액 초기화
		
		Scanner sc = new Scanner(System.in);
		int selectMenu;
		
		System.out.print("메뉴 선택 : 1, 입금 2.출금, 3.잔앤확인 4.종료 ->");
		selectMenu=Integer.parseInt(sc.nextLine());
		
		while(true) {
			
			System.out.print("메뉴 선택 : 1, 입금 2.출금, 3.잔앤확인 4.종료 ->");
				switch(selectMenu) {
				case 1 :
					a.deposit(); break;
				case 2:
					a.withdraw();break;
				case 3 :
					a.display();break;
				}
		}
		System.out.println("프로그래이 종료됩니다");
	}
}
}
