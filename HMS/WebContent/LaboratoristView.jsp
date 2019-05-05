<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href='TableRow.css' type=text/css rel='stylesheet'/><link href='BgPhoto.css' type=text/css rel='stylesheet'/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Laboratorist</title>
</head>
<body>
<form action=LaboratoristSubmit>
<center>
<table>
<tr><caption><h3><i>Add Laboratorist</i></h3></caption></tr>
<tr><td><b><i>Laboratorist Id:</i></b></td><td><input type=text size=30 name=lid></td></tr>
<tr><td><b><i>Name:</i></b></td><td><input type=text size=30 name=lname></td></tr>
<tr><td><b><i>Email:</i></b></td><td><input type=email size=30 name=lemail></td></tr>
<tr><td><b><i>Password</i></b></td><td><input type="password" size=30 name=lpwd></td></tr>
<tr><td><b><i>Address:</i></b></td><td><textarea rows="4" cols="30" name=ladd></textarea></td></tr>
<tr><td><b><i>Phone:</i></b></td><td><input type=text size=15 name=lph></td></tr>
<tr><td><input type="submit"></td><td><input type="reset"></td></tr>
</table>
</form>
</center>
</body>
</html>