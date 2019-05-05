<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href='TableRow.css' type=text/css rel='stylesheet'/><link href='BgPhoto.css' type=text/css rel='stylesheet'/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Invoice</title>
</head>
<body>
<center>
<table>
<tr><caption><h3><b><i>Add Invoice</i></b></h3></caption></tr>
<tr><td><b><i>Invoice no.:</i></b></td><td><input type=text size=15 name=ino></td></tr>
<tr><td><b><i>Patient:</i></b></td><td><input type=text size=20 name=pi></td></tr>
<tr><td><b><i>Title:</i></b></td><td><input type=text size=40  name=ti></td></tr>
<tr><td><b><i>Amount:</i></b></td><td><input type=text size=20 name=ai></td></tr>
<tr><td><b><i>Description:</i></b></td><td><textarea rows="4" cols="50" name=idesc></textarea></td></tr>
<tr><td><b><i>status:</i></b></td><td><input type=text size=20 name=si></td></tr>
<tr><td><input type="submit"></td><td><input type="reset"></td></tr>
</table>
</center>
</body>
</html>