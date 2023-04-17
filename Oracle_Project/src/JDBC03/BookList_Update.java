package JDBC03;

import java.util.Scanner;

public class BookList_Update {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		System.out.print("수정할 도서의 도서번호를 입력하세요 : ");
		String booknum=sc.nextLine();
		
		BookDao bdao = new BookDao();
		BookDto bdto = null;
		
		//입력받은 도서코드로 도서를 조회해서 리턴받음
		
		bdto = bdao.getBook(booknum);
		
		if(bdto ==null) {
			System.out.println("입력한 도서가 없습니다.");
			return;
		}
		
		String temp="";
		System.out.printf("도서 제목 : %s\n",bdto.getSubject());
		System.out.println("수정할 제목을 입력하세요(수정하지 않으려면 엔터를 입력하세요) : ");
		temp=sc.nextLine();
		if(!temp.equals("")) bdto.setSubject(temp);
		
		temp="";
		System.out.printf("출판 년도 : %d\n",bdto.getMakeyear());
		System.out.println("수정할 출판년도를 입력하세요(수정하지 않으려면 엔터를 입력하세요) : ");
		temp=sc.nextLine();
		if(!temp.equals("")) bdto.setMakeyear(Integer.parseInt(temp));
		
		temp="";
		System.out.printf("입고 가격 : %d\n",bdto.getInprice());
		System.out.println("수정할 입고가격을 입력하세요(수정하지 않으려면 엔터를 입력하세요) : ");
		temp=sc.nextLine();
		if(!temp.equals("")) bdto.setInprice(Integer.parseInt(temp));
		
		temp="";
		System.out.printf("대여 가격 : %d\n",bdto.getRentprice());
		System.out.println("수정할 대여가격을 입력하세요(수정하지 않으려면 엔터를 입력하세요) : ");
		temp=sc.nextLine();
		if(!temp.equals("")) bdto.setRentprice(Integer.parseInt(temp));
		
		temp="";
		System.out.printf("나이 등급 : %s\n",bdto.getGrade());
		System.out.println("수정할 나이등급을 입력하세요(수정하지 않으려면 엔터를 입력하세요) : ");
		temp=sc.nextLine();
		if(!temp.equals("")) bdto.setGrade(temp);
		
		int result= bdao.updateBook(bdto);
		if(result==1) System.out.println("Success");
		else System.out.println("Failed");
		
		
		
	}
}
