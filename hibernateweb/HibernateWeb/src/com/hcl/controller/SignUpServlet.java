package com.hcl.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcl.user.service.UserService;
import com.hcl.user.service.UserServiceImpl;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
	
	
	
	public static final String NEW_USER = "NEW_USER";
	public static final String SIGNUP_ERROR = "SIGNUP_ERROR";
	private UserService userService;
	
	
	
	
	public SignUpServlet() {
		super();
		userService = new UserServiceImpl();
	}




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Boolean isSignedUp = userService.signUpUser(firstName, lastName, email, password);
		
		String resource = null;
		RequestDispatcher rd = null;
		if(isSignedUp) { // happy path
			resource = "signin.jsp";
			request.setAttribute(NEW_USER, true);
		} else { // sad path
			resource = "signup.jsp";
			request.setAttribute(SIGNUP_ERROR, true);
		}
		rd = request.getRequestDispatcher(resource);
		rd.forward(request, response);
	}

}
