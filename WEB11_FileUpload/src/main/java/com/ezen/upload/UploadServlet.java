package com.ezen.upload;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/upload.do")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		// 1.파일이 업로드 될 타겟폴더를 지정, String으로 저장해둠
		String savePath = "upload";

		// 2. 업로드될 파일의 용량을 제한하기 위한 용량값을 int변수에 저장해둠
		int uploadFileSizeLimit = 5 * 1024 * 1024;
		// 1바이트 기준 1024byte=1Kbyte
		// 1024KByte =1MB

		// 3. 인코딩 방식을 String 변수에 저장해둠
		String encType = "UTF-8";

		// 4.업로드될 서버에 실제 저장장소를 얻어서 upload 폴더를 만들고 그 경로를 String 변수에 저장해 둠
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);

		System.out.println(uploadFilePath);

		
		String name=request.getParameter("name"); 
		String title=request.getParameter("title");
		
		System.out.println("기존 request로 전달받은 데이터 출력");
		System.out.println("name : "+name); 
		System.out.println("title : "+title);
		//출력내용의 결과: 전부 null 
		System.out.println("multipart/form-data로 보낸 파라미터는 request만으로 받아서 저장할 수 없음");
		  
		 
		// 5.MultipartRequest 객체를 생성해서 업로드를 마무리함
		MultipartRequest multi = new MultipartRequest(
			request, //jsp에서 전달된 request 객체를 MultipartRequest로 전달함
			//MultipartRequest에 request를 넣어서 복합사용해야 담겨있는 유효한 값을 얻을 수 있음
			uploadFilePath, //서버상의 실제 저장장소
			uploadFileSizeLimit, //최대업로드 용량 제한
			encType, //인코딩 방식
			new DefaultFileRenamePolicy() //저장장소에 업로드되는 파일이름 중복시 문제해결하는 객체
			//이게 안되면 업로드시간 밀리초를 저장해 파일 제목으로 넣어 구분함
		); 
		//MultipartRequest 객체가 생성되는 순간 업로드 되는 파일은 해당 결로에 업로드를 완료함
		
		name=multi.getParameter("name");
		title=multi.getParameter("title");
		String fileName=multi.getFilesystemName("uploadFile");//index.jsp에서 지정한 filename 그대로 지정해줘야함!
		String originName = multi.getOriginalFileName("uploadFile");
		System.out.println("multi로 받은 데이터 출력");
		System.out.println("name : "+name); 
		System.out.println("title : "+title);
		System.out.println("fileName : "+fileName);
		System.out.println("OriginalfileName : "+originName);
		
		request.setAttribute("name", name);
		request.setAttribute("title", title);
		request.setAttribute("fileName", fileName);
		
		RequestDispatcher dp = request.getRequestDispatcher("01_result.jsp");
		dp.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
