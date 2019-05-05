<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href='TableRow.css' type=text/css rel='stylesheet'/><link href='BgPhoto.css' type=text/css rel='stylesheet'/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action=MedCatSubmit>
<center>
<table>
<caption><b><i>Add medicine category</i></b></caption>
<tr><td>Medicine Category Id.</td><td><input type=text size=30 name=mcid></td></tr>
<tr><td>Medicine category:</td><td><input type=text size=30 name=medc></td></tr>
<tr><td>Description:</td><td><textarea rows=4 cols=30 name=meddesc></textarea></td></tr>
<tr><td><input type=submit></td><td><input type=reset></td></tr>
</table>
</center>
</form>
</body>
</html>