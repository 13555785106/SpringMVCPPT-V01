package com.app12306;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/Upload")
@MultipartConfig
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*byte[] buffer = new byte[8192];
		int count  = 0;
		InputStream is = request.getInputStream();
		while((count=is.read(buffer))!=-1) {
			System.out.println(new String(buffer,0,count));
		}
		
		is.close();*/
		request.setCharacterEncoding("UTF-8");
		System.out.println(request.getContentType());
		System.out.println(request.getParts().size());
		for (Part part : request.getParts()) {
			System.out.println(part.getName());
			System.out.println(part.getContentType());
			if (part.getContentType() == null) {
				System.out.println(part.getName() + " = " + request.getParameter(part.getName()));
			} else {
				System.out.println(part.getHeader("Content-Disposition"));
			}
		}
		response.getWriter().append("aaaaaaaaa");
	}
}
