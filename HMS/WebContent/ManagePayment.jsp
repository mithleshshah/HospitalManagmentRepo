<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href='TableRow.css' type=text/css rel='stylesheet'/><link href='BgPhoto.css' type=text/css rel='stylesheet'/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Payment</title>
</head>
<body>
<table>
<tr><caption><h3><i>Payment</i></h3></caption></tr>
<tr><td><b><i>Date:</i></b></td><td><input type=date size=15 name=pydate></td></tr>
<tr><td><b><i>Amount:</i></b></td><td><input type=text size=30 name=pyamt></td></tr>
<tr><td><b><i>Payment for:</i></b></td><td><input type=text size=30 name=pyt></td></tr>
<tr><td><b><i>Transaction id</i></b></td><td><input type="text" size=30 name=pytr></td></tr>
<tr><td><b><i>Patient:</i></b></td><td><input type=text size=30 name=pyp></td></tr>
<tr><td><b><i>method:</i></b></td><td><input type=text size=10 name=pym></td></tr>
<tr><td><b><i>Description:</i></b></td><td><textarea rows="4" cols="50" name=pydesc></textarea></td></tr>
<tr><td><input type="submit"></td><td><input type="reset"></td></tr>
</table>
</body>
</html>