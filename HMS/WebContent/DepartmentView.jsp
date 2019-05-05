<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href='TableRow.css' type=text/css rel='stylesheet'/><link href='BgPhoto.css' type=text/css rel='stylesheet'/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Department</title>
</head>
<body>

<form action="DepartmentSubmit" method=post>
<center>
<table border=1 bgcolor=skyblue>
<caption><h3><i>Department Register</i></h3></caption>
<tr><td><b><i>Department Id:</i></b></td><td><input type=text size=15 name=deptid></td></tr>
<tr><td><b><i>Department Name:</i></b></td><td><input type=text size=30 name=deptn></td></tr>
<tr><td><b><i>Department Description:</i></b></td><td><textarea rows="10" cols="50" name=deptdesc></textarea></td></tr>
<tr><td><input type="submit">&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset"></td></tr>
</table>
</center>
</form>
</body>
</html>