package JDBC04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import JDBC03.BookDto;

public class MemberMain {

	public static void main(String[] args) {
	
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("\n---메뉴 선택---");
			System.out.printf("1. 데이터 열람.");
			System.out.printf("2. 데이터 추가.");
			System.out.printf("3. 데이터 수정.");
			System.out.printf("4. 데이터 삭제.");
			System.out.println("5. 프로그램 종료.");
			System.out.print(">>메뉴 선택 : ");
			String choice =sc.nextLine();
			
		if(choice.equals("5")) break;
		switch(choice) {
			case "1" : select(); break;
			case "2" : insert(); break;
			case "3" : update(); break;
			case "4" : delete(); break;
			default : System.out.println("메뉴 선택이 잘못되었습니다.");
			}
		}
		System.out.println("프로그램을 종료합니다.");
	}

	private static void select() {
		MemberDao mdao = new MemberDao();
		ArrayList<MemberDto> list = mdao.selectMember();
		System.out.println("MemberNum \t Name \t PhoneNum \t Birth \t Bpoint \t Gender \t Age");
		System.out.println("-------------------------------------------------------------------------------------");
		for(MemberDto dto: list) {
			System.out.printf(" %d \t\t %s \t %s \t %s \t %d \t %s \t %d\n",
					dto.getMembernum(), dto.getName(),dto.getPhone(),dto.getBirth(),dto.getBpoint(),
					dto.getGender(),dto.getAge() );
		}
	}
	

	private static void insert() {
		
		MemberDao mdao = new MemberDao();
		MemberDto mdto= new MemberDto();
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("이름을 입력하세요: ");
		mdto.setName(sc.nextLine());
		System.out.printf("전화번호를 입력하세요: ");
		mdto.setPhone(sc.nextLine());
		System.out.printf("성별을 입력하세요: ");
		mdto.setGender(sc.nextLine());
		System.out.printf("포인트를 입력하세요: ");
		mdto.setBpoint(Integer.parseInt(sc.nextLine()));

		//생일입력 -java.util.Date()형식의 입력 후 java.sql.Date()로의 변환이 필요
		//java.util.Date()의 입력을 위해선 SimpleDateFormat의 parse 루틴이 필요
		
		System.out.print("Type the birthday(YYYY-MM-DD) : ");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		java.util.Date d = null;
		while(true) {
			
		try {
			d =sdf.parse(sc.nextLine());
			break;
		} catch (ParseException e) {
			System.out.println("Type again(e.g. 2023-12-31) : ");
		}
		}
		//java.util.Date 를 java.sql.Date로 변환
		//d.getTime()을 java.sql.Date의 생성자의 전달인수로 넣기
		java.sql.Date birth = new java.sql.Date(d.getTime());
		mdto.setBirth(birth);

		//나이는 입력받지 않고 계산
		Calendar c = Calendar.getInstance();
		Calendar today = Calendar.getInstance();
		c.setTime(d); //c.setTime(birth); Date 자료를 Calendar자료로 변환
		int age =today.get(Calendar.YEAR) - c.get(Calendar.YEAR);
		mdto.setAge(age);
		
		
		
		int result=mdao.insertMember(mdto);
		if(result==1) System.out.println("Success");
		else System.out.println("Failed");
	}

	private static void update() {
		
		
		//필요한 객체들 생성
		MemberDto mdto = null;
		Scanner sc = new Scanner(System.in);
		MemberDao mdao = new MemberDao();
		
		String membernum;
		while(true) {
			System.out.printf("Type member's number to edit");
			membernum = sc.nextLine();
			if(membernum.equals(""))System.out.println("You should type the number.");
			else break;
		}
		
		mdto = mdao.getMember(Integer.parseInt(membernum));
		if(mdto==null) {
			System.out.println("Not our member");
			return;
		}
		
		//조회된 기존값을 먼저 출력하고 수정할 내용을 입력받음. 각 항목들 수정하지 않으려면 엔터만 입력
		String temp="";
		//이름
		System.out.printf("Name : %s\n", mdto.getName());
		System.out.print("Type the name. (If not, press Enter) : ");
		temp = sc.nextLine();
		if(!temp.equals(""))mdto.setName(temp);

		System.out.printf("Phone : %s\n", mdto.getPhone());
		System.out.print("Type the phonenum.(If not, press Enter) : ");
		temp=sc.nextLine();
		if(!temp.equals(""))mdto.setPhone(temp);
		
		System.out.printf("Gender : %s\n", mdto.getGender());
		System.out.print("Type the gender.(If not, press Enter) : ");
		temp=sc.nextLine();
		if(!temp.equals(""))mdto.setGender(temp);
		
		System.out.printf("Bpoint : %d\n", mdto.getBpoint());
		System.out.print("Type the Bpoint.(If not, press Enter) : ");
		temp=sc.nextLine();
		if(!temp.equals(""))mdto.setBpoint(Integer.parseInt(temp));
		
		
		System.out.printf("Birth : %s\n", mdto.getBirth());
		System.out.print("Type the birthday(YYYY-MM-DD) : ");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		java.util.Date d = null;
		java.sql.Date birth=null;
		while(true) {
			try {
				temp=sc.nextLine();
				if(temp.equals("") ) break; //수정을 위해 입력한 날짜가 없다면
				d =sdf.parse(temp); //String ->java.util.Date 변환
				birth = new java.sql.Date(d.getTime()); //java.sql.Date로 변환
				mdto.setBirth(birth); //입력받은 날짜를 Dto에 저장
				break;
			} catch (ParseException e) {
				System.out.println("Type again(e.g. 2023-12-31) : ");
			}
			}
		if(!temp.equals("")) { //수정을 위해 입력한 날짜가 있다면 
			Calendar c = Calendar.getInstance();
			Calendar today = Calendar.getInstance();
			c.setTime(d); //c.setTime(birth); Date 자료를 Calendar자료로 변환
			int age =today.get(Calendar.YEAR) - c.get(Calendar.YEAR);
			mdto.setAge(age);
		}
		int result = mdao.updateMember(mdto);
		if(result==1)System.out.println("Success");
		else System.out.println("Failed");
	}
		
	

	private static void delete() {
		MemberDto mdto=null;
		MemberDao mdao = new MemberDao();
		Scanner sc = new Scanner(System.in);
		
		//삭제할 회원번호를 입력받되, 없는 번호 입력시 "회원이 없습니다"출력 후 종료하기
		String membernum;
		while(true) {
			
		System.out.print("Type a membernum to delete : ");
		
		membernum=sc.nextLine();
		if(membernum.equals("")) {
			System.out.println("Membernum is mandatory.");
		}else break;
		}
		mdto=mdao.getMember(Integer.parseInt(membernum));
		if(mdto==null) {
			System.out.println("Not our member");
			return;
		}
		int result=mdao.deleteMember(Integer.parseInt(membernum));
		
		
		
		if(result==1) System.out.println("Success");
		else System.out.println("Failed");
		
	}
}
