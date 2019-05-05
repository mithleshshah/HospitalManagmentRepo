<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href='TableRow.css' type=text/css rel='stylesheet'/><link href='BgPhoto.css' type=text/css rel='stylesheet'/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accountant</title>
<body>
<form action="AccountantSubmit" method=post enctype='multipart/form-data'>
<center>
<table>
<tr><caption><h3><i>Add Accountant</i></h3></caption></tr>
<tr><td><b><i>Accountant Id:</i></b></td><td><input type=text size=30 name=acid></td></tr>
<tr><td><b><i>Name:</i></b></td><td><input type=text size=30 name=acname></td></tr>
<tr><td><b><i>Email:</i></b></td><td><input type=email size=30 name=acemail></td></tr>
<tr><td><b><i>Password</i></b></td><td><input type="password" size=30 name=acpwd></td></tr>
<tr><td><b><i>Address:</i></b></td><td><textarea rows="4" cols="30" name=acadd></textarea></td></tr>
<tr><td><b><i>Phone:</i></b></td><td><input type=text size=15 name=acph></td></tr>
<tr><td><b><i>Image:</i></b></td><td><input type=file size=40 name=aicon></td></tr>
<tr><td><input type="submit"></td><td><input type="reset"></td></tr>
</table>
</form>
</center>
</body>
</html>