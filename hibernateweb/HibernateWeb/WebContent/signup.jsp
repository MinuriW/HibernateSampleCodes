<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign up</title>
</head>
<body>
    <center>
        <h1>Sign up</h1>
        <form action="signup" method="POST">
            <table>
                <tr>
                    <td>
                        First Name
                    </td>
                    <td>
                        <input type="text" name="firstName" />
                    </td>
                </tr>
                <tr>
                    <td>
                        Last Name
                    </td>
                    <td>
                        <input type="text" name="lastName" />
                    </td>
                </tr>
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
                        <input type="submit" value="Sign up" />
                    </td>
                </tr>
            </table>
        </form>
    </center>
</body>
</html>