<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href='TableRow.css' type=text/css rel='stylesheet'/><link href='BgPhoto.css' type=text/css rel='stylesheet'/>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Bed</title>
</head>
<body>
<form action="BedSubmit">
<center>
<table>
<caption><b><i>Add Bed</i></b></caption>
<tr><td>Bed number:</td><td><input type=text size=30 name=bno></td></tr>
<tr><td>Ward:</td><td>
<select name=wtyp>
<option>Ward</option>
<option value=w1>Ward-1</option>
<option value=w2>Ward-2</option>
<option value=w3>Ward-3</option>
</select></td></tr>
<tr><td>Description:</td><td><textarea rows="4" cols="30" name=desc></textarea></td></tr>
<tr><td><input type=submit></td><td><input type=reset></td></tr>
</table>
</center>
</form>
</body>
</html>