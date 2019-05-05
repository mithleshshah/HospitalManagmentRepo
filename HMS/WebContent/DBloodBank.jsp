<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href='TableRow.css' type=text/css rel='stylesheet'/><link href='BgPhoto.css' type=text/css rel='stylesheet'/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Blood Bank</title>
</head>
<body>
<form action=DonorSubmit>
<center><table>
<tr><caption><h3><i>Blood Bank</i></h3></caption></tr>
<tr><td><b><i>Donorid::</i></b></td><td><input type=text size=30 name=doid></td></tr>
<tr><td><b><i>Name:</i></b></td><td><input type=text size=30 name=dname></td></tr>
<tr><td><b><i>Age:</i></b></td><td><input type=text size=30 name=dage></td></tr>
<tr><td><b><i>Sex:</i></b></td><td><input type=radio name=gend value=Male>Male&nbsp;&nbsp;&nbsp;&nbsp;<input type=radio value=Female name=gend>Female</td></tr>
<tr><td><b><i>Blood Group:</i></b></td><td><input type="text" size=4 name=dgrp></td></tr>
<tr><td><b><i>Last Donation Date:</i></b></td><td><input type="date" size=15 name=ldate></td></tr>
<tr><td><input type="submit"></td><td><input type="reset"></td></tr>
</table>
</center>
</form>
</body>
</html>