<%@page import="com.hcl.controller.SignInServlet"%>
<%@page import="com.hcl.controller.SignUpServlet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign In</title>
</head>
<body>
    <center>
    	<%
    		Boolean isNewUser = (Boolean) request.getAttribute(SignUpServlet.NEW_USER);
    		Boolean isSignInError = (Boolean) request.getAttribute(SignInServlet.SIGNIN_ERROR);
    		Boolean isSignedInError = (Boolean) request.getAttribute(SignInServlet.SIGNED_IN_ERROR);
    		if(isNewUser != null && isNewUser) {
    	%>
        	<div style='color: green'>Sign up successful. Please Sign in to use our app</div>
        <%	} else if(isSignInError != null && isSignInError)  {%>
        	<div style='color: red'>Sign in unsuccessful. Please enter valid email and password</div>
        <% }else if(isSignedInError != null && isSignedInError)  {%>
        	<div style='color: red'>Please Sign in to use our app</div>
        <% }%>
        <h1>Sign in</h1>
        <form action="signIn" method="POST">
            <table>
                <tr>
                    
                    <td>
                        Email
                    </td>
                    <td>
                        <input type="text" name="email" />
                    </td>
                </tr>
                <tr>
                    
                    <td>
                        Password
                    </td>
                    <td>
                        <input type="password" name="password" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Sign in" />
                    </td>
                </tr>
            </table>
        </form>
    </center>
</body>
</html>