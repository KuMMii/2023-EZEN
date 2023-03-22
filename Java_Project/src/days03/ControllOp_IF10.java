package days03;

import java.util.Scanner;

public class ControllOp_IF10 {

	public static void main(String[] args) {
		
		//2023년에 한해서 월과 일을 입력 받고, 요일을 출력하세요
		// 1월 10일 입력했다면 1월 1일부터 10일까지 10일의 날짜가 계산됩니다.
		// 그를 7로 나눈 나머지를 구하면 3이고, 1:일요일 2:월요일 3:화요일...
		// 위와같이 요일을 계산합니다. 해당입력일은 수요일
		// 2월 5일 입력했다면--1월에 해당하는 31일 + 입력한 일 5 ->36
		//36을 7로 나눈 나머지 계산하면 1, 해당입력일은 일요일이 됩니다.
		
		//1. 요일을 계산할 월과 일을 입력 받습니다.
		Scanner sc = new Scanner(System.in);
		System.out.printf("월 : ");
		int m = sc.nextInt();
		System.out.printf("일 : ");
		int d = sc.nextInt();
		1 3 5 7 8 10 12
		if((1<=m&&m<8)&&(m%2==1)
				m||(8<=m&&m<=12)&&(m%2==0))
			
			
		
	}

}
