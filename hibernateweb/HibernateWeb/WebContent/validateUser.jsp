<%@page import="com.hcl.controller.SignInServlet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	String email = (String) session.getAttribute("email");

	if(email == null) {

		request.setAttribute(SignInServlet.SIGNED_IN_ERROR, true);
		
		RequestDispatcher rd = request.getRequestDispatcher("signin.jsp");
		rd.forward(request, response);
		
	}
%>
