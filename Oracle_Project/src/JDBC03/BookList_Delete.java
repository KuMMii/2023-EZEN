package JDBC03;

import java.util.Scanner;

public class BookList_Delete {
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.printf("삭제할 책의 번호를 입력하세요: ");
		int booknum=Integer.parseInt(sc.nextLine());
		
		BookDao bdao = new BookDao();
		int result = bdao.deleteBook(booknum);
		
		if(result==1) System.out.println("Success");
		else System.out.println("Failed");
		
	}

}
