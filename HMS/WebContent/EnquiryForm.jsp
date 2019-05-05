<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href='TableRow.css' type=text/css rel='stylesheet'/><link href='BgPhoto.css' type=text/css rel='stylesheet'/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enquiry Form</title>
</head>
<form action="EnquirySubmit">
<body>
<center>
<table>
<caption><h3>Enquiry Form</h3></caption>
<tr><td><b><i>Name:</i></b></td><td><input type=text size=30 name=pname></td></tr>
<tr><td><b><i>Email:</i></b></td><td><input type=email size=50 name=pemail></td></tr>
<tr><td><b><i>Phone:</i></b></td><td><input type=text size=15 name=pph></td></tr>
<tr><td><b><i>Sex:</i></b></td><td><input type=radio name=gend value=Male>Male&nbsp;&nbsp;&nbsp;&nbsp;<input type=radio value=Female name=gend>Female</td></tr>
<tr><td><b><i>Description:</i></b></td><td><textarea rows="4" cols="40"></textarea></td></tr>
<tr><td><input type="submit"></td><td><input type="reset"></td></tr>
</table>
</center>
</body>
</form>
</html>
