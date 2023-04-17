package JDBC03;

import java.util.Scanner;

public class BookList_Insert {

	public static void main(String[] args) {
		
		BookDto bdto = new BookDto();

		Scanner sc=new Scanner(System.in);
		System.out.printf("제목을 입력하세요: ");
//		String subject=sc.nextLine();
		bdto.setSubject(sc.nextLine());
		System.out.printf("출판년도를 입력하세요: ");
//		String makeyear=sc.nextLine();
		bdto.setMakeyear(Integer.parseInt(sc.nextLine()));
		System.out.printf("입고가격을 입력하세요: ");
//		String inprice=sc.nextLine();
		bdto.setInprice(Integer.parseInt(sc.nextLine()));
		System.out.printf("대여가격을 입력하세요: ");
//		String rentprice=sc.nextLine();
		bdto.setRentprice(Integer.parseInt(sc.nextLine()));
		System.out.printf("등급을 입력하세요: ");
//		String grade=sc.nextLine();
		bdto.setGrade(sc.nextLine());
		
		BookDao bdao= new BookDao();
//		bdao.insertBook(subject, makeyear, inprice, rentprice, grade);
		
//		bdto.setMakeyear(Integer.parseInt(makeyear));
//		bdto.setInprice(Integer.parseInt(inprice));
//		bdto.setRentprice(Integer.parseInt(rentprice));
//		bdto.setGrade(grade);
//		bdto.setSubject(subject);

		int result=bdao.insertBook(bdto);
		
		if(result==1) System.out.println("Success");
		else System.out.println("Failed");
		
		
	}
}
