<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href='TableRow.css' type=text/css rel='stylesheet'/><link href='BgPhoto.css' type=text/css rel='stylesheet'/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Patient</title>
</head>
<body>
<form action=PatientSubmit method=post enctype='multipart/form-data'>
<center>
<table border=1 bgcolor=skyblue>
<tr><caption><h3><i>Add Patient</i></h3></caption></tr>
<tr><td><b><i>Patient Id:</i></b></td><td><input type=text size=15 name=pid></td></tr>
<tr><td><b><i>Name:</i></b></td><td><input type=text size=30 name=pname></td></tr>
<tr><td><b><i>Email:</i></b></td><td><input type=email size=50 name=pemail></td></tr>
<tr><td><b><i>Password</i></b></td><td><input type="password" size=30 name=ppwd></td></tr>
<tr><td><b><i>Address:</i></b></td><td><textarea rows="4" cols="30" name=padd></textarea></td></tr>
<tr><td><b><i>Phone:</i></b></td><td><input type=text size=15 name=pph></td></tr>
<tr><td><b><i>Sex:</i></b></td><td><input type=radio name=gend value=Male>Male&nbsp;&nbsp;&nbsp;&nbsp;<input type=radio value=Female name=gend>Female</td></tr>
<tr><td><b><i>Birth Date:</i></b></td><td><input type="date" size=20 name=pbd></td></tr>
<tr><td><b><i>Age:</i></b></td><td><input type=text size=4 name=page></td></tr>
<tr><td><b><i>Blood Group:</i></b></td><td><input type=text size=4 name=pbg></td></tr>
<tr><td><b><i>Image:</i></b></td><td><input type=file name=picon size=40></td></tr>
<tr><td><input type="submit"></td><td><input type="reset"></td></tr>
</table>
</center>
</form>
</body>
</html>