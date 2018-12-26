package com.sample.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sample.model.User;

@Controller

public class ResourceController {

	private static final Log logger = LogFactory.getLog(ResourceController.class);

	@RequestMapping(value = "/login")
	public String login(@ModelAttribute User login, HttpSession session, HttpServletRequest request, Model model,@RequestHeader(required=false) String referer) {
		System.out.println(request.getRequestURI());
		System.out.println(login);
		if ("sa".equals(login.getUserName()) && "123".equals(login.getPassword())) {
			System.out.println("登录成功");
			session.setAttribute("username", "sa");
			if (referer != null) {
				System.out.println(referer);
				if (!referer.contains(request.getRequestURI()))
					return "redirect:" + referer;
				else
					return "redirect:index.jsp";
			}
		}
		model.addAttribute("login", login);
		return "LoginForm";
	}

	@RequestMapping(value = "/image-get/{id}")
	public String imageGet(@PathVariable String id, HttpSession session, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		if (session == null || session.getAttribute("username") == null) {
			model.addAttribute("login", new User());
			return "LoginForm";
		}
		String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/image");
		File file = new File(dataDirectory, id + ".jpg");
		if (file.exists()) {
			response.setContentType("image/jpeg");
			response.addHeader("Content-Disposition", "attachment; filename=" + id + ".jpg");
			byte[] buffer = new byte[1024];
			FileInputStream fis = null;
			BufferedInputStream bis = null;
			// if using Java 7, use try-with-resources
			try {
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				OutputStream os = response.getOutputStream();
				int i = bis.read(buffer);
				while (i != -1) {
					os.write(buffer, 0, i);
					i = bis.read(buffer);
				}
			} catch (IOException ex) {
				// do something,
				// probably forward to an Error page
			} finally {
				if (bis != null) {
					try {
						bis.close();
					} catch (IOException e) {
					}
				}
				if (fis != null) {
					try {
						fis.close();
					} catch (IOException e) {
					}
				}
			}
		}
		return null;
	}
}
