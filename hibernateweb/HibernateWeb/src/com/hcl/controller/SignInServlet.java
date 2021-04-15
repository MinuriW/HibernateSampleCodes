package com.hcl.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hcl.user.service.UserService;
import com.hcl.user.service.UserServiceImpl;

/**
 * Servlet implementation class SignInServlet
 */
@WebServlet(name = "signIn", urlPatterns = { "/signIn" })
public class SignInServlet extends HttpServlet {
	public static final String SIGNIN_ERROR = "SIGNIN_ERROR";
	public static final String SIGNED_IN_ERROR = "SIGNED_IN_ERROR";
	private UserService userService;

	public SignInServlet() {
		super();
		userService = new UserServiceImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Boolean isSignedIn = userService.signInUser(email, password);

		String resourcePath = null;

		if (isSignedIn) {
			resourcePath = "auctionItems.jsp";

			HttpSession session = request.getSession();
			session.setAttribute("email", email);

		} else {
			resourcePath = "signin.jsp";
			request.setAttribute(SIGNIN_ERROR, true);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(resourcePath);
		rd.forward(request, response);
	}

}
