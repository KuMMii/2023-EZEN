package days17;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

//class Point는 IO18로 이동

public class IO17 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		//랜덤한 x,y값(0~99 사이의 랜덤 값)을 갖는 객체 100개를 만들어서 ArrayList에 저장하고, 그 ArrayList를 파일에 저장
		
		ArrayList <Point> list = new ArrayList<Point>();
		
		for(int i = 0; i<100; i++) {
			//랜덤한 값으로 x,y 멤버변수값을 저장하는 객체를 생성
			int x = (int)(Math.random()*100);
			int y = (int)(Math.random()*100);
			Point p = new Point(x,y);
			list.add(p);
		}
//		int k =1;
//		for(Point p : list) {
//			System.out.printf("%s ",p);
//			if(k++% 10 ==0) System.out.println();
//		}
		File d = new File("D:\\JAVA01\\Java_se\\temp");
		if(! d.exists()) d.mkdirs();
		File file = new File(d, "Point.dat");
		
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
		
		oos.writeObject(list);
		oos.close();

	}
	 

}
